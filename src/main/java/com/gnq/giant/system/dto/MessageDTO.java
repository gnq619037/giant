package com.gnq.giant.system.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
public class MessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer msgType;
    private String msgContent;
    private Date sendTime;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
