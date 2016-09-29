/**
 * Assignment 1
 * To wrap the response
 * @author Arpit Pittie
 */
package com.controller;

public class Response {

	private int status;			//Setting the status code for the request
    private String errorMessage;//Setting the error against the request if any
    private Object data;		//Setting the data to be given against the request

    public Response(Object data) {
        status = 0;
        this.data = data;
    }

    public Response(int errorCode, String errorMessage) {
        status = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
