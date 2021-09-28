package icu.guokai.mekatok.framework.security.route;

import cn.hutool.core.lang.Assert;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.security.mistake.AuthorityShortException;
import icu.guokai.mekatok.framework.security.mistake.NotLoggedInException;
import icu.guokai.mekatok.framework.security.mistake.UserLoggedException;
import icu.guokai.mekatok.framework.security.user.SecurityUser;
import icu.guokai.mekatok.framework.security.util.UserContextHolder;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录退出Router的基类
 * @author GuoKai
 * @date 2021/8/18
 */
@SuppressWarnings("all")
public abstract class BasicSecurityRouter extends Router {

    /**
     * 用户已登录缓存
     */
    @Autowired
    private UserCache cache;

    /**
     * 退出登录时,请求的URL
     */
    public static final String LOGIN_URL = "/login";

    /**
     * 退出登录时,请求的URL
     */
    public static final String LOGOUT_URL = "/logout";

    /**
     * 获取当前登录用户
     */
    public static final String CURRENT_USER_URL = Global.BASIC_SERVICE_PATH + "/currentUser";

    /**
     * 用户已登录异常
     */
    protected static final UserLoggedException USER_LOGGED = new UserLoggedException("The current user is logged in.");

    /**
     * 定义默认的异常返回消息体
     */
    private static final NotLoggedInException NOT_LOGGED_IN =
            new NotLoggedInException("This interface requires login certification!");
    private static final AuthorityShortException AUTHORITY_SHORT =
            new AuthorityShortException("This interface requires higher authorization");

    /**
     * 退出登录
     * @return 操作成功
     */
    @GetMapping(LOGOUT_URL)
    @ApiOperation(value = "退出接口", notes = "用户注销登录服务")
    public ResponseEntity<Boolean> logout(){
        var username = UserContextHolder.getLoginName();
        Assert.notNull(username,() -> NOT_LOGGED_IN);
        cache.removeUserFromCache(username);
        return success();
    }

    @GetMapping(CURRENT_USER_URL)
    @ApiOperation(value = "用户接口", notes = "获取当前登录的用户服务")
    public ResponseEntity<SecurityUser> currentUser(){
        return script(() -> {
            var user = (SecurityUser) UserContextHolder.getUserDetails();
            Assert.notNull(user,() -> NOT_LOGGED_IN);
            return user;
        });
    }

    /**
     * 转发'401'状态码
     * 这个接口需要登录认证
     * @return 返回对象
     */
    @ApiIgnore
    @RequestMapping("/" + HttpServletResponse.SC_UNAUTHORIZED)
    public ResponseEntity<String> unAuthorized(){
        return failure(NOT_LOGGED_IN);
    }

    /**
     * 转发'403'状态码
     * 这个接口需要更高授权
     * @return 返回对象
     */
    @ApiIgnore
    @RequestMapping("/" + HttpServletResponse.SC_FORBIDDEN)
    public ResponseEntity<String> forbidden(){
        return failure(AUTHORITY_SHORT);
    }

}
