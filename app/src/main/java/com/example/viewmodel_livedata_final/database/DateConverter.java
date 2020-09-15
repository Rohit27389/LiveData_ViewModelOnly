package com.example.viewmodel_livedata_final.database;


import java.util.Date;

import androidx.room.TypeConverter;

public class DateConverter {

    @TypeConverter
    public static Long toTimestamp(Date date){
        return date==null? null : date.getTime();
    }

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp==null? null : new Date(timestamp);
    }
}
