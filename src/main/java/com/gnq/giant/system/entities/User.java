package com.gnq.giant.system.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 13:28 2019/3/15
 */
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -2480193534807179581L;

    private Integer id;
    private String username;
    private String password;
    private String address;
    private String email;
    private String nickName;
}
