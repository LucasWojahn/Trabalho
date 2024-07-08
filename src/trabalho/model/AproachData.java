/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author lucas.wojahn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AproachData {
    
    @JsonProperty("close_approach_date")
    private String aproachDate;
    
    @JsonProperty("miss_distance")
    private MissDistance missDistance;
    
    @JsonProperty("relative_velocity")
    private Velocity velocity;

    public String getAproachDate() {
        return aproachDate;
    }

    public MissDistance getMissDistance() {
        return missDistance;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setAproachDate(String aproachDate) {
        this.aproachDate = aproachDate;
    }

    public void setMissDistance(MissDistance missDistance) {
        this.missDistance = missDistance;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
    
    
    
    
    
}
