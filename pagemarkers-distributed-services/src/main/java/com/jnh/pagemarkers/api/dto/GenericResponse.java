package com.jnh.pagemarkers.api.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Generic Wallet Response. Response for error purposes.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class GenericResponse {
    /**
     * Code Number.
     */
    private String id;
    /**
     * SVC or SVC.
     */
    private String category;
    /**
     * Description of the error.
     */
    private String description;
    /**
     * Details of the error.
     */
    private String details;

    /**
     * Constructor.
     */
    public GenericResponse() {
    }

    /**
     * Constructor.
     * 
     * @param id
     * @param category
     * @param description
     * @param details
     */
    public GenericResponse(String id, String category, String description, String details) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.details = details;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "GenericResponse [id=" + this.id + ", category=" + this.category + ", description="
                + this.description + ", details=" + this.details + "]";
    }

}
