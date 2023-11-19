package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.Day;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ModelConfiguration
 */

@JsonTypeName("Configuration")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T13:55:28.185521900+01:00[Europe/Berlin]")
public class ModelConfiguration {

  private Long id;

  private Long uhrzeit;

  private Long maxDauer;

  private Boolean aktiv;

  @Valid
  private List<@Valid Day> days;

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

  public ModelConfiguration uhrzeit(Long uhrzeit) {
    this.uhrzeit = uhrzeit;
    return this;
  }

  /**
   * Get uhrzeit
   * @return uhrzeit
  */
  
  @Schema(name = "uhrzeit", example = "123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uhrzeit")
  public Long getUhrzeit() {
    return uhrzeit;
  }

  public void setUhrzeit(Long uhrzeit) {
    this.uhrzeit = uhrzeit;
  }

  public ModelConfiguration maxDauer(Long maxDauer) {
    this.maxDauer = maxDauer;
    return this;
  }

  /**
   * Get maxDauer
   * @return maxDauer
  */
  
  @Schema(name = "maxDauer", example = "123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxDauer")
  public Long getMaxDauer() {
    return maxDauer;
  }

  public void setMaxDauer(Long maxDauer) {
    this.maxDauer = maxDauer;
  }

  public ModelConfiguration aktiv(Boolean aktiv) {
    this.aktiv = aktiv;
    return this;
  }

  /**
   * Get aktiv
   * @return aktiv
  */
  
  @Schema(name = "aktiv", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("aktiv")
  public Boolean getAktiv() {
    return aktiv;
  }

  public void setAktiv(Boolean aktiv) {
    this.aktiv = aktiv;
  }

  public ModelConfiguration days(List<@Valid Day> days) {
    this.days = days;
    return this;
  }

  public ModelConfiguration addDaysItem(Day daysItem) {
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
  public List<@Valid Day> getDays() {
    return days;
  }

  public void setDays(List<@Valid Day> days) {
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
        Objects.equals(this.uhrzeit, _configuration.uhrzeit) &&
        Objects.equals(this.maxDauer, _configuration.maxDauer) &&
        Objects.equals(this.aktiv, _configuration.aktiv) &&
        Objects.equals(this.days, _configuration.days);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, uhrzeit, maxDauer, aktiv, days);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelConfiguration {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uhrzeit: ").append(toIndentedString(uhrzeit)).append("\n");
    sb.append("    maxDauer: ").append(toIndentedString(maxDauer)).append("\n");
    sb.append("    aktiv: ").append(toIndentedString(aktiv)).append("\n");
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

