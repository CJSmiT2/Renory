package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author smit
 */
public class CommonFileCms implements FileCms {

    private String extension;
    private String nameWithoutExtension;
    
    CommonFileCms(File tmpFile) throws FileNotFoundException {
        if(tmpFile.exists()){
            String fileName = tmpFile.getName();
            int indexOfDot = fileName.lastIndexOf(".");
            extension = fileName.substring(indexOfDot + 1);
            nameWithoutExtension = fileName.substring(0, indexOfDot);
        }else{
            throw new FileNotFoundException("Requested file not found");
        }
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public String getNameWithoutExtension() {
        return nameWithoutExtension;
    }

}
