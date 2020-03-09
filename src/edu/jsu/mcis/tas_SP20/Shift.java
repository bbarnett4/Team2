/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.tas_SP20;

import java.sql.Time;
import java.time.LocalTime;

import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 *
 * @author Grace
 */
public class Shift {
    
    private int id;
    private String description;
    private LocalTime start; //Time...
    private LocalTime stop;
    private int interval;
    private int graceperiod;
    private int dock;
    private LocalTime lunchstart;
    private LocalTime lunchstop;
    private int lunchdeduct;
    
    // indicates the scheduled length of the lunch break in minutes
    private int lunchduration; //Question! Shift class should also add an instance field called "lunchduration
    
    Shift(int id, String description, LocalTime start, LocalTime stop, int interval,
          int graceperiod, int dock, LocalTime lunchstart, LocalTime lunchstop,
          int lunchdeduct) {
        this.id = id;
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.interval = interval;
        this.graceperiod = graceperiod;
        this.dock = dock;
        this.lunchstart = lunchstart;
        this.lunchstop = lunchstop;
        this.lunchdeduct = lunchdeduct;
        
        lunchduration = getLunchDuration(); //initilie instance field
    }
    
    public int getLunchDuration() {
        
        int lstop = lunchstop.getHour() * 60 + lunchstop.getMinute();
        int lstart = lunchstart.getHour() * 60 + lunchstart.getMinute();
        return (lstop - lstart);
    }
    
    public int getShiftDuration() {
        int sstop = stop.getHour() * 60 + stop.getMinute();
        int sstart = start.getHour() * 60 + start.getMinute();
        return (sstop - sstart);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getStop() {
        return stop;
    }

    public void setStop(LocalTime stop) {
        this.stop = stop;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getGraceperiod() {
        return graceperiod;
    }

    public void setGraceperiod(int graceperiod) {
        this.graceperiod = graceperiod;
    }

    public int getDock() {
        return dock;
    }

    public void setDock(int dock) {
        this.dock = dock;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public void setLunchstart(LocalTime lunchstart) {
        this.lunchstart = lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }

    public void setLunchstop(LocalTime lunchstop) {
        this.lunchstop = lunchstop;
    }

    public int getLunchdeduct() {
        return lunchdeduct;
    }

    public void setLunchdeduct(int lunchdeduct) {
        this.lunchdeduct = lunchdeduct;
    }

    public int getLunchduration() {
        return lunchduration;
    }

    public void setLunchduration(int lunchduration) {
        this.lunchduration = lunchduration;
    }

    
        
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        
        int lunchDuration = this.getLunchDuration();
        int shiftDuration = this.getShiftDuration();
        
        s.append(description).append(": ");
        s.append(start).append(" - ");
        s.append(stop).append(" (").append(shiftDuration).append(" minutes); ");
        s.append("Lunch: ").append(lunchstart).append(" - ").append(lunchstop);
        s.append(" (").append(lunchduration).append(" minutes)");
                
        
        // "Shift 1: 07:00 - 15:30 (510 minutes); Lunch: 12:00 - 12:30 (30 minutes)"
        
        return (s.toString());
              
        
    }
    

}
