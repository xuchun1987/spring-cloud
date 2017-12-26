package cloud.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by xuchun on 2017/6/6.
 */
public class ErrorFilter extends ZuulFilter {
    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);



    public ErrorFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 9;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        Throwable throwable=ctx.getThrowable();
        return null;
    }
}
