package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PresenceLog
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T13:55:28.185521900+01:00[Europe/Berlin]")
public class PresenceLog {

  private Long id;

  private Long areaId;

  private Long statusId;

  private Long zeitpunkt;

  public PresenceLog id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PresenceLog areaId(Long areaId) {
    this.areaId = areaId;
    return this;
  }

  /**
   * Get areaId
   * @return areaId
  */
  
  @Schema(name = "areaId", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("areaId")
  public Long getAreaId() {
    return areaId;
  }

  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }

  public PresenceLog statusId(Long statusId) {
    this.statusId = statusId;
    return this;
  }

  /**
   * Get statusId
   * @return statusId
  */
  
  @Schema(name = "statusId", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusId")
  public Long getStatusId() {
    return statusId;
  }

  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }

  public PresenceLog zeitpunkt(Long zeitpunkt) {
    this.zeitpunkt = zeitpunkt;
    return this;
  }

  /**
   * Get zeitpunkt
   * @return zeitpunkt
  */
  
  @Schema(name = "zeitpunkt", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("zeitpunkt")
  public Long getZeitpunkt() {
    return zeitpunkt;
  }

  public void setZeitpunkt(Long zeitpunkt) {
    this.zeitpunkt = zeitpunkt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PresenceLog presenceLog = (PresenceLog) o;
    return Objects.equals(this.id, presenceLog.id) &&
        Objects.equals(this.areaId, presenceLog.areaId) &&
        Objects.equals(this.statusId, presenceLog.statusId) &&
        Objects.equals(this.zeitpunkt, presenceLog.zeitpunkt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, areaId, statusId, zeitpunkt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PresenceLog {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    areaId: ").append(toIndentedString(areaId)).append("\n");
    sb.append("    statusId: ").append(toIndentedString(statusId)).append("\n");
    sb.append("    zeitpunkt: ").append(toIndentedString(zeitpunkt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

