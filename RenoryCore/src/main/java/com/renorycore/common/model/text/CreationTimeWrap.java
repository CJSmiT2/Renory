/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renorycore.common.model.text;

import com.renorycore.common.model.filesystem.TxtFileName;

/**
 *
 * @author jplay
 */
public class CreationTimeWrap extends StringWrap {
    private static String NAME = "creation_time";
    
    public CreationTimeWrap(String value){
        super(value, new TxtFileName(NAME));
    }
}
