package com.renorycore.main;

import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class CommonFileCmsTest {

    @Test
    public void test1() {
        File tmpFile = new File("/tmp/my_test_file.txt");
        
        CommonFileCms fileCms = new CommonFileCms(tmpFile);
        
        String name = fileCms.getNameWithoutExtension();
        String extension = fileCms.getExtension();
        
        assertEquals("my_test_file", name);
        assertEquals("txt", extension);
    }
}
