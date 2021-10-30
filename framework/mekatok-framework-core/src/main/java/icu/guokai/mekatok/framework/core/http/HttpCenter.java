package icu.guokai.mekatok.framework.core.http;

import com.dtflys.forest.Forest;
import com.dtflys.forest.backend.okhttp3.OkHttp3Backend;
import com.dtflys.forest.callback.SuccessWhen;
import com.dtflys.forest.converter.json.ForestJacksonConverter;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;

import java.time.Duration;
import java.util.List;

/**
 * Http 使用操作中心
 * 包装了 forest 工具
 * @author GuoKai
 * @date 2021/10/30
 */
public abstract class HttpCenter extends Forest {

    static{
        // 设置使用http client框架
        config().setBackendName(OkHttp3Backend.NAME)
                // 修改默认 json 转换器
                .setJsonConverter(new ForestJacksonConverter())
                // 设置执行成功的判断条件
                .setSuccessWhenClass(SuccessCondition.class)
                // 设置请求结果是否打印
                .setLogResponseStatus(true)
                // 设置日志处理程序
                .setLogHandler(new HttpLogHandler())
                // 设置超时
                .setConnectTimeout(Duration.ofSeconds(10))
                // 设置环绕拦截器
                .setInterceptors(List.of(HttpInterceptor.class));
    }

    /**
     * 用于判断 forest工具 执行成功
     * @author GuoKai
     * @date 2021/10/30
     */
    static class SuccessCondition implements SuccessWhen {
        @Override
        public boolean successWhen(ForestRequest req, ForestResponse res) {
            // 请求过程没有异常
            return res.noException()
                    // 并且状态码在 100 ~ 399 范围内
                    && res.statusOk()
                    // 但不能是 203
                    && res.statusIsNot(203);
        }
    }
}
