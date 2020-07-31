/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renorycore.common.model.timestamps;

import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.CreationTimeWrap;
import java.sql.Timestamp;

/**
 *
 * @author jplay
 */
public class CreationTime extends Timestamp {
    public CreationTime(){
        super(System.currentTimeMillis());
    }
    
    public void serialization(FolderCms folder){
        CreationTimeWrap wrap = new CreationTimeWrap(toString());
        wrap.serialization(folder);
    }
    
}
