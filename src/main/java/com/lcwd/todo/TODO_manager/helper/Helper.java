package com.lcwd.todo.TODO_manager.helper;

import org.apache.el.parser.ParseException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Helper {
    public static Date parseDate(LocalDateTime localdate) throws ParseException {
        Instant instant=localdate.atZone(ZoneId.systemDefault()).toInstant();
        Date date=Date.from(instant);
        return date;
    }
}
