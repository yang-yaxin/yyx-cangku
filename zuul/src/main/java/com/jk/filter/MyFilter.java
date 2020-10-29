package com.jk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    /*
        filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
            pre：路由之前 ,先执行过滤器再执行后台方法
            routing：路由之时, 执行完后台方法在执行过滤器
            post： 路由之后, 执行完后台方法在执行过滤器
            error：发送错误调用，如果请求正常没有错误，则不需要执行业务逻辑判断
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤的顺序 filterOrder：返回int数据，
    // 用于为同filterType的多个过滤器定制执行顺序，返回值越小，执行顺序越优先。
    @Override
    public int filterOrder() {
        return 0;
    }

    //这里可以写逻辑判断，是否要过滤，true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() throws ZuulException {

        System.out.println("执行过滤器业务");

        // 获取request对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String url = request.getRequestURL().toString();  //获取请求的路径
        String method = request.getMethod();  // 获取请求的方法
        String token = request.getHeader("token"); // token
        System.out.println(url);
        System.out.println(method);
        System.out.println(token);
        if(token == null || "".equals(token)) {
            try {
                System.out.println("token 为空，用户没有登录");
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(401);  //Unauthorized 请求要求用户的身份认证失败

                // 获取response对象
                HttpServletResponse response = requestContext.getResponse();
                //让浏览器用utf8来解析返回的数据
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                //servlet用UTF-8转码，而不是用默认的ISO8859
                response.setCharacterEncoding("utf-8");
                response.getWriter().write("用户认证失败，请求未携带token参数");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
