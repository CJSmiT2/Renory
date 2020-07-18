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
public class CommonTxtTest {

    File tmpFile = new File(File.separator + "tmp" + File.separator + "my_test_file.txt");

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
        new TxtFileImpl(tmpFile).write(expected);

        String actual = new TxtFileImpl(tmpFile).readString();

        assertEquals(expected, actual);
    }

    @Test
    public void testByInteger() {
        int expected = 1111;
        new TxtFileImpl(tmpFile).write(expected);

        int actual = new TxtFileImpl(tmpFile).readInt();

        assertEquals(expected, actual);
    }

    @Test
    public void testByLong() {
        long expected = 1010101010101010101l;
        new TxtFileImpl(tmpFile).write(expected);

        long actual = new TxtFileImpl(tmpFile).readLong();

        assertEquals(expected, actual);
    }
}
