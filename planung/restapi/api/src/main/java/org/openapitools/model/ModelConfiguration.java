package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * ModelConfiguration
 */

@Entity
@Table(name = "Alarm")
@NamedQueries(
        {
                @NamedQuery(name = ModelConfiguration.FIND_ALL,
                        query = "from ModelConfiguration"),

                @NamedQuery(name = ModelConfiguration.FIND_BY_ID,
                        query = "from ModelConfiguration where id = :id")
        }
)
@JsonTypeName("Configuration")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T14:12:38.522563+01:00[Europe/Berlin]")
public class ModelConfiguration {

  public static final String FIND_ALL = "Modelconfiguration.findall";
  public static final String FIND_BY_ID = "Modelconfiguration.find.id";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column(name = "ALARM_DATE")
  private String alarmDate;

  @Column(name = "ALARM_TIME")
  private String alarmTime;

  @Column
  private Boolean active;

  @Valid
//  @OneToMany(cascade = CascadeType.ALL)

//  @JoinColumn(name = "id")
  @OneToMany(mappedBy = "id.modelConfiguration", cascade = CascadeType.ALL)
//  @JsonManagedReference
  private List<@Valid ModelConfigurationDayZuordnung> days;

  public ModelConfiguration id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  /**
   * Get timestamp
   * @return timestamp
  */
  
  @Schema(name = "alarmDate", example = "2023-12-23", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("alarmDate")
  public String getAlarmDate() {
    return alarmDate;
  }

  public void setAlarmDate(String date) {
    this.alarmDate = date;
  }

  public ModelConfiguration alarmDate(String date){
    this.alarmDate = date;
    return this;
  }


  /**
   * Get maxDuration
   * @return maxDuration
  */
  
  @Schema(name = "alarmTime", example = "05:12", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("alarmTime")
  public String getAlarmTime() {
    return alarmTime;
  }

  public void setAlarmTime(String time) {
    this.alarmTime = time;
  }

  public ModelConfiguration alarmTime(String time){
    this.alarmTime = time;
    return this;
  }

  public ModelConfiguration active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  */
  
  @Schema(name = "active", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("active")
  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ModelConfiguration days(List<@Valid ModelConfigurationDayZuordnung> days) {
    this.days = days;
    return this;
  }

  public ModelConfiguration addDaysItem(ModelConfigurationDayZuordnung daysItem) {
    if (this.days == null) {
      this.days = new ArrayList<>();
    }
    this.days.add(daysItem);
    return this;
  }

  /**
   * Get days
   * @return days
  */
  @Valid 
  @Schema(name = "days", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("days")
  public List<@Valid ModelConfigurationDayZuordnung> getDays() {
    return days;
  }

  public void setDays(List<@Valid ModelConfigurationDayZuordnung> days) {
    this.days = days;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelConfiguration _configuration = (ModelConfiguration) o;
    return Objects.equals(this.id, _configuration.id) &&
        Objects.equals(this.alarmDate, _configuration.alarmDate) &&
        Objects.equals(this.alarmTime, _configuration.alarmTime) &&
        Objects.equals(this.active, _configuration.active) &&
        Objects.equals(this.days, _configuration.days);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, alarmDate, alarmTime, active, days);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelConfiguration {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    alarmDate: ").append(toIndentedString(alarmDate)).append("\n");
    sb.append("    alarmTime: ").append(toIndentedString(alarmTime)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
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

