package icu.guokai.mekatok.framework.ou.impl;

import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import icu.guokai.mekatok.framework.ou.model.table.User;
import icu.guokai.mekatok.framework.ou.model.view.UserAuthorityView;
import icu.guokai.mekatok.framework.ou.service.IAuthorityService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限服务的实现类
 * @author GuoKai
 * @date 2021/8/16
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl implements IAuthorityService {

    @Override
    public List<User> queryUsersById(@NonNull String id) {
        return of(UserAuthorityView.class).setId(id).selectList()
                .stream().map(item -> pull(User.class,item.getUserId()))
                .collect(Collectors.toList());
    }

}
