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
 * Status
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T13:55:28.185521900+01:00[Europe/Berlin]")
public class Status {

  private Long id;

  private String bezeichnung;

  public Status id(Long id) {
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

  public Status bezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
    return this;
  }

  /**
   * Get bezeichnung
   * @return bezeichnung
  */
  
  @Schema(name = "bezeichnung", example = "Mensch Anwesend", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bezeichnung")
  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equals(this.id, status.id) &&
        Objects.equals(this.bezeichnung, status.bezeichnung);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bezeichnung);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    bezeichnung: ").append(toIndentedString(bezeichnung)).append("\n");
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

