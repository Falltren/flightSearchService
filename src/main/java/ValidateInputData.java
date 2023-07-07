import lombok.Data;

@Data
public class ValidateInputData {

    private final Storage storage;

    public ValidateInputData(Storage storage){
        this.storage = storage;
    }

    public boolean checkCode(String code){
        return code.matches("\\w{4}");
    }

    public boolean checkDate(String date){
        return date.matches("(0[1-9]|[12][\\d]|3[01])/(0[1-9]|1[012])/202[3-9]{1}|20[3-9]{1}\\d{1}");
    }

    public boolean checkDepartureTime(String departureTime){
        return departureTime.matches("([0-1][\\d]|2[0-4]):[0-5][\\d]");
    }

    public boolean checkFlightTime(String flightTime){
        return flightTime.matches("(([0-1][\\d]|2[0-4]).[0-5][\\d])|(.[0-5][\\d])");
    }

    public boolean checkIataCode(String iataCode){
        return iataCode.matches("[A-zА-я]{3}");
    }

    public boolean isExistAirport(String iataCode){
        return storage.getAirports().stream().map(Airport::getCode).toList().contains(iataCode);
    }

    public boolean checkPrice(double price){
        return price > 0;
    }
}
