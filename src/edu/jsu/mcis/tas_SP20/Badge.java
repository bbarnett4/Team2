package edu.jsu.mcis.tas_SP20;

public class Badge {
    
    private String id;
    private String description;

    public Badge(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        
        // "#12565C60 (Chapman, Joshua E)"
        
        StringBuilder s = new StringBuilder();
        
        s.append("#").append(id).append(" (").append(description).append(")");
        
        return (s.toString());
        
    }
    
}