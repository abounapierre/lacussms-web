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
public class IncomingMessageDto implements Serializable {

    private String message;
    private String phone;

    public IncomingMessageDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "IncomingMessageDto{" + "message=" + message + ", phone=" + phone + '}';
    }

}
