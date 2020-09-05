package com.renorycore.common.model.timestamps;

import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.filesystem.TxtFile;
import com.renorycore.common.model.filesystem.TxtFileName;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author smit
 */
public abstract class TimestampWrap extends Timestamp {

    private static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat YYYY_MM_DD_HH_MM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyy-mm-dd hh:mm:ss 
    private static final SimpleDateFormat HH_MM_SS = new SimpleDateFormat("HH:mm:ss");

    public TimestampWrap(long time) {
        super(time);
    }

    public String getYMDHM() {
        return YYYY_MM_DD_HH_MM.format(this.getTime());
    }

    public String getYYYYmmDD() {
        return YYYY_MM_DD.format(this.getTime());
    }

    public String getYyyyMMddHHmmss() {
        return YYYY_MM_DD_HH_MM_SS.format(this.getTime());
    }

    public String HHmmss() {
        return HH_MM_SS.format(this.getTime());
    }

    void serelization(FolderCms folder, TxtFileName fileName) {
        String path = getFilePath(folder, fileName);
        TxtFile txtFile = new TxtFile(path);
        String time = getYyyyMMddHHmmss();
        txtFile.write(time);
    }

    void deserelization(FolderCms folder, TxtFileName fileName) {
        String path = getFilePath(folder, fileName);
        TxtFile txtFile = new TxtFile(path);
        String timeText = txtFile.readString();
        long time = Timestamp.valueOf(timeText).getTime();
        super.setTime(time);
    }

    private String getFilePath(FolderCms folder, TxtFileName fileName) {
        return folder + File.separator + fileName.getNameWithExtension();
    }

}
