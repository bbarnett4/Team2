
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
           
       }
       if(punchtypeid == 1){
           
       }
       if (punchtypeid == 2){
           
       }
       return "";
        
    }
       public String printAdjustedTimestamp(){
           String punch = null;
           
           if(punchtypeid == 0){
               
           }
           if(punchtypeid ==1){
               
           }
           if(punchtypeid ==2){
               
           }
           
           return "";
       }
    /* punch outputs: 
    CLOCKED IN
    CLOCKED OUT
    TIME OUT
    */       
    
}
