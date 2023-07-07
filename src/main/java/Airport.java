import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Airport {

    private String name;
    private String code;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("time_zone")
    private String timeZone;

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
