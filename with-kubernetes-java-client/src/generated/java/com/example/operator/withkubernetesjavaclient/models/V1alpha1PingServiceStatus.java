/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.19.10+vmware.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.example.operator.withkubernetesjavaclient.models;

import java.util.Objects;
import java.util.Arrays;
import com.example.operator.withkubernetesjavaclient.models.V1alpha1PingServiceStatusConditions;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * V1alpha1PingServiceStatus
 */

public class V1alpha1PingServiceStatus {
  public static final String SERIALIZED_NAME_CONDITIONS = "conditions";
  @SerializedName(SERIALIZED_NAME_CONDITIONS)
  private List<V1alpha1PingServiceStatusConditions> conditions = null;


  public V1alpha1PingServiceStatus conditions(List<V1alpha1PingServiceStatusConditions> conditions) {
    
    this.conditions = conditions;
    return this;
  }

  public V1alpha1PingServiceStatus addConditionsItem(V1alpha1PingServiceStatusConditions conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

   /**
   * List of status conditions.
   * @return conditions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of status conditions.")

  public List<V1alpha1PingServiceStatusConditions> getConditions() {
    return conditions;
  }


  public void setConditions(List<V1alpha1PingServiceStatusConditions> conditions) {
    this.conditions = conditions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1PingServiceStatus v1alpha1PingServiceStatus = (V1alpha1PingServiceStatus) o;
    return Objects.equals(this.conditions, v1alpha1PingServiceStatus.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conditions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1PingServiceStatus {\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
