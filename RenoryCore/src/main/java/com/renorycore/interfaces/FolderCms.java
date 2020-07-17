package com.renorycore.interfaces;

import java.util.List;

/**
 *
 * @author smit
 */
public interface FolderCms {

    long getTotalFilesLength();

    List<FileCms> getFiles();

    List<FileCms> getFilesRecursive();

    List<FolderCms> getFolders();

    void moveTo(FolderCms destination);
}
