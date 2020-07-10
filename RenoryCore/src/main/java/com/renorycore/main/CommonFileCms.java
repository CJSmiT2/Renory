package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author smit
 */
public class CommonFileCms implements FileCms {

    private File tmpFile;
    
    CommonFileCms(File tmpFile){
        this.tmpFile = tmpFile;
    }
    
    public void checkFileExsitence() throws FileNotFoundException{
        if(!tmpFile.exists()){
            throw new FileNotFoundException("Requested file not found");
        }
    }

    @Override
    public String getExtension() {
        String fileName = tmpFile.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public String getNameWithoutExtension() {
        String fileName = tmpFile.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

}
