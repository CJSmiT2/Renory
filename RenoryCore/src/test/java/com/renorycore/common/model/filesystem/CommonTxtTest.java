package com.renorycore.common.model.filesystem;

import com.renorycore.common.model.filesystem.TxtFile;
import com.renorycore.main.config.Config;
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

    File tmpFile = new File(Config.ROOT_DIRECTORY + "my_test_file.txt");

    @Before
    public void init() throws IOException {
        new File(Config.ROOT_DIRECTORY).mkdir();
        tmpFile.createNewFile();
    }

    @After
    public void delete() {
        tmpFile.delete();
    }

    @Test
    public void testByString() {
        String expected = "test string";
        new TxtFile(tmpFile).write(expected);

        String actual = new TxtFile(tmpFile).readString();

        assertEquals(expected, actual);
    }

    @Test
    public void testByInteger() {
        int expected = 1111;
        new TxtFile(tmpFile).write(expected);

        int actual = new TxtFile(tmpFile).readInt();

        assertEquals(expected, actual);
    }

    @Test
    public void testByLong() {
        long expected = 1010101010101010101l;
        new TxtFile(tmpFile).write(expected);

        long actual = new TxtFile(tmpFile).readLong();

        assertEquals(expected, actual);
    }
}
