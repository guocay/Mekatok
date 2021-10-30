package icu.guokai.mekatok.framework.ou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.service.IService;
import icu.guokai.mekatok.framework.ou.model.table.User;

import java.util.List;

/**
 * 组织相关服务接口
 * @author GuoKai
 * @date 2021/8/16
 */
public interface IOrganizeService extends IService {

    /**
     * 根据组织获取用户
     * @param organizeId 组织ID
     * @return 用户列表
     */
    List<User> queryUserById(String organizeId);

    /**
     * 根据组织获取用户
     * 分页信息在当前线程的请求头中取
     * @param organizeId 组织ID
     * @return 用户列表 - 分页
     */
    IPage<User> pageUserById(String organizeId);
}
