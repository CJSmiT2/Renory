package com.renorycore.main;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author jplay
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        CommonFileCms commonFileCms = new CommonFileCms("/home/jplay/test.file");
        System.out.println(commonFileCms.getExtension());
        System.out.println(commonFileCms.getNameWithoutExtension());
    }
}
