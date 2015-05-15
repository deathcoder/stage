package it.objectway.warehouse.manager;

import it.objectway.warehouse.exception.FileNotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static it.objectway.warehouse.util.StringUtils.buildString;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class FileManager {
    public static File getDirectory(String path) {
        File f = new File(path);
        if(!f.isDirectory()) { throw new FileNotDirectoryException(buildString("Given path is not a directory: ", path)); }
        return f;
    }

    public static Scanner getScanner(File file) {
        LogManager.debug(FileManager.class, buildString("Get scanner: ", file));
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void moveToDirectory(File file, File targetDir) {
        moveToDirectory(file, targetDir, null);
    }

    public static void moveToDirectory(File file, File targetDir, String renameFile) {
        if(!targetDir.isDirectory()) { throw new FileNotDirectoryException(buildString("Given file is not a directory: ", file)); }
        if(renameFile == null) {
            move(file, targetDir);
            return;
        }
        Path src = getPath(file);
        Path target = Paths.get(targetDir.getPath()).resolve(buildString("./", renameFile));
        LogManager.debug(FileManager.class, buildString("Resolved target for move: ", target));
        move(src, target);
    }

    public static void move(File source, File target) {
        Path src = getPath(source);
        Path dest = getPath(target);
        move(src, dest);
        LogManager.debug(FileManager.class, buildString("moved ", src, " to ", target));
    }

    private static void move(Path source, Path target) {
        try {
            Files.move(source, target);
        } catch (IOException e) {
            LogManager.error(FileManager.class, buildString("Failed to move file ", source, " to ", target));
            e.printStackTrace();
        }
    }

    public static Path getPath(File file) {
        return Paths.get(file.getPath());
    }
}
