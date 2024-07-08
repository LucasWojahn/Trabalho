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
public class Diameter {

    @JsonProperty("kilometers")
    private Kilometers kilometer;

    public Kilometers getKilometer() {
        return kilometer;
    }

    public void setKilometer(Kilometers kilometer) {
        this.kilometer = kilometer;
    }

}
