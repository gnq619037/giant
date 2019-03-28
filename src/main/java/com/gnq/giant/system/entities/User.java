package com.gnq.giant.system.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by NightGuo on 2019/3/15.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 13:28 2019/3/15
 */
@ApiModel
@Data
public class User implements Serializable{

    private static final long serialVersionUID = -2480193534807179581L;

    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    private String password;
    private String address;
    private String email;
    private String nickName;
}
