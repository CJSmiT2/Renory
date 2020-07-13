package com.renorycore.main;

import com.renorycore.interfaces.TxtFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class CommonTxtFile extends CommonFileCms implements TxtFile {
    
    CommonTxtFile(File file){
        super(file);
    }

    @Override
    public void write(String value) {
        try {
            FileWriter fileWriter = new FileWriter(this);
            fileWriter.write(value);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void write(int value) {
        write(Integer.toString(value)); 
    }

    @Override
    public void write(long value) {
        write(Long.toString(value));
    }

    @Override
    public String readString() {
        try {
            FileReader fileReader = new FileReader(this);
            int currentInt;
            String result = "";
            while((currentInt = fileReader.read()) != -1){
                char currentCharacter = (char)currentInt;
                result += currentCharacter;
            }
            return result;
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int readInt() {
        return Integer.parseInt(readString());
    }

    @Override
    public long readLong() {
        return Long.parseLong(readString());
    }

}
