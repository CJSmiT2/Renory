package com.renorycore.common.model.filesystem;

import com.renorycore.common.model.text.Alias;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jplay
 */
public class FolderCms extends File {

    public FolderCms(File file) {
        super(file.getAbsolutePath());
        super.mkdirs();
    }

    public FolderCms(String path) {
        super(path);
        super.mkdirs();
    }

    public long getTotalFilesLength() {
        long totalLength = 0;
        for (FileCms file : getFilesRecursive()) {
            totalLength += file.length();
        }
        return totalLength;
    }

    public List<FileCms> getFiles() {
        List<FileCms> files = new ArrayList<>();
        for (File file : listFiles()) {
            if (file.isFile()) {
                files.add(new FileCms(file));
            }
        }
        return files;
    }

    public List<FileCms> getFilesRecursive() {
        List<FileCms> files = new ArrayList<>();
        for (File file : listFiles()) {
            if (file.isFile()) {
                files.add(new FileCms(file));
            } else {
                files.addAll(new FolderCms(file).getFilesRecursive());
            }
        }
        return files;
    }

    public List<FolderCms> getFolders() {
        List<FolderCms> folders = new ArrayList<>();
        for (File file : listFiles()) {
            if (file.isDirectory()) {
                folders.add(new FolderCms(file));
            }
        }
        return folders;
    }

    public void moveTo(String destination) {
        moveTo(new FolderCms(destination));
    }

    public void moveTo(FolderCms destination) {
        destination.mkdirs();

        for (File file : listFiles()) {
            File newFile
                    = new File(destination.getAbsolutePath() + File.separator + file.getName());

            if (file.isFile()) {
                file.renameTo(newFile);
            } else {
                new FolderCms(file).moveTo(newFile.getAbsolutePath());
            }
        }

        deleteRecursive();
    }

    public void deleteRecursive() {
        for (File file : listFiles()) {
            if (file.isFile()) {
                file.delete();
            } else {
                new FolderCms(file).deleteRecursive();
            }
        }
        delete();
    }

    public Alias getAlias() {
        return new Alias(this.getName());
    }
}
