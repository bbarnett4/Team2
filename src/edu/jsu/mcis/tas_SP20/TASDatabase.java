
package edu.jsu.mcis.tas_SP20;

import java.sql.*;
import java.util.*;

/**
 *
 * @author bamab
 */
public class TASDatabase {
    
    private Connection conn = null;
    
    public TASDatabase(){
        
        try {
        
            String url = "jdbc:mysql://localhost/tas";
            String username = "group2";
            String password = "Group2";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection(url, username, password);
            
        }
        catch (Exception e) { e.printStackTrace(); }
        
    }
    
    public Badge getBadge(String id){
        
        return null; // remove this later!
        
    }
    /*accept shift ID as parameter */
    
    public Shift getShift(int id) {
        
        return null; // remove this later!
        
    }
    
    /*accept badge object as parameter*/
    public Shift getShift(Badge badge) {
        
        return null; // remove this later!
        
    }
    
    public Punch getPunch(int id){
        
        Punch punch = null;
        
        try {
            
            String query = "SELECT *, UNIX_TIMESTAMP(originaltimestamp) * 1000 AS ts FROM (punch JOIN badge ON punch.badgeid = badge.id) WHERE punch.id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            
            boolean hasresults = pstmt.execute();
            
            if (hasresults) {
                
                ResultSet resultset = pstmt.getResultSet();
                
                if (resultset.next()) {
                    
                    int terminalid = resultset.getInt("terminalid");
                    String badgeid = resultset.getString("badgeid");
                    String description = resultset.getString("description");
                    int punchtypeid = resultset.getInt("punchtypeid");
                    long ts = resultset.getLong("ts");
                    
                    Badge b = new Badge(badgeid, description);
                    
                    punch = new Punch(b, terminalid, punchtypeid);
                    punch.setTimeStamp(ts);
                    punch.setAdjtimestamp(ts);
                    punch.setId(id);
                    
                }                
                
            }
            
            
        }
        catch (Exception e) { e.printStackTrace(); }
        
        return punch;
        
    }
    
    
}
