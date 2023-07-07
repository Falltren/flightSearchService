public class Message {

    public final String MAIN_MENU = "\n" + "Главное меню:" + "\n\n"
            + "1 - ввод рейса" + "\n"
            + "2 - вывод всех рейсов" + "\n"
            + "3 - поиск рейса по номеру" + "\n"
            + "0 - завершение работы";
    public final String[] ADDING_FLIGHT_MENU = {
            "Введите данные рейса:",
            "ХХХХ - номер рейса: ",
            "ДД/ММ/ГГГГ - дата рейса: ",
            "ЧЧ:ММ - время вылета: ",
            "ХХ.ХХ - длительность перелета: ",
            "ХХХ - аэропорт вылета: ",
            "ХХХ - аэропорт назначения: ",
            ".ХХ - стоимость билета: "
    };

    public final String MENU_ITEM_SELECTION = "Введите номер пункта меню: ";

    public final String INCORRECT_MENU_NUMBER = "Введен отсутствующий номер пункта меню" + "\n" + "Пожалуйста повторите ввод";
    public final String EMPTY_FLIGHT_LIST = "Информация о рейсах отсутствует";
    public final String OUTPUT_FLIGHT_INFORMATION = "Информация о рейсе: ";
    public final String FIND_FLIGHT_INFORMATION = "Введите номер рейса в формате ХХХХ: ";
    public final String INCORRECT_FORMAT = "Введены некорректные данные, повторите ввод";

    public final String INCORRECT_AIRPORT = "Указанный аэропорт не существует, повторите ввод";

    public String flightNotFound(String code) {
        return "Рейс " + code + " не найден";
    }

    public String flightAddedToStorage(Flight flight) {
        return "Информация о рейсе " + flight + " добавлена";
    }
}
