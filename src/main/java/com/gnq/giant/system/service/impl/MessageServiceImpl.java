package com.gnq.giant.system.service.impl;

import com.gnq.giant.system.dao.MessageMapper;
import com.gnq.giant.system.dto.MessageDTO;
import com.gnq.giant.system.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageMapper messageMapper;


    public Map<String, Object> getAllMsg(MessageDTO messageDTO) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<MessageDTO> list = messageMapper.getAllMessage(messageDTO);
        resultMap.put("result", list);
        resultMap.put("success", true);
        return resultMap;
    }
}
