package com.jnh.core.services.errors.dto;

/**
 * @author José Núñez Herrero
 * 
 *         Error Id class.
 */
public class ErrorId {

    private String category;
    private String id;
    private String descriptionPattern;

    /**
     * Constructor.
     */
    public ErrorId() {
    }

    /**
     * Constructor.
     * 
     * @param category
     *            category type.
     * @param id
     *            identifier.
     */
    public ErrorId(String category, String id) {
        this.category = category;
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ErrorId [category=" + category + ", id=" + id
                + ", descriptionPatter=" + descriptionPattern + "]";
    }

    public String getDescriptionPattern() {
        return descriptionPattern;
    }

    public void setDescriptionPattern(String descriptionPattern) {
        this.descriptionPattern = descriptionPattern;
    }
}
