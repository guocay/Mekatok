package com.github.guokaia.mekatok.user.service.handler;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.guokaia.mekatok.common.asserts.Assertions;
import com.github.guokaia.mekatok.common.handler.AbstractHandler;
import com.github.guokaia.mekatok.user.expose.model.table.User;
import com.github.guokaia.mekatok.user.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import static com.github.guokaia.mekatok.common.Global.ENCODER;

/**
 * 用户服务处理器
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/7
 */
@Service
public class UserHandlerImpl extends AbstractHandler implements UserHandler {

    private final UserMapper mapper;

    public UserHandlerImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User matches(String loginName, String password) {
        User user = mapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getLoginName, loginName));
        Assertions.assertThat(user).as(Assertions.ex("当前用户不存在")).isNotNull();
        Assertions.assertThat(ENCODER.matches(password, user.getPassword())).as(Assertions.ex("当前用户密码错误")).isTrue();
        return user;
    }
}
