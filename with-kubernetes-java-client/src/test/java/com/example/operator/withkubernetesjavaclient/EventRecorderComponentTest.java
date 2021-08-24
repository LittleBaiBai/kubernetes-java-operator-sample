package com.example.operator.withkubernetesjavaclient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.example.operator.withkubernetesjavaclient.models.V1alpha1CatForAdoption;
import io.kubernetes.client.extended.event.EventType;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.CoreV1Event;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1ObjectReference;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.example.operator.withkubernetesjavaclient.EventRecorder.toObjectReference;
import static org.assertj.core.api.Assertions.assertThat;

@WithKubernetesCluster
class EventRecorderComponentTest {

	private static final String TEST_NAMESPACE = "default";
	private static final String TEST_CAT_NAME = "test-cat";

	@Value("${adoption-center.configMapName}") private String configMapName;
	@Value("${adoption-center.namespace}") private String configMapNamespace;
	@Autowired private CoreV1Api coreV1Api;
	@Autowired private TestK8sClient testK8sClient;
	@Autowired private EventRecorder eventRecorder;

	private V1ObjectReference involved;
	private V1ObjectReference related;

	private String eventReason;

	@BeforeAll
	void createResources() throws IOException, ApiException {
		testK8sClient.createCrd();
//		testK8sClient.createDeployment(TEST_NAMESPACE, TEST_CAT_NAME);
	}

	@AfterAll
	void deleteResources() {
		testK8sClient.deleteCat(TEST_NAMESPACE, TEST_CAT_NAME);
		testK8sClient.deleteConfigMapIfExists(configMapNamespace, configMapName);
		testK8sClient.deleteCrdIfExists();
	}

	@BeforeEach
	void setUp() {
		eventReason = "TestReason" + ThreadLocalRandom.current().nextInt();
		involved = toObjectReference(
				new V1alpha1CatForAdoption().metadata(new V1ObjectMeta().namespace(TEST_NAMESPACE)
				                                                        .name("test-cat")));
		related = toObjectReference(
				new V1ConfigMap().metadata(new V1ObjectMeta().namespace(configMapNamespace)
				                                             .name(configMapName)));
	}

	@Test
	void logEvent() throws ApiException {
		eventRecorder.logEvent(involved, related, eventReason, "logEvent", EventType.Normal);

		List<CoreV1Event> events = getEventsWithTargetReason();

		assertThat(events.size()).isEqualTo(1);
		assertThat(events.get(0).getAction()).isEqualTo("Reconcile");
		assertThat(events.get(0).getType()).isEqualTo(EventType.Normal.toString());
		assertThat(events.get(0).getInvolvedObject()).isEqualTo(involved);
		assertThat(events.get(0).getRelated()).isEqualTo(related);
		assertThat(events.get(0).getLastTimestamp()).isNotNull();
	}

	@Test
	void logEventWithoutRelatedObject() throws ApiException {
		eventRecorder.logEvent(involved, null, eventReason, "logEventWithoutRelatedObject", EventType.Normal);

		List<CoreV1Event> events = getEventsWithTargetReason();

		assertThat(events.size()).isEqualTo(1);
		assertThat(events.get(0).getAction()).isEqualTo("Reconcile");
		assertThat(events.get(0).getType()).isEqualTo(EventType.Normal.toString());
		assertThat(events.get(0).getInvolvedObject()).isEqualTo(involved);
		assertThat(events.get(0).getRelated()).isNull();
		assertThat(events.get(0).getLastTimestamp()).isNotNull();
	}

	@Test
	void logEventWithoutInvolvedObjectUid() throws ApiException {
		V1ObjectReference reference = new V1ObjectReference().name("test-name").namespace(TEST_NAMESPACE);
		eventRecorder.logEvent(reference, related, eventReason, "logEventWithoutInvolvedObject", EventType.Normal);

		List<CoreV1Event> events = getEventsWithTargetReason();

		assertThat(events.size()).isEqualTo(1);
		assertThat(events.get(0).getAction()).isEqualTo("Reconcile");
		assertThat(events.get(0).getType()).isEqualTo(EventType.Normal.toString());
		assertThat(events.get(0).getInvolvedObject()).isEqualTo(reference);
		assertThat(events.get(0).getRelated()).isEqualTo(related);
		assertThat(events.get(0).getLastTimestamp()).isNotNull();
	}

	private List<CoreV1Event> getEventsWithTargetReason() throws ApiException {
		return coreV1Api.listNamespacedEvent(TEST_NAMESPACE,
											 null,
											 null,
											 null,
											 null,
											 null,
											 null,
											 null,
											 null,
											 null,
											 null)
						.getItems()
						.stream().filter(event -> eventReason.equals(event.getReason()))
						.collect(Collectors.toList());
	}
}
