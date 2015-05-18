package it.objectway.corsi.fssurfer.utils;

import it.objectway.corsi.fssurfer.enums.FileType;
import it.objectway.corsi.fssurfer.impl.FileManagerImpl;
import it.objectway.corsi.fssurfer.interfaces.FileManager;
import it.objectway.corsi.fssurfer.models.FileModel;

import java.nio.file.Path;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class FileModels {
    private static FileManager fileManager = new FileManagerImpl();

    public static FileModel extractInfo(Path file) {
        String fileName = fileManager.getName(file);
        FileType fileType = fileManager.getType(file);
        String fileExt = fileManager.getExtension(file);
        String filePermissions = fileManager.getPermissions(file);
        long fileSize = fileManager.getSize(file);
        String absolutePath = fileManager.getAbsolutePath(file);
        return new FileModel(fileName, fileType, fileExt, filePermissions, fileSize, absolutePath);
    }
}
