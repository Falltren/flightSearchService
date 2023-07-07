import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    private final Storage storage;

    private final ValidateInputData validateInputData;
    private final Message message = new Message();
    private boolean isStop;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Storage storage) {
        this.storage = storage;
        this.validateInputData = new ValidateInputData(storage);
    }

    public void displayMainMenu() {
        while (!isStop) {
            System.out.println(message.MAIN_MENU);
            System.out.println(message.MENU_ITEM_SELECTION);
            int selection = scanner.nextInt();
            if (selection < 0 || selection > 3) {
                System.out.println(message.INCORRECT_MENU_NUMBER);
            }
            switch (selection) {
                case 1 -> displayAddFlightMenu();
                case 2 -> displayAllFlights();
                case 3 -> displayFindFlightMenu();
                case 0 -> isStop = true;
            }
        }
    }

    private void displayAllFlights() {
        Set<Flight> flights = storage.getFlights();
        if (flights.isEmpty()) {
            System.out.println(message.EMPTY_FLIGHT_LIST);
        } else {
            flights.forEach(f -> System.out.println(message.OUTPUT_FLIGHT_INFORMATION + f));
        }
    }

    private void displayAddFlightMenu() {
        System.out.println(message.ADDING_FLIGHT_MENU[0]);
        System.out.print(message.ADDING_FLIGHT_MENU[1]);
        String code = inputCode();
        System.out.print(message.ADDING_FLIGHT_MENU[2]);
        LocalDate departureDate = Flight.convertStringToDepartureDate(inputDepartureDate());
        System.out.print(message.ADDING_FLIGHT_MENU[3]);
        LocalTime departureTime = Flight.convertStringToDepartureTime(inputDepartureTime());
        System.out.print(message.ADDING_FLIGHT_MENU[4]);
        String flightTime = inputFlightTime();
        System.out.print(message.ADDING_FLIGHT_MENU[5]);
        String departureIataCode = inputIataCode();
        System.out.print(message.ADDING_FLIGHT_MENU[6]);
        String arrivalIataCode = inputIataCode();
        System.out.print(message.ADDING_FLIGHT_MENU[7]);
        double price = inputTicketPrice();
        Flight flight = new Flight(code, departureDate, departureTime, flightTime, departureIataCode, arrivalIataCode, price);
        storage.getFlights().add(flight);
        System.out.println(message.flightAddedToStorage(flight));
    }

    private void displayFindFlightMenu() {
        System.out.println(message.FIND_FLIGHT_INFORMATION);
        String code = scanner.next();
        storage.findFlight(code.toUpperCase()).ifPresentOrElse(
                f -> System.out.println(message.OUTPUT_FLIGHT_INFORMATION + f),
                () -> System.out.println(message.flightNotFound(code)));
    }

    public String inputCode() {
        String code;
        while (true) {
            code = scanner.next().toUpperCase();
            if (validateInputData.checkCode(code)) {
                return code;
            }
            System.out.println(message.INCORRECT_FORMAT);
        }
    }

    public String inputDepartureDate() {
        String date;
        while (true) {
            date = scanner.next();
            if (validateInputData.checkDate(date)) {
                return date;
            }
            System.out.println(message.INCORRECT_FORMAT);
        }
    }

    public String inputDepartureTime() {
        String departureTime;
        while (true) {
            departureTime = scanner.next();
            if (validateInputData.checkDepartureTime(departureTime)) {
                return departureTime;
            }
            System.out.println(message.INCORRECT_FORMAT);
        }
    }

    public String inputFlightTime() {
        String flightTime;
        while (true) {
            flightTime = scanner.next();
            if (validateInputData.checkFlightTime(flightTime)) {
                return flightTime;
            }
            System.out.println(message.INCORRECT_FORMAT);
        }
    }

    public String inputIataCode() {
        String input;
        while (true) {
            input = scanner.next().toUpperCase();
            if (!validateInputData.checkIataCode(input)) {
                System.out.println(message.INCORRECT_FORMAT);
            } else if (!validateInputData.isExistAirport(input)) {
                System.out.println(message.INCORRECT_AIRPORT);
            } else {
                break;
            }
        }
        return input;
    }

    public double inputTicketPrice() {
        String input;
        while (true) {
            input = scanner.next();
            double price = Double.parseDouble(input.replaceAll(",", "\\."));
            if (validateInputData.checkPrice(price)) {
                return price;
            }
            System.out.println(message.INCORRECT_FORMAT);
        }
    }
}
