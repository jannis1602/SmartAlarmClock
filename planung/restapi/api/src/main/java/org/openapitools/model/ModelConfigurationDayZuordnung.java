package org.openapitools.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Alarm_Day_Relation")
@NamedQueries(
        {
                @NamedQuery(name = ModelConfigurationDayZuordnung.FIND_ALL,
                        query = "from ModelConfigurationDayZuordnung"),

                @NamedQuery(name = ModelConfigurationDayZuordnung.FIND_BY_ALARM,
                        query = "from ModelConfigurationDayZuordnung where id.modelConfiguration = :id")
        }
)
public class ModelConfigurationDayZuordnung  implements Serializable {

    @Embeddable
    public static class KeyAlarmDay implements Serializable{

        @ManyToOne
        @JoinColumn(name = "ALARM_ID")
//        @JsonIgnore
        @JsonBackReference
//        @GeneratedValue(strategy = GenerationType.TABLE)
        private ModelConfiguration modelConfiguration;
        @ManyToOne
//        @JsonBackReference
        @JoinColumn(name = "DAY_ID")
//        @GeneratedValue(strategy = GenerationType.TABLE)
        private Day day;

        public KeyAlarmDay() {
        }

        public ModelConfiguration getModelConfiguration() {
            return modelConfiguration;
        }

        public void setModelConfiguration(ModelConfiguration modelConfiguration) {
            this.modelConfiguration = modelConfiguration;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KeyAlarmDay that = (KeyAlarmDay) o;

            if (!Objects.equals(modelConfiguration, that.modelConfiguration))
                return false;
            return Objects.equals(day, that.day);
        }

        @Override
        public int hashCode() {
            int result = modelConfiguration != null ? modelConfiguration.hashCode() : 0;
            result = 31 * result + (day != null ? day.hashCode() : 0);
            return result;
        }
    }
    public static final String FIND_ALL = "ModelConfigurationDayZuordnung.find.all";
    public static final String FIND_BY_ALARM = "ModelConfigurationDayZuordnung.find.by.id";


    @EmbeddedId
    private KeyAlarmDay id;

    @Column
    private Boolean active;


    public KeyAlarmDay getId() {
        return id;
    }

    public void setId(KeyAlarmDay id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
