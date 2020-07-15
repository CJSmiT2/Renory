package com.renorycore.main;

import com.renorycore.interfaces.FolderCms;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jplay
 */
public class FolderCmsImplTest {
    
    File folder = new File("/tmp/test_folder");
    
    @Before
    public void init(){
        folder.mkdir();
    }
    
    @After
    public void delete(){
        folder.delete();
    }
    
    @Test
    public void totalLengthTest() throws IOException{
        File secondFolder = new File("/tmp/test_folder/second_folder");
        secondFolder.mkdir();
        
        TxtFileImpl txtFile1 = new TxtFileImpl(new File("/tmp/test_folder/test_file.txt"));
        txtFile1.createNewFile();
        txtFile1.write("some_text");
        
        TxtFileImpl txtFile2 = new TxtFileImpl(new File("/tmp/test_folder/second_folder/text_file.txt"));
        txtFile2.createNewFile();
        txtFile2.write("another_text");
        
        FolderCmsImpl folderCms = new FolderCmsImpl(folder);
        long totalLength = folderCms.getTotalFilesLength();
        
        assertEquals(23, totalLength);
    }
}
