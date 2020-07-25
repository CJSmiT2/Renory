package com.renorycore.common.model.filesystem;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jplay
 */
public class FolderCmsMoveDeleteTest {

    File rootTestFolder = new File(File.separator + "tmp" + File.separator + "test_folder" + File.separator);

    @Before
    public void init() throws IOException {
        new FolderCmsTest().init();
    }

    @Test
    public void moveTest() {
        FolderCms folder1 = new FolderCms(rootTestFolder);
        FolderCms folder2 = new FolderCms(new File("/tmp/same_folder"));
        folder1.moveTo(folder2);

        TxtFile txtFile = new TxtFile(new File("/tmp/same_folder/second_folder/text_file.txt"));
        assertTrue(txtFile.exists());

        String text = txtFile.readString();
        assertEquals("another_text", text);

        assertFalse(rootTestFolder.exists());
    }

    @Test
    public void recursiveDeleteTest() {
        FolderCms folderCms = new FolderCms(rootTestFolder);
        folderCms.deleteRecursive();
        assertFalse(rootTestFolder.exists());
    }
}
