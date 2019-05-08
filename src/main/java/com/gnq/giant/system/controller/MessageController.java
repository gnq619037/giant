package com.gnq.giant.system.controller;

import com.gnq.giant.system.dto.MessageDTO;
import com.gnq.giant.system.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
@RestController
@RequestMapping(value = "/giant/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public Object getAllMsg(@RequestBody MessageDTO messageDTO){
        Map<String, Object> map = messageService.getAllMsg(messageDTO);
        return map;
    }
}
