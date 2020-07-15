package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import com.renorycore.interfaces.FolderCms;
import java.io.File;
import java.util.List;

/**
 *
 * @author jplay
 */
public class FolderCmsImpl implements FolderCms {
    
    public FolderCmsImpl(File file){
        
    }
    
    public long getTotalFilesLength(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<FileCms> getFiles(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<FileCms> getFilesRecursive(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<FolderCms> getFolders(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void moveTo(FolderCms destination){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
