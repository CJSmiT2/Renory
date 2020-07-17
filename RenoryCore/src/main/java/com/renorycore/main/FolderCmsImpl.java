package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import com.renorycore.interfaces.FolderCms;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jplay
 */
public class FolderCmsImpl extends File implements FolderCms {
    
    public FolderCmsImpl(File file){
        super(file.getAbsolutePath());
    }
    
    public long getTotalFilesLength(){
        List<FileCms> files = getFilesRecursive();
        long totalLength = 0;
        for(FileCms file : files){
            totalLength += ((FileCmsImpl)file).length();
        }
        return totalLength;
    }
    
    public List<FileCms> getFiles(){
        File[] filesAndFolders = this.listFiles();
        List<FileCms> files = new ArrayList<>();
        for(File file : filesAndFolders){
            if(file.isFile()){
                files.add(new FileCmsImpl(file));
            }
        }
        return files;
    }
    
    public List<FileCms> getFilesRecursive(){
        File[] filesAndFolders = this.listFiles();
        List<FileCms> files = new ArrayList<>();
        for(File file : filesAndFolders){
            if(file.isFile()){
                files.add(new FileCmsImpl(file));
            }else{
                files.addAll(new FolderCmsImpl(file).getFilesRecursive());
            }
        }
        return files;
    }
    
    public List<FolderCms> getFolders(){
        File[] filesAndFolders = this.listFiles();
        List<FolderCms> folders = new ArrayList<>();
        for(File file : filesAndFolders){
            if(file.isDirectory()){
                folders.add(new FolderCmsImpl(file));
            }
        }
        return folders;
    }
    
    public void moveTo(FolderCms destination){
        ((FolderCmsImpl)destination).mkdir();
        File[] filesAndFolders = this.listFiles();
        for(File file : filesAndFolders){
            String newPath = ((FolderCmsImpl)destination).getAbsolutePath()
                    + "/" + file.getName();
            File newFile = new File(newPath);
                    
            if(file.isFile()){
                file.renameTo(newFile);
            }else{
                new FolderCmsImpl(file).moveTo(new FolderCmsImpl(newFile));
            }
        }
        this.delete();
    }
}
