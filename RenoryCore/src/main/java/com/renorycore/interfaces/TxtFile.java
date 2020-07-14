package com.renorycore.interfaces;

/**
 *
 * @author smit
 */
public interface TxtFile {

    void write(String value);

    void write(int value);

    void write(long value);

    String readString();

    int readInt();

    long readLong();
}
