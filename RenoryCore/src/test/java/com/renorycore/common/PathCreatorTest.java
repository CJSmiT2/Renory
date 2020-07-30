package com.renorycore.common;

import com.renorycore.main.config.Config;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Alias;
import java.io.File;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class PathCreatorTest {

    FolderCms rootTestFolder = new FolderCms(Config.ROOT_DIRECTORY);

    @Before
    public void init() {
        rootTestFolder.mkdirs();
    }

    @After
    public void delete() {
        rootTestFolder.deleteRecursive();
    }

    @Test
    public void test1() {

        Alias alias = new Alias("test_alias");
        PathCreator pathCreator = new PathCreator();

        String actualName1 = pathCreator.createUniqueFolderName(rootTestFolder, alias);
        String expectedName1 = "test_alias";

        assertEquals(expectedName1, actualName1);

        new File(rootTestFolder + File.separator + expectedName1).mkdir();
        String actualName2 = pathCreator.createUniqueFolderName(rootTestFolder, alias);
        String expectedName2 = "test_alias_2";

        assertEquals(actualName2, expectedName2);

        new File(rootTestFolder + File.separator + expectedName2).mkdir();
        String actualName3 = pathCreator.createUniqueFolderName(rootTestFolder, alias);
        String expectedName3 = "test_alias_3";

        assertEquals(actualName3, expectedName3);
    }

}
