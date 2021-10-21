import {extend} from 'umi-request'
import nprogress from 'nprogress'
import 'nprogress/nprogress.css'
/**
 * 配置ajax请求
 */
const http = extend({
    timeout: 5*1000,
    errorHandler: (error) => {
        console.log(error.message)
    }
})

/**
 * 设置环绕处理
 * @param ctx 上下文
 * @param next 执行函数
 */
http.use(async (ctx, next) => {
    console.log(ctx.req)
    await next()
})

/**
 * 设置请求前守卫
 * @param url 请求地址
 * @param options 请求配置项
 */
http.interceptors.request.use((url, options) => {
    nprogress.start()
    return {url, ...options}
})

/**
 * 设置请求后守卫
 * @param response 返回值
 * @param options 配置项
 */
http.interceptors.response.use((response, options) => {
    nprogress.done();
    return response
})

export default http
