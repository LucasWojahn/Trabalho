/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author lucas.wojahn
 */
public class Kilometers {

    @JsonProperty("estimated_diameter_min")
    private String min;
    @JsonProperty("estimated_diameter_max")
    private String max;

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setMax(String max) {
        this.max = max;
    }
    
    

}
