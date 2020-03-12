
package edu.jsu.mcis.tas_SP20;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Punch {
    
    public static final int CLOCK_OUT = 0;
    public static final int CLOCK_IN = 1;
    public static final int TIME_OUT = 2;
    
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
       this.terminalid = terminalid;
       
       this.id = 0;
       GregorianCalendar gc = new GregorianCalendar();
       
       this.timestamp = gc.getTimeInMillis();
       this.adjtimestamp = timestamp;
       
       this.eventdata = "";
       
   }
    
    public void setTimeStamp(long timestamp){
        this.timestamp = timestamp;
    }
    
    public void setId(int id){
        this.id = id;
    }
    //timestamps - long, times - LocalTime
    
   public String printOriginalTimestamp() {
       
       // #D2C39273 CLOCKED IN: WED 09/05/2018 07:00:07
       
       StringBuilder s = new StringBuilder();
       
       GregorianCalendar gc = new GregorianCalendar();
       gc.setTimeInMillis(timestamp);
       
       SimpleDateFormat sdf = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
       
       s.append("#").append(badge).append(" ");
       
       switch (punchtypeid) {
           
           case CLOCK_OUT:
               s.append("CLOCKED OUT: ");
               break;
           case CLOCK_IN:
               s.append("CLOCKED IN: ");
               break;
           case TIME_OUT:
               s.append("TIMED OUT: ");
               break;
               
       }
       
       s.append(sdf.format(gc.getTime()));
       
       return s.toString().toUpperCase();
        
    }
   
   /*public void adjust(Shift s){ 
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
       }*/
           
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

    public void setAdjtimestamp(long adjtimestamp) {
        this.adjtimestamp = adjtimestamp;
    }
    
    
    
}
