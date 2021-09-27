package icu.guokai.mekatok.framework.ou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.service.IService;
import icu.guokai.mekatok.framework.ou.model.view.RoleAuthorityView;

import java.util.List;

/**
 * 职位相关接口
 * @author GuoKai
 * @date 2021/8/16
 */
public interface IRoleService extends IService {

    /**
     * 根据职位获取权限
     * @param id 职位ID
     * @return 权限对象
     */
    List<RoleAuthorityView> queryAuthorityById(String id);

    /**
     * 根据职位获取权限
     * @param id 职位ID
     * @return 权限对象
     */
    IPage<RoleAuthorityView> pageAuthorityById(String id);
}
