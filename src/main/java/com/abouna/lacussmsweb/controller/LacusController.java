/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abouna.lacussmsweb.controller;

import com.abouna.lacussmsweb.controller.dto.IncomingMessageDto;
import com.abouna.lacussmsweb.controller.dto.ResponseDto;
import com.abouna.lacussmsweb.model.Command;
import com.abouna.lacussmsweb.model.ICommandDao;
import com.abouna.lacussmsweb.model.IServiceOffertDao;
import com.abouna.lacussmsweb.model.Status;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SATELLITE
 */
@RestController
@RequestMapping("/services")
public class LacusController {

    @Autowired
    private ICommandDao commandDao;
    @Autowired
    private IServiceOffertDao serviceOffertDao;

    @PostMapping("/message/received")
    public @ResponseBody
    ResponseDto saveCommand(@RequestBody IncomingMessageDto messageDto) {
        System.out.println(messageDto.toString());
        return new ResponseDto(true, "");
    }

    @GetMapping("/message/save")
    @Transactional
    public @ResponseBody
    ResponseDto receivedSms(
            @RequestParam(name = "phoneNumber") String phoneNumber,
            @RequestParam(name = "message") String message) {
        System.out.println(phoneNumber + " " + message);
        Command command = new Command();
        String[] token = message.split(" ");
        String msg = message;
        if (msg.replace(" ", "").length() > 0) {
            serviceOffertDao.findServiceOffertByActifTrue().stream().forEach((_item) -> {
                if (token[0].toLowerCase().contains(_item.getCode().toLowerCase())) {
                    command.setOpe(_item.getCode());
                }
            });
            command.setContent(message);
            command.setPhone(phoneNumber);
            command.setSendDate(new Date());
            command.setStatus(Status.PENDING);
            command.setCompte(token[1]);
            commandDao.save(command);
        }
        return new ResponseDto(true, "OK");
    }
}
