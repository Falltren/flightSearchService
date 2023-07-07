import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/airports.json");
        Storage storage = new Storage();
        storage.createAirports(file);
        Menu menu = new Menu(storage);
        menu.displayMainMenu();
    }
}
