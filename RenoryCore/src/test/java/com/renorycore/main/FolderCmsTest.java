package com.renorycore.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jplay
 */
public class FolderCmsTest {

    File rootTestFolder = new File(File.separator + "tmp" + File.separator + "test_folder" + File.separator);

    @Before
    public void init() throws IOException {
        rootTestFolder.mkdir();
        File subFolder = new File(rootTestFolder + File.separator + "second_folder");
        subFolder.mkdir();

        new TxtFileImpl(rootTestFolder + File.separator + "test_file.txt").write("some_text");
        new TxtFileImpl(subFolder + File.separator + "text_file.txt").write("another_text");
    }

    @After
    public void delete() {
        new FolderCms(rootTestFolder).recursiveDelete();
    }

    @Test
    public void totalLengthTest() {
        FolderCms folderCms = new FolderCms(rootTestFolder);
        
        long actualTotalLength = folderCms.getTotalFilesLength();

        assertEquals(21, actualTotalLength);
    }

    @Test
    public void getFilesTest() {
        FolderCms folderCms = new FolderCms(rootTestFolder);
        
        List<FileCms> actualFiles = folderCms.getFiles();
        
        assertEquals(1, actualFiles.size());
    }

    @Test
    public void getFilesRecursiveTest() {
        FolderCms folderCms = new FolderCms(rootTestFolder);
        
        List<FileCms> actualFiles = folderCms.getFilesRecursive();
        
        assertEquals(2, actualFiles.size());
    }

    @Test
    public void getFoldersTest() {
        FolderCms folderCms = new FolderCms(rootTestFolder);
        
        List<FolderCms> actualFolders = folderCms.getFolders();
        
        assertEquals(1, actualFolders.size());
    }

//    @Test
//    public void moveTest() {
//        FolderCms folder1 = new FolderCms(rootTestFolder);
//        FolderCms folder2 = new FolderCms(new File("/tmp/same_folder"));
//        folder1.moveTo(folder2);
//
//        TxtFileImpl txtFile = new TxtFileImpl(new File("/tmp/same_folder/second_folder/text_file.txt"));
//        assertTrue(txtFile.exists());
//
//        String text = txtFile.readString();
//        assertEquals("another_text", text);
//
//        assertFalse(rootTestFolder.exists());
//    }
//
//    @Test
//    public void recursiveDeleteTest() {
//        FolderCms folderCms = new FolderCms(rootTestFolder);
//        folderCms.recursiveDelete();
//        assertFalse(rootTestFolder.exists());
//    }

}
