package it.objectway.warehouse.task;

import it.objectway.warehouse.exception.CsvFormatException;
import it.objectway.warehouse.manager.DbManager;
import it.objectway.warehouse.manager.LogManager;
import it.objectway.warehouse.model.Product;

import java.util.Scanner;

import static it.objectway.warehouse.util.StringUtils.buildString;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class AsyncLineParser implements Runnable {
    private String line;

    public AsyncLineParser(String line) {
        this.line = line;
    }


    @Override
    public void run() {
        Product p = parseLine(line);
        synchronized (AsyncLineParser.class) {
            int rowsUpdated = DbManager.updateProduct(p);
            if (rowsUpdated == 0) {
                DbManager.insertProduct(p);
                LogManager.info(this.getClass(), buildString("Product created: ", p));
                return;
            }
        }
        LogManager.info(this.getClass(), buildString("Updated product: ", p));
    }

    private Product parseLine(String line) {
        LogManager.debug(this.getClass(), buildString("Parseline: ", line));
        Scanner parser = new Scanner(line);
        parser.useDelimiter(",");
        try {
            int id = parser.nextInt();
            LogManager.debug(this.getClass(), buildString("Got id: ", id));
            String name = parser.next();
            LogManager.debug(this.getClass(), buildString("Got name ", name));
            String brand = parser.next();
            LogManager.debug(this.getClass(), buildString("Got brand: ", brand));
            String category = parser.next();
            LogManager.debug(this.getClass(), buildString("Got category: ", category));
            int quantity = parser.nextInt();
            LogManager.debug(this.getClass(), buildString("Got quantity: ", quantity));
            return new Product(id, name, brand, category, quantity);
        } catch(RuntimeException e) {
            throw new CsvFormatException("File is not a correct csv file of Products", e);
        }
    }
}
