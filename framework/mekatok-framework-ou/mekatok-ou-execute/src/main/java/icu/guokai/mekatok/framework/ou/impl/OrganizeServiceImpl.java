package icu.guokai.mekatok.framework.ou.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.page.PageUtil;
import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import icu.guokai.mekatok.framework.ou.model.table.User;
import icu.guokai.mekatok.framework.ou.model.view.UserOrganizeView;
import icu.guokai.mekatok.framework.ou.service.IOrganizeService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 组织服务的实现类
 * @author GuoKai
 * @date 2021/8/16
 */
@Service
public class OrganizeServiceImpl extends ServiceImpl implements IOrganizeService {

    @Override
    public List<User> queryUserById(@NonNull String id) {
        return of(UserOrganizeView.class).setId(id).selectList()
                .stream().map(item -> pull(User.class, item.getUserId())).collect(Collectors.toList());
    }

    @Override
    public IPage<User> pageUserById(@NonNull String id) {
        return PageUtil.reBuild(of(UserOrganizeView.class).setId(id).selectPage()
                , item -> pull(User.class, item.getUserId()));
    }
}
