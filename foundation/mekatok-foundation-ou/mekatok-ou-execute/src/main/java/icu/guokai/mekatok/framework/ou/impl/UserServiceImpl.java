package icu.guokai.mekatok.framework.ou.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import icu.guokai.mekatok.framework.ou.model.view.UserAuthorityView;
import icu.guokai.mekatok.framework.ou.model.view.UserOrganizeView;
import icu.guokai.mekatok.framework.ou.model.view.UserRoleView;
import icu.guokai.mekatok.framework.ou.service.IUserService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务的实现类
 * @author GuoKai
 * @date 2021/8/16
 */
@Service
public class UserServiceImpl extends ServiceImpl implements IUserService {

    @Override
    public List<UserOrganizeView> queryOrganizeById(@NonNull String id) {
        return of(UserOrganizeView.class).setUserId(id).selectList();
    }

    @Override
    public IPage<UserOrganizeView> pageOrganizeById(@NonNull String id) {
        return of(UserOrganizeView.class).setUserId(id).selectPage();
    }

    @Override
    public List<UserRoleView> queryPositionById(@NonNull String id) {
        return of(UserRoleView.class).setUserId(id).selectList();
    }

    @Override
    public IPage<UserRoleView> pagePositionById(@NonNull String id) {
        return of(UserRoleView.class).setUserId(id).selectPage();
    }

    @Override
    public List<UserAuthorityView> queryAuthorityById(@NonNull String id) {
        return of(UserAuthorityView.class).setUserId(id).selectList();
    }

    @Override
    public IPage<UserAuthorityView> pageAuthorityById(@NonNull String id) {
        return of(UserAuthorityView.class).setUserId(id).selectPage();
    }

}
