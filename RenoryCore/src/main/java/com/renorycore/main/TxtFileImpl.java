package com.renorycore.main;

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
public class TxtFileImpl extends FileCms {

    TxtFileImpl(File file) {
        super(file);
    }

    TxtFileImpl(String path) {
        super(path);
    }

    public void write(String value) {
        try {
            try (FileWriter fileWriter = new FileWriter(this)) {
                fileWriter.write(value);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Cant add text to the file! Text = '" + value + "', file='" + this + "'");
        }
    }

    public void write(int value) {
        write(Integer.toString(value));
    }

    public void write(long value) {
        write(Long.toString(value));
    }

    public String readString() {
        try (FileInputStream fstream = new FileInputStream(this);
                InputStreamReader is = new InputStreamReader(fstream);
                BufferedReader br = new BufferedReader(is)) {

            return br.readLine();

        } catch (Exception ex) {
            Logger.getLogger(TxtFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Cant read text from file! file='" + this + "'");
    }

    public int readInt() {
        return Integer.parseInt(readString());
    }

    public long readLong() {
        return Long.parseLong(readString());
    }

}
