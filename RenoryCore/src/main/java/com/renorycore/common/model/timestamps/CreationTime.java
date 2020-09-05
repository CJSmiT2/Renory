package com.renorycore.common.model.timestamps;

import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.filesystem.TxtFileName;

/**
 *
 * @author jplay
 */
public class CreationTime extends TimestampWrap {

    private static final TxtFileName NAME = new TxtFileName("creation_time");

    public CreationTime() {
        super(System.currentTimeMillis());
    }

    public void serialization(FolderCms folder) {
        super.serelization(folder, NAME);
    }

    public void deserialization(FolderCms folder) {
        super.deserelization(folder, NAME);
    }

}
