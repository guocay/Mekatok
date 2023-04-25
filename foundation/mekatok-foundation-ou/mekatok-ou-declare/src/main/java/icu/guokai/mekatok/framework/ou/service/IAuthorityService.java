package icu.guokai.mekatok.framework.ou.service;

import icu.guokai.mekatok.framework.core.service.IService;
import icu.guokai.mekatok.framework.ou.model.table.User;
import lombok.NonNull;

import java.util.List;

/**
 * 权限相关服务接口
 * @author GuoKai
 * @date 2021/8/16
 */
public interface IAuthorityService extends IService {

    /**
     * 根据权限ID获取拥有其的用户
     * @param id 权限ID
     * @return 用户列表
     */
    List<User> queryUsersById(@NonNull String id);

}
