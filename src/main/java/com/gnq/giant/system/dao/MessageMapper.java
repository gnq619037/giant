package com.gnq.giant.system.dao;

import com.gnq.giant.system.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    public List<MessageDTO> getAllMessage(MessageDTO messageDTO);
}
