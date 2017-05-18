package calendar.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.PROPERTY,
        property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=HolidayRuleDayOfWeek.class, name="HolidayRuleDayOfWeek"),
        @JsonSubTypes.Type(value=HolidayRuleDayOfMonth.class, name="HolidayRuleDayOfMonth"),
        @JsonSubTypes.Type(value=HolidayRuleDate.class, name="HolidayRuleDate"),
        @JsonSubTypes.Type(value=HolidayRuleWithInterval.class, name="HolidayRuleWithInterval")
})
public abstract class HolidayRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "holiday_rule_id")
    private Long id;

    protected HolidayRule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    abstract boolean isHoliday(LocalDate aDate);
}
