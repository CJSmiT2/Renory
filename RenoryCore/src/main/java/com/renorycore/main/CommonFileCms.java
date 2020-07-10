package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author smit
 */
public class CommonFileCms extends File implements FileCms{
    
    public CommonFileCms(File file) throws FileNotFoundException{
        super(file.getAbsolutePath());
        validateFile();
    }
    
    private void validateFile() throws FileNotFoundException{
        if(super.getName().contains("[.]+")){
            throw new RuntimeException("Extension not found in the filename");
        }
        if(!super.exists()){
            throw new FileNotFoundException("Requested file not found");
        }
    }
    
    @Override
    public String getExtension(){
        String fileName = super.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public String getNameWithoutExtension(){
        String fileName = super.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

}
