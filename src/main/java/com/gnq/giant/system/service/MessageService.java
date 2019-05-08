package com.gnq.giant.system.service;

import com.gnq.giant.system.dto.MessageDTO;

import java.util.Map;

public interface MessageService {
    public Map<String, Object> getAllMsg(MessageDTO messageDTO);
}
