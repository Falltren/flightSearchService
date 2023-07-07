import lombok.Data;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

@Data
public class Flight implements Comparable<Flight> {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private final DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(new Locale("EN"));
    private final DecimalFormat decimalFormat = new DecimalFormat("0.#", decimalFormatSymbols);

    private String code;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String flightTime;
    private String iataCodeDepartureAirport;
    private String iataCodeArrivalAirport;
    private double ticketPrice;

    public Flight(String code, LocalDate departureDate, LocalTime departureTime, String flightTime,
                  String iataCodeDepartureAirport, String iataCodeArrivalAirport, double ticketPrice) {
        this.code = code;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.flightTime = flightTime;
        this.iataCodeDepartureAirport = iataCodeDepartureAirport;
        this.iataCodeArrivalAirport = iataCodeArrivalAirport;
        this.ticketPrice = ticketPrice;
    }

    public static LocalDate convertStringToDepartureDate(String date) {
        return LocalDate.parse(date, DATE_FORMAT);
    }

    public static LocalTime convertStringToDepartureTime(String time) {
        return LocalTime.parse(time, TIME_FORMAT);
    }

    public String toString() {
        return code + " "
                + departureDate.format(DATE_FORMAT) + " "
                + departureTime + " "
                + flightTime + " "
                + iataCodeDepartureAirport + " "
                + iataCodeArrivalAirport + " "
                + decimalFormat.format(ticketPrice);
    }

    @Override
    public int compareTo(Flight o) {
        return Comparator.comparing(Flight::getDepartureDate)
                .thenComparing(Flight::getDepartureTime)
                .thenComparing(Flight::getCode).compare(this, o);
    }
}
