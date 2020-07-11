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
public class CommonFileCms extends File implements FileCms {

    public CommonFileCms(File file) {
        super(file.getAbsolutePath());
        try {
            validFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommonFileCms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getExtension() {
        String fileName = super.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public String getNameWithoutExtension() {
        String fileName = super.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private void validFile() throws FileNotFoundException {
        if (!super.exists()) {
            throw new FileNotFoundException("File '" + super.getAbsolutePath() + "' not found");
        }
        if (super.getName().contains("[.]+")) {
            throw new RuntimeException("Extension not found in the file '" + super.getAbsolutePath() + "'");
        }
    }
}
