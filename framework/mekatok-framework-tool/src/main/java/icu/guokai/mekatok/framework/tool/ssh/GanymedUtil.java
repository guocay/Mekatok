package icu.guokai.mekatok.framework.tool.ssh;

import ch.ethz.ssh2.SCPClient;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 使用scp命令通过ssh2协议的方式,发送文件至指定网络位置
 * @author GuoKai
 * @date 2021/8/16
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GanymedUtil extends cn.hutool.extra.ssh.GanymedUtil {

    /**
     * 用于缓存创建的Client
     */
    private static final Map<String, SCPClient> data = MapUtil.newHashMap();

    /**
     * 返回一个连接,并根据host+port+user+pass作为缓存下来.
     * @param host 主机IP
     * @param port ssh2端口
     * @param user 用户名
     * @param pass 密码
     * @return 可用的ssh2连接
     * @throws IOException 连接异常
     */
    public static SCPClient openScpClient(String host, int port, String user, String pass) throws IOException {
        var key = String.format("%s%s%s%s", host, port, user, pass);
        if(!data.containsKey(key)){
            var conn = connect(host, port);
            Assert.isTrue(conn.authenticateWithPassword(user,pass));
            data.put(key, new SCPClient(conn));
        }
        return data.get(key);
    }

    /**
     * 发送一个文件至远程目录
     * @param host 主机IP
     * @param port ssh2端口
     * @param user 用户名
     * @param pass 密码
     * @param file 文件
     * @param remoteDir 远程地址
     * @return 可用的ssh2连接
     */
    @SneakyThrows
    public static Boolean sendFileForScp(String host, int port, String user, String pass, File file, String remoteDir){
        openScpClient(host, port, user, pass).put(file.getPath(),remoteDir);
        return true;
    }

}
