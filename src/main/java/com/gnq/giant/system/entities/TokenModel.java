package com.gnq.giant.system.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by NightGuo on 2019/3/20.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 9:43 2019/3/20
 */
@Data
@AllArgsConstructor
public class TokenModel {
    private User user;
    private String token;
}
