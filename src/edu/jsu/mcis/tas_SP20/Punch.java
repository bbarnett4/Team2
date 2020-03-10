
package edu.jsu.mcis.tas_SP20;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Punch {
    GregorianCalendar gcal = new GregorianCalendar();
    GregorianCalendar gcal2 = new GregorianCalendar();
    
    private String badge;
    private int terminalid;
    private int punchtypeid;
    private int id;
    private long timestamp;
    private long adjtimestamp;
    private String eventdata;
    
    //needs string instance field called "adjustmenttype"
    
    
   
   public Punch(Badge badge, int terminalid, int punchtypeid){
       
       this.badge = badge.getId();
       this.punchtypeid = punchtypeid;
       this.id = id;
       this.terminalid = terminalid;
       this.timestamp = timestamp;
   }
    
    public void setTimeStamp(long timestamp){
        this.timestamp = timestamp;
    }
    
    public void setId(int id){
        this.id = id;
    }
    //timestamps - long, times - LocalTime
    
   public String printOriginalTimestamp(){
       
       String punch = null;
       gcal = new GregorianCalendar();
       gcal.setTimeInMillis(timestamp);
       
       if(punchtypeid == 0){
           punch = "#" + badge + " CLOCKED OUT: " + gcal.toZonedDateTime().format(DateTimeFormatter.ofPattern( "E MM/DD/YYYY HH:MM:SS" + " ("+eventdata+")"));
       }
       if(punchtypeid == 1){
           punch = "#" + badge + " CLOCKED IN: " + gcal.toZonedDateTime().format(DateTimeFormatter.ofPattern( "E MM/DD/YYYY HH:MM:SS" + " ("+eventdata+")"));
       }
       if (punchtypeid == 2){
           punch = "#" + badge + " TIMED OUT; " + gcal.toZonedDateTime().format(DateTimeFormatter.ofPattern( "E MM/DD/YYYY HH:MM:SS" + " ("+eventdata+")"));
       }
       return punch.toUpperCase();
        
    }
   
   public void adjust(Shift s){ 
       GregorianCalendar shiftStart = new GregorianCalendar();
       GregorianCalendar shiftStop = new GregorianCalendar();
       GregorianCalendar startInterval = new GregorianCalendar();
       GregorianCalendar stopInterval = new GregorianCalendar();
       GregorianCalendar startGrace = new GregorianCalendar();
       GregorianCalendar stopGrace = new GregorianCalendar();
       GregorianCalendar startDock = new GregorianCalendar();
       GregorianCalendar stopDock = new GregorianCalendar();
       GregorianCalendar lunchStart = new GregorianCalendar();
       GregorianCalendar lunchStop = new GregorianCalendar();
       
   }
       public String printAdjustedTimestamp(){
           String punch = null;
           
           if(punchtypeid == 0){
               punch = "#" + badge + " CLOCKED OUT: " + gcal.toZonedDateTime().format(DateTimeFormatter.ofPattern( "E MM/DD/YYYY HH:MM:SS" + " ("+eventdata+")"));
           }
           if(punchtypeid ==1){
               punch = "#" + badge + " CLOCKED IN: " + gcal.toZonedDateTime().format(DateTimeFormatter.ofPattern( "E MM/DD/YYYY HH:MM:SS" + " ("+eventdata+")"));
           }
           if(punchtypeid ==2){
               punch = "#" + badge + " TIMED OUT: " + gcal.toZonedDateTime().format(DateTimeFormatter.ofPattern( "E MM/DD/YYYY HH:MM:SS" + " ("+eventdata+")"));
           }
           
           return punch.toUpperCase();
       }
           
    public int getTerminalid(){
        return this.terminalid;
    }
    public int getPunchtypeid(){
        return this.punchtypeid;
    }
    public int Id(){
        return this.id;
    }
    public long getOriginaltimestamp(){
        return this.timestamp;
    }
    public long getAdjtimestamp(){
        return this.adjtimestamp;
    }
}
