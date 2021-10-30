package icu.guokai.mekatok.framework.ou.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.service.ServiceImpl;
import icu.guokai.mekatok.framework.ou.model.view.RoleAuthorityView;
import icu.guokai.mekatok.framework.ou.service.IRoleService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职位服务的实现类
 * @author GuoKai
 * @date 2021/8/16
 */
@Service
public class RoleServiceImpl extends ServiceImpl implements IRoleService {

    @Override
    public List<RoleAuthorityView> queryAuthorityById(@NonNull String id) {
        return of(RoleAuthorityView.class).setPositionId(id).selectList();
    }

    @Override
    public IPage<RoleAuthorityView> pageAuthorityById(@NonNull String id) {
        return of(RoleAuthorityView.class).setPositionId(id).selectPage();
    }
}
