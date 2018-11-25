/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abouna.lacussmsweb.controller.dto;

import java.io.Serializable;

/**
 *
 * @author SATELLITE
 */
public class ResponseDto implements Serializable{

    private boolean received;
    private String reason;

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResponseDto(boolean received, String reason) {
        this.received = received;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ResponseDto{" + "received=" + received + ", reason=" + reason + '}';
    }

}
