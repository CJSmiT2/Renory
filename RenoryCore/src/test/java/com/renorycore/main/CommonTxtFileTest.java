package com.renorycore.main;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class CommonTxtFileTest {

    File tmpFile = new File("/tmp/my_test_file.txt");

    @Before
    public void init() throws IOException {
        tmpFile.createNewFile();
    }

    @After
    public void delete() {
        tmpFile.delete();
    }

    @Test
    public void testByString() {
        String expected = "test string";
        new CommonTxtFile(tmpFile).write(expected);

        String actual = new CommonTxtFile(tmpFile).readString();

        assertEquals(expected, actual);
    }

    @Test
    public void testByInteger() {
        int expected = 1111;
        new CommonTxtFile(tmpFile).write(expected);

        int actual = new CommonTxtFile(tmpFile).readInt();

        assertEquals(expected, actual);
    }

    @Test
    public void testByLong() {
        long expected = 1010101010101010101l;
        new CommonTxtFile(tmpFile).write(expected);

        long actual = new CommonTxtFile(tmpFile).readLong();

        assertEquals(expected, actual);
    }
}
