package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class CommonFileCms extends File implements FileCms{
    
    public CommonFileCms(File file){
        super(file.getAbsolutePath());
    }
    
    private void checkFileExistence() throws FileNotFoundException{
        if(!super.exists()){
            throw new FileNotFoundException("Requested file not found");
        }
    }
    
    private void checkExtensionExistence(){
        if(super.getName().contains("[.]+")){
            throw new RuntimeException("Extension not found in the filename");
        }
    }
    
    @Override
    public String getExtension(){
        try {
            checkFileExistence();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        checkExtensionExistence();
        String fileName = super.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public String getNameWithoutExtension() throws FileNotFoundException {
        try {
            checkFileExistence();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        checkExtensionExistence();
        String fileName = super.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

}
