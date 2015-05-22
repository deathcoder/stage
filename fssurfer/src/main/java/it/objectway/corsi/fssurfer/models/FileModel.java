package it.objectway.corsi.fssurfer.models;

import it.objectway.corsi.fssurfer.enums.FileType;

import java.io.Serializable;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class FileModel implements Serializable {
    private String name;
    private FileType type;
    private String extension;
    private String permissions;
    private long size;
    private String absolutePath;

    public FileModel() {}
    public FileModel(String name, FileType type, String extension,
                     String permissions, long size, String absolutePath) {
        this.name = name;
        this.type = type;
        this.extension = extension;
        this.permissions = permissions;
        this.size = size;
        this.absolutePath = absolutePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.name();
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPermissions() {
        return permissions.toString();
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
}
