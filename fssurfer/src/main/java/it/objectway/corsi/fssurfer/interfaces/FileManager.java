package it.objectway.corsi.fssurfer.interfaces;

import it.objectway.corsi.fssurfer.enums.FileType;

import java.nio.file.FileVisitor;
import java.nio.file.Path;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public interface FileManager {
    Path getPath(String path);

    void walkFileTree(Path start, FileVisitor<? super Path> visitor);

    String getName(Path file);

    FileType getType(Path file);

    String getExtension(Path file);

    String getPermissions(Path file);

    long getSize(Path file);

    String getAbsolutePath(Path file);

    boolean canRead(Path file);

    boolean canWrite(Path file);

    boolean canExecute(Path file);
}
