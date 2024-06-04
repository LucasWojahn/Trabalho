package trabalho;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import trabalho.NeoObject;

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
    // Since the date is dynamic (2024-05-21 in your example), 
    // we can't use a specific property name. Jackson will handle this 
    // automatically by mapping the JSON object key to this field.
    private NeoObject[] neoObjects; 

    // Getter and Setter
    // ...
}
