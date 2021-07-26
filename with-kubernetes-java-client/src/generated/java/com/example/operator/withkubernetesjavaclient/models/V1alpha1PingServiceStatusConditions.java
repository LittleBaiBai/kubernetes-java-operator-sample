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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * V1alpha1PingServiceStatusConditions
 */

public class V1alpha1PingServiceStatusConditions {
  public static final String SERIALIZED_NAME_LAST_TRANSITION_TIME = "lastTransitionTime";
  @SerializedName(SERIALIZED_NAME_LAST_TRANSITION_TIME)
  private String lastTransitionTime;

  public static final String SERIALIZED_NAME_REASON = "reason";
  @SerializedName(SERIALIZED_NAME_REASON)
  private String reason;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;


  public V1alpha1PingServiceStatusConditions lastTransitionTime(String lastTransitionTime) {
    
    this.lastTransitionTime = lastTransitionTime;
    return this;
  }

   /**
   * Last time the condition of a type changed from one status to another. The required format is &#39;yyyy-MM-ddTHH:mm:ssZ&#39;, in the UTC time zone.
   * @return lastTransitionTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Last time the condition of a type changed from one status to another. The required format is 'yyyy-MM-ddTHH:mm:ssZ', in the UTC time zone.")

  public String getLastTransitionTime() {
    return lastTransitionTime;
  }


  public void setLastTransitionTime(String lastTransitionTime) {
    this.lastTransitionTime = lastTransitionTime;
  }


  public V1alpha1PingServiceStatusConditions reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * The reason for the condition&#39;s last transition (a single word in CamelCase).
   * @return reason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The reason for the condition's last transition (a single word in CamelCase).")

  public String getReason() {
    return reason;
  }


  public void setReason(String reason) {
    this.reason = reason;
  }


  public V1alpha1PingServiceStatusConditions status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * The status of the condition, either True, False or Unknown.
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The status of the condition, either True, False or Unknown.")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public V1alpha1PingServiceStatusConditions type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The unique identifier of a condition, used to distinguish between other conditions in the resource.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unique identifier of a condition, used to distinguish between other conditions in the resource.")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1PingServiceStatusConditions v1alpha1PingServiceStatusConditions = (V1alpha1PingServiceStatusConditions) o;
    return Objects.equals(this.lastTransitionTime, v1alpha1PingServiceStatusConditions.lastTransitionTime) &&
        Objects.equals(this.reason, v1alpha1PingServiceStatusConditions.reason) &&
        Objects.equals(this.status, v1alpha1PingServiceStatusConditions.status) &&
        Objects.equals(this.type, v1alpha1PingServiceStatusConditions.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastTransitionTime, reason, status, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1PingServiceStatusConditions {\n");
    sb.append("    lastTransitionTime: ").append(toIndentedString(lastTransitionTime)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

