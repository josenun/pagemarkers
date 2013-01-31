package com.jnh.core.services.errors.dto;

/**
 * @author José Núñez Herrero
 * 
 *         Error definition class.
 * 
 */
public class ErrorDefinition {
    private ErrorId errorId;
    private String name;
    private String txt;
    private String httpStatusCode;

    /**
     * Constructor.
     */
    public ErrorDefinition() {
    }

    /**
     * Constructor.
     * 
     * @param errorId
     *            ErrorId.
     * @param name
     *            Name text.
     * @param txt
     *            Description Text.
     * @param httpStatusCode
     *            HTTP response Code.
     */
    public ErrorDefinition(ErrorId errorId, String name, String txt,
            String httpStatusCode) {
        this.errorId = errorId;
        this.name = name;
        this.txt = txt;
        this.httpStatusCode = httpStatusCode;
    }

    public ErrorId getErrorId() {
        return errorId;
    }

    public void setErrorId(ErrorId errorId) {
        this.errorId = errorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

}
