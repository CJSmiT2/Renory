package com.renorycore.main;

import com.renorycore.interfaces.TxtFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class CommonTxtFile extends CommonFileCms implements TxtFile {

    CommonTxtFile(File file) {
        super(file);
    }

    @Override
    public void write(String value) {
        try {
            try (FileWriter fileWriter = new FileWriter(this)) {
                fileWriter.write(value);
                fileWriter.flush();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Cant add text to the file! Text = '" + value + "', file='" + this + "'");
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
        try (FileInputStream fstream = new FileInputStream(this);
                InputStreamReader is = new InputStreamReader(fstream);
                BufferedReader br = new BufferedReader(is)) {

            return br.readLine();

        } catch (Exception ex) {
            Logger.getLogger(CommonTxtFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Cant read text from file! file='" + this + "'");
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
