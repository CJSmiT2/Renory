package com.renorycore.common.model.filesystem;

import com.renorycore.common.model.filesystem.FileCms;
import com.renorycore.common.model.filesystem.TxtFile;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.main.config.Config;
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

    File rootTestFolder = new File(Config.ROOT_DIRECTORY + "test_folder" + File.separator);

    @Before
    public void init() throws IOException {
        rootTestFolder.mkdir();
        File subFolder = new File(rootTestFolder + File.separator + "second_folder");
        subFolder.mkdirs();

        new TxtFile(rootTestFolder + File.separator + "test_file.txt").write("some_text");
        new TxtFile(subFolder + File.separator + "text_file.txt").write("another_text");
    }

    @After
    public void delete() {
        new FolderCms(rootTestFolder).deleteRecursive();
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

}
