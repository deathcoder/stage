import it.objectway.warehouse.manager.LogManager;
import it.objectway.warehouse.service.StoreService;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class Main {
    public static void main(String[] args) {
        LogManager.info(Main.class, "Main started");

        String inputDir = null;
        String outputDir = null;
        if (args.length != 3) {
            LogManager.info(Main.class, "input dir and output dir not provided, running with default configuration");
            inputDir = "C:\\Users\\stageusr2015\\Desktop\\stage\\esercizi\\files\\magazzino\\csvfiles";
            outputDir = "C:\\Users\\stageusr2015\\Desktop\\stage\\esercizi\\files\\magazzino\\csvfiles\\processed";
        }
        else {
            inputDir = args[1];
            outputDir = args[2];
        }
        StoreService store = new StoreService(inputDir, outputDir);
        store.updateProducts();
    }
}
