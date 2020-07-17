package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import com.renorycore.interfaces.FolderCms;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author jplay
 */
public class FolderCmsImplTest {
    
    File folder;
    
    @Before
    public void init() throws IOException{
        folder = new File("/tmp/test_folder");
        folder.mkdir();
        File secondFolder = new File("/tmp/test_folder/second_folder");
        secondFolder.mkdir();
        
        File file1 = new File("/tmp/test_folder/test_file.txt");
        file1.createNewFile();
        TxtFileImpl txtFile1 = new TxtFileImpl(file1);
        txtFile1.write("some_text");
        
        File file2 = new File("/tmp/test_folder/second_folder/text_file.txt");
        file2.createNewFile(); 
        TxtFileImpl txtFile2 = new TxtFileImpl(file2);
        txtFile2.write("another_text");
    }
    
    @After
    public void delete(){
        if(folder.exists()){
            folder.delete();
        }
    }
    
    @Test
    public void totalLengthTest(){
        FolderCmsImpl folderCms = new FolderCmsImpl(folder);
        long totalLength = folderCms.getTotalFilesLength();
        
        assertEquals(21, totalLength);
    }
    
    @Test
    public void getFilesTest(){
        FolderCmsImpl folderCms = new FolderCmsImpl(folder);
        List<FileCms> files = folderCms.getFiles();
        assertEquals(1, files.size());
        
        FileCmsImpl file = (FileCmsImpl) files.get(0);
        String filePath = file.getAbsolutePath();
        assertEquals("/tmp/test_folder/test_file.txt", filePath);
    }
    
    @Test
    public void getFilesRecursiveTest(){
        FolderCmsImpl folderCms = new FolderCmsImpl(folder);
        List<FileCms> files = folderCms.getFilesRecursive();
        assertEquals(2, files.size());
    }
    
    @Test
    public void getFoldersTest(){
        FolderCmsImpl folderCms = new FolderCmsImpl(folder);
        List<FolderCms> folders = folderCms.getFolders();
        assertEquals(1, folders.size());
        
        FolderCmsImpl folder = (FolderCmsImpl) folders.get(0);
        assertEquals("/tmp/test_folder/second_folder", folder.getAbsolutePath());
    }
    
    @Test
    public void moveTest(){
        FolderCmsImpl folder1 = new FolderCmsImpl(folder);
        FolderCmsImpl folder2 = new FolderCmsImpl(new File("/tmp/same_folder"));
        folder1.moveTo(folder2);
        
        TxtFileImpl txtFile = new TxtFileImpl(new File("/tmp/same_folder/second_folder/text_file.txt"));
        assertTrue(txtFile.exists());
        
        String text = txtFile.readString();
        assertEquals("another_text", text);
        
        assertFalse(folder.exists());
    }
    
}
