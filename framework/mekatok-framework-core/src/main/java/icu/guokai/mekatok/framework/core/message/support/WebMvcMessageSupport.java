package icu.guokai.mekatok.framework.core.message.support;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.message.Message;
import icu.guokai.mekatok.framework.core.message.mvc.WebMvcMessageUtil;
import icu.guokai.mekatok.framework.core.mistake.MekatokException;
import icu.guokai.mekatok.framework.core.mistake.MistakeCode;
import icu.guokai.mekatok.framework.tool.servlet.ServletUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 平台内用于返回WebMvcMessageSupport的扩展支持
 * @author GuoKai
 * @date 2021/8/13
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public interface WebMvcMessageSupport extends MessageSupport {

    /**
     * 默认的异常消息体实现
     */
    MekatokException DEFAULT_EX = new MekatokException("Unknown mistake!");

    /**
     * 默认的正常消息体实现
     */
    Message DEFAULT_MES = Message.of().defaults();

    /**
     * 返回处理成功的消息
     * @return 返回对象
     */
    default ResponseEntity<Boolean> success(){
        return success(Boolean.TRUE);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param status 状态
     * @return 返回对象
     */
    default <T> ResponseEntity<T> success(HttpStatus status){
        return success(null, status);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param body http内容
     * @return 返回对象
     */
    default <T> ResponseEntity<T> success(T body){
        return success(body, HttpStatus.OK);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param body http内容
     * @param headers http消息头
     * @return 返回对象
     */
    default <T> ResponseEntity<T> success(T body, MultiValueMap<String, String> headers){
        return success(body, headers, null);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param body http内容
     * @param status 状态
     * @return 返回对象
     */
    default <T> ResponseEntity<T> success(T body, HttpStatus status){
        return success(body, null, status);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param body http内容
     * @param headers http消息头
     * @param status 状态
     * @return 返回对象
     */
    default <T> ResponseEntity<T> success(T body, MultiValueMap<String, String> headers, HttpStatus status){
        Object data = body;
        String current ="1", size = "-1", total = "1";
        headers = Optional.ofNullable(headers).orElse(new HttpHeaders());
        if(ObjectUtil.isNull(body)){
            total = "0";
        }else if(body instanceof Collection){
            var coll = (Collection)body;
            total = NumberUtil.toStr(coll.size());
        }else if(body instanceof IPage){
            var page = (IPage<T>)body;
            data = page.getRecords();
            current = NumberUtil.toStr(page.getCurrent());
            size = NumberUtil.toStr(page.getSize());
            total = NumberUtil.toStr(page.getTotal() == 0 ? page.getRecords().size() : page.getTotal());
        }
        headers.set(Global.DATA_CURRENT_MARK, current);
        headers.set(Global.DATA_SIZE_MARK, size);
        headers.set(Global.DATA_TOTAL_MARK, total);
        return WebMvcMessageUtil.receipt(DEFAULT_MES.clone().setData(data), headers, status);
    }

    /**
     * 文件下载
     * @param fileName 文件名称
     * @param file 文件
     * @return 下载对象
     */
    default ResponseEntity downloadFile(String fileName, byte[] file){
        var header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        header.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment;filename=%s",
                URLEncoder.encode(fileName,StandardCharsets.UTF_8)));
        return new ResponseEntity(file, header, HttpStatus.OK);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @return 返回对象
     */
    default <T> ResponseEntity<T> failure(){
        return failure(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param <F> 泛型
     * @param mistake 错误信息
     * @return 返回对象
     */
    default <T, F extends Throwable> ResponseEntity<T> failure(F mistake){
        return failure(mistake,null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param status 状态
     * @return 返回对象
     */
    default <T> ResponseEntity<T> failure(HttpStatus status){
        return failure(null, status);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param headers http消息头
     * @return 返回对象
     */
    default <T> ResponseEntity<T> failure(MultiValueMap<String, String> headers){
        return failure(headers,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param headers http消息头
     * @param status 状态
     * @return 返回对象
     */
    default <T> ResponseEntity<T> failure(MultiValueMap<String, String> headers, HttpStatus status){
        return failure(null, headers, status);
    }


    /**
     * 返回处理成功的消息
     * @param <T> 泛型
     * @param <F> 泛型
     * @param mistake 错误信息
     * @param headers http消息头
     * @param status 状态
     * @return 返回对象
     */
    default <T, F extends Throwable> ResponseEntity<T> failure(F mistake, MultiValueMap<String, String> headers, HttpStatus status){
        mistake = Optional.ofNullable(mistake).orElse((F) DEFAULT_EX);
        var exCode = AnnotationUtil.<String>getAnnotationValue(mistake.getClass(),MistakeCode.class);
        var message = Message.of().setSuccess(false).setTips(mistake.getMessage()).setData(exCode);
        return WebMvcMessageUtil.receipt(message, headers, status);
    }

    /**
     * 函数式回调,会默认回传request和response
     * @param fun lambda表达式
     * @param <T> 泛型
     * @return 返回对象
     */
    default <T> ResponseEntity script(BiFunction<HttpServletRequest, HttpServletResponse, T> fun){
        var obj = fun.apply(ServletUtil.getRequest(),ServletUtil.getResponse());
        if(obj instanceof Throwable){
            return failure((Throwable) obj);
        }else{
            return success(obj);
        }
    }

    /**
     * 返回对象的执行服务
     * @param fun lambda表达式
     * @return 返回对象
     */
    default <T> ResponseEntity script(Supplier<T> fun){
        var obj = fun.get();
        if(obj instanceof Throwable){
            return failure((Throwable) obj);
        }else{
            return success(obj);
        }
    }

}
