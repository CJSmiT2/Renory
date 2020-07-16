package com.renorycore.main;

import com.renorycore.interfaces.FileCms;
import com.renorycore.interfaces.FolderCms;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jplay
 */
public class FolderCmsImplTest {
    
    File folder = new File("/tmp/test_folder");
    
    @Before
    public void init() throws IOException{
        folder.mkdir();
        File secondFolder = new File("/tmp/test_folder/second_folder");
        secondFolder.mkdir();
        
        TxtFileImpl txtFile1 = new TxtFileImpl(new File("/tmp/test_folder/test_file.txt"));
        txtFile1.createNewFile();
        txtFile1.write("some_text");
        
        TxtFileImpl txtFile2 = new TxtFileImpl(new File("/tmp/test_folder/second_folder/text_file.txt"));
        txtFile2.createNewFile();
        txtFile2.write("another_text");
    }
    
    @After
    public void delete(){
        folder.delete();
    }
    
    @Test
    public void totalLengthTest(){
        FolderCmsImpl folderCms = new FolderCmsImpl(folder);
        long totalLength = folderCms.getTotalFilesLength();
        
        assertEquals(23, totalLength);
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
    
}
