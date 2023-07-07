import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Data
public class Storage {
    private List<Airport> airports;

    private Set<Flight> flights = new TreeSet<>();

    public void createAirports(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        airports = objectMapper.readValue(file, new TypeReference<>() {
        });
    }

    public Optional<Flight> findFlight(String code) {
        return flights.stream().filter(flight -> flight.getCode().contains(code)).findAny();
    }

}
