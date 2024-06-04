/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.dto;

import trabalho.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author lucas.wojahn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeoFeed {
    @JsonProperty("element_count")
    private int elementCount;

    @JsonProperty("near_earth_objects")
    private NearEarthObjects nearEarthObjects;
    
    public int getCount(){
        return this.elementCount;
    }
}
