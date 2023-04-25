package com.github.guokaia.mekatok.notice.service;

import com.github.guokaia.mekatok.context.MekatokApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author GuoKai
 * @date 2022/2/5
 */
@SpringCloudApplication
public class NoticeApplication {
    public static void main(String[] args) {
        MekatokApplication.run(NoticeApplication.class, args);
    }
}
