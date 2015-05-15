package it.objectway.warehouse.service;

import it.objectway.warehouse.manager.FileManager;
import it.objectway.warehouse.manager.LogManager;
import it.objectway.warehouse.task.AsyncFileParser;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class StoreService {
    private File inputDir;
    private File outputDir;
    private long timestamp;

    public StoreService(String inputDir, String outputDir) {
        this.inputDir = FileManager.getDirectory(inputDir);
        this.outputDir = FileManager.getDirectory(outputDir);
        this.timestamp = System.currentTimeMillis();
    }

    public void updateProducts() {
        List<File> dirFiles = Arrays.asList(inputDir.listFiles());
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(File file: dirFiles) {
            if (!file.isDirectory()) {
                Runnable parseFileTask = new AsyncFileParser(file, outputDir, timestamp);
                executorService.execute(parseFileTask);
            }
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(3L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            LogManager.debug(this.getClass(), "Timeout reached");
            e.printStackTrace();
        }
    }
}
