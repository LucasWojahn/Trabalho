/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.dto;

import trabalho.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author lucas.wojahn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NearEarthObject {

    @JsonProperty("id")
    private String id;

    @JsonProperty("neo_reference_id")
    private String neoReferenceId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nasa_jpl_url")
    private String nasaJplUrl;

    @JsonProperty("absolute_magnitude_h")
    private double absoluteMagnitudeH;

    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    @JsonProperty("is_sentry_object")
    private boolean isSentryObject;
    
    @JsonProperty("estimated_diameter")
    private Diameter diameter;
    
    @JsonProperty("close_approach_data")
    private List<AproachData> aproachData;

    
    public void setId(String id) {
        this.id = id;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public void setIsPotentiallyHazardousAsteroid(boolean isPotentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
    }

    public void setIsSentryObject(boolean isSentryObject) {
        this.isSentryObject = isSentryObject;
    }

    public void setAproachData(List<AproachData> aproachData) {
        this.aproachData = aproachData;
    }

    public String getId() {
        return id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public boolean isIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public boolean isIsSentryObject() {
        return isSentryObject;
    }
    
    public List<AproachData> getAproachData() {
        return aproachData;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }
    
    

    
    
}
