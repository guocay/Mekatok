package icu.guokai.mekatok.framework.ou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.service.IService;
import icu.guokai.mekatok.framework.ou.model.view.UserAuthorityView;
import icu.guokai.mekatok.framework.ou.model.view.UserOrganizeView;
import icu.guokai.mekatok.framework.ou.model.view.UserRoleView;

import java.util.List;

/**
 * 用户相关接口
 * @author GuoKai
 * @date 2021/8/16
 */
public interface IUserService extends IService {

    /**
     * 根据用户获取部门
     * @param id 用户ID
     * @return 组织列表
     */
    List<UserOrganizeView> queryOrganizeById(String id);

    /**
     * 根据用户获取部门
     * @param id 用户ID
     * @return 组织列表
     */
    IPage<UserOrganizeView> pageOrganizeById(String id);

    /**
     * 根据用户获取职位
     * @param id 用户ID
     * @return 组织列表
     */
    List<UserRoleView> queryPositionById(String id);

    /**
     * 根据用户获取职位
     * @param id 用户ID
     * @return 组织列表
     */
    IPage<UserRoleView> pagePositionById(String id);

    /**
     * 根据用户获取权限
     * @param id 用户ID
     * @return 权限列表
     */
    List<UserAuthorityView> queryAuthorityById(String id);

    /**
     * 根据用户获取权限
     * @param id 用户ID
     * @return 权限列表
     */
    IPage<UserAuthorityView> pageAuthorityById(String id);

}
