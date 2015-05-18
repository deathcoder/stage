package it.objectway.corsi.fssurfer.impl;

import it.objectway.corsi.fssurfer.enums.FileType;
import it.objectway.corsi.fssurfer.exceptions.UnknownFileTypeException;
import it.objectway.corsi.fssurfer.interfaces.FileManager;
import it.objectway.corsi.fssurfer.interfaces.LogManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static it.objectway.corsi.fssurfer.utils.Strings.buildString;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class FileManagerImpl implements FileManager {
    private static LogManager logger = new LogManagerImpl(FileManagerImpl.class);

    public Path getPath(String path) {
        logger.trace("getPath: ", path);
        return Paths.get(path);
    }

    public void walkFileTree(Path start, FileVisitor<? super Path> visitor) {
        logger.trace("walkFileTree: ", start);
        try {
            Files.walkFileTree(start, visitor);
        } catch (IOException e) {
            logger.error("IOException during walkFileTree of: ", start);
            e.printStackTrace();
        }
    }

    public File getFile(Path path) {
        logger.trace("getFile: ", path);
        return path.toFile();
    }

    public String getName(Path path) {
        logger.trace("getName: ", path);
        return getFile(path).getName();
    }

    public FileType getType(Path path) {
        logger.trace("getType: ", path);
        if(Files.isDirectory(path)) {
            logger.trace("getType: ", path, " is a directory");
            return FileType.DIR;
        }
        if(Files.isRegularFile(path)) {
            logger.trace("getType: ", path, " is a file");
            return FileType.FILE;
        }
        throw new UnknownFileTypeException(buildString("Unknown file type: ", path).toString());
    }

    public String getExtension(Path path) {
        logger.trace("getExtension: ", path);
        String fileName = getName(path);
        int lastPoint = fileName.lastIndexOf(".");
        String extension;
        if(lastPoint == -1) {
            extension = "";
        }
        else {
            extension = fileName.substring(lastPoint);
        }
        logger.trace("getExtension: ", path, " -> ext: ", extension);
        return extension;
    }

    public String getPermissions(Path path) {
        logger.trace("getPermissions: ", path);
        StringBuilder sb = new StringBuilder();
        if (canRead(path)) {
            sb.append('r');
        } else {
            sb.append('-');
        }
        if (canWrite(path)) {
            sb.append('w');
        } else {
            sb.append('-');
        }
        if (canExecute(path)) {
            sb.append('x');
        } else {
            sb.append('-');
        }
        return sb.toString();
    }

    public boolean canRead(Path file) {
        return getFile(file).canRead();
    }

    public boolean canWrite(Path file) {
        return getFile(file).canWrite();
    }

    public boolean canExecute(Path file) {
        return getFile(file).canExecute();
    }

    public long getSize(Path path) {
        logger.trace("getSize: ", path);
        try {
            return Files.size(path);
        } catch (IOException e) {
            logger.error("getSize: failed to get size for: ", path);
            e.printStackTrace();
        }
        return -1;
    }

    public String getAbsolutePath(Path path) {
        logger.trace("getAbsolutePath: ", path);
        return path.toAbsolutePath().toString();
    }
}
