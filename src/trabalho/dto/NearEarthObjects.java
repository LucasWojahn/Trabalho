package trabalho.dto;


import trabalho.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucas.wojahn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NearEarthObjects {
    private NeoObject[] neoObjects; 
}
