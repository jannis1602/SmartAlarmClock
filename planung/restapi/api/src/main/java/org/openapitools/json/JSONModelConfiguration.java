package org.openapitools.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.model.Day;

import javax.annotation.Generated;
import java.util.List;

@JsonTypeName("Configuration")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T14:12:38.522563+01:00[Europe/Berlin]")
public class JSONModelConfiguration {

        private Long id;

        private String alarmDate;

        private String alarmTime;

        private Boolean active;

        private List<JSONDay> days;



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



        /**
         * Get days
         * @return days
         */
        @Schema(name = "days", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        @JsonProperty("days")
        public List<JSONDay> getDays() {
            return days;
        }

        public void setDays(List<JSONDay> days) {
            this.days = days;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONModelConfiguration that = (JSONModelConfiguration) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (alarmDate != null ? !alarmDate.equals(that.alarmDate) : that.alarmDate != null) return false;
        if (alarmTime != null ? !alarmTime.equals(that.alarmTime) : that.alarmTime != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (days != null ? !days.equals(that.days) : that.days != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (alarmDate != null ? alarmDate.hashCode() : 0);
        result = 31 * result + (alarmTime != null ? alarmTime.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        return result;
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
