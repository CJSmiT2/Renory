package com.renorycore.common.model.text;

import com.renorycore.common.model.filesystem.TxtFileName;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jplay
 */
public class CreationTime extends StringWrap {
    public static final String NAME = "creation_time";
    
    public static final DateFormat DATE_FORMAT = 
            new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    
    public CreationTime(){
        super(currentTime(), new TxtFileName(NAME));
    }
    
    private static String currentTime(){
        return DATE_FORMAT.format(new Date(System.currentTimeMillis()));
    }
    
    public static Date parseTime(String timeString){
        try {
            return DATE_FORMAT.parse(timeString);
        } catch (ParseException ex) {
            throw new RuntimeException("Date '" + timeString + "' cannot be parsed.");           
        }
    }
}
