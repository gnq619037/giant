package com.gnq.giant.system.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by NightGuo on 2019/3/20.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 9:43 2019/3/20
 */
@Data
@AllArgsConstructor
public class TokenModel implements Serializable{
    private static final long serialVersionUID = -3475394725014332051L;
    private User user;
    private String token;
}
