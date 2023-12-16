package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Objects;

/**
 * PresenceLog
 */
@Entity
@NamedQueries(
        {
                @NamedQuery(name = PresenceLog.FIND_ALL,
                        query = "from PresenceLog "),

                @NamedQuery(name = PresenceLog.FIND_BY_ID,
                        query = "from PresenceLog where id = :id")
        }
)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T14:12:38.522563+01:00[Europe/Berlin]")
public class PresenceLog {

  public static final String FIND_ALL = "PRESENCELOG.FIND.ALL";
  public static final String FIND_BY_ID = "PRESENCELOG.FIND.BY.ID";


  @Id
  @Column
  private Long id;

  @Column
  private Long areaId;

  @Column
  private Long statusId;

  @Column
  private Long timestamp;

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

  public PresenceLog timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  */
  
  @Schema(name = "timestamp", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
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
        Objects.equals(this.timestamp, presenceLog.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, areaId, statusId, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PresenceLog {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    areaId: ").append(toIndentedString(areaId)).append("\n");
    sb.append("    statusId: ").append(toIndentedString(statusId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

