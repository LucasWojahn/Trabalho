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
public class Velocity {
    @JsonProperty("kilometers_per_second")
    private String kmS;

    @JsonProperty("kilometers_per_hour")
    private String kmH;

    @JsonProperty("miles_per_hour")
    private String mH;

    public String getKmS() {
        return kmS;
    }

    public String getKmH() {
        return kmH;
    }

    public String getmH() {
        return mH;
    }

    public void setKmS(String kmS) {
        this.kmS = kmS;
    }

    public void setKmH(String kmH) {
        this.kmH = kmH;
    }

    public void setmH(String mH) {
        this.mH = mH;
    }
    
    
    
}
