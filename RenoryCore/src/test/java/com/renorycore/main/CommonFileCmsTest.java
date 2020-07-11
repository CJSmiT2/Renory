package com.renorycore.main;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class CommonFileCmsTest {

    @Test
    public void test1() throws IOException {
        File tmpFile = new File("/tmp/my_test_file.txt");
        tmpFile.createNewFile();

        CommonFileCms fileCms = new CommonFileCms(tmpFile);

        String name = fileCms.getNameWithoutExtension();
        String extension = fileCms.getExtension();

        assertEquals("my_test_file", name);
        assertEquals("txt", extension);
    }
}
