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
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore extra fields from API
public class NeoObject {
    private String id;

    @JsonProperty("neo_reference_id")
    private String neoReferenceId;
    
    private String name;

    @JsonProperty("nasa_jpl_url")
    private String nasaJplUrl;

    @JsonProperty("absolute_magnitude_h")
    private double absoluteMagnitudeH;
    
//    @JsonProperty("estimated_diameter")
//    private EstimatedDiameter estimatedDiameter;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

//    @JsonProperty("close_approach_data")
//    private CloseApproachData[] closeApproachData;

    @JsonProperty("is_sentry_object")
    private boolean isSentryObject;

}
