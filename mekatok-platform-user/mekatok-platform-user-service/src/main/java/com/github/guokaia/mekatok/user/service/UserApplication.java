package com.github.guokaia.mekatok.user.service;

import com.github.guokaia.mekatok.context.MekatokApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 用户服务
 * @author GuoKai
 * @date 2022/2/4
 */
@SpringCloudApplication
public class UserApplication {
    public static void main(String[] args) {
        MekatokApplication.run(UserApplication.class, args);
    }
}
