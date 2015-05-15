package it.objectway.warehouse.task;

import it.objectway.warehouse.manager.FileManager;
import it.objectway.warehouse.manager.LogManager;
import it.objectway.warehouse.util.DateUtils;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class AsyncFileParser implements Runnable{
    private File file;
    private File outputDir;
    private long timestamp;

    private static final String DATEFORMAT = "YYYY-MM-dd_HH.mm.ss";

    public AsyncFileParser(File file, File outputDir, long timestamp) {
        this.file = file;
        this.outputDir = outputDir;
        this.timestamp = timestamp;
    }

    @Override
    public void run() {
        parseFile(file);
        String rename = String.format("%s_product.csv", DateUtils.getFormattedTimestamp(DATEFORMAT, timestamp));
        FileManager.moveToDirectory(file, outputDir, rename);
    }

    private void parseFile(File file) {
        Scanner lineParser = FileManager.getScanner(file);
        ExecutorService executorService = Executors.newCachedThreadPool();

        while(lineParser.hasNextLine()) {
            Runnable parseLineTask = new AsyncLineParser(lineParser.nextLine());
            executorService.execute(parseLineTask);
        }
        executorService.shutdown();
        lineParser.close();
        try {
            executorService.awaitTermination(3L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            LogManager.debug(this.getClass(), "Timeout reached");
            e.printStackTrace();
        }
    }
}
