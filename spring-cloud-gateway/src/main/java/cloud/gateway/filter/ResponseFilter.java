package cloud.gateway.filter;

import cloud.common.WebUtil;
import cloud.common.entity.ResultEntity;
import cloud.common.enums.ResCode;
import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by xuchun on 2017/6/6.
 */
@Component
public class ResponseFilter extends ZuulFilter {

    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);








    public ResponseFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx=RequestContext.getCurrentContext();
        Boolean isPass=(Boolean) ctx.get("isPass");
	   	 if(isPass!=null&&!isPass){
	   		return null;
	   		 
	   	 }
        HttpServletRequest request=ctx.getRequest();
        String agencyId=request.getParameter("agencyId");
        try {
	
         /* if(StringUtils.isEmpty(agencyId)){
              log.error("ResponseFilter过滤器中未获取到请求agencyId，不能对返回数据进行签名！");
              return null;
          }*/
            InputStream input = ctx.getResponseDataStream();
            String responseData = CharStreams.toString(new InputStreamReader(input, "UTF-8"));
            log.info("--------------读取api返回流字符串："+responseData);
            ctx.setResponseBody(responseData);
            return null;

        }catch(Exception e){
            log.error(WebUtil.getErrorInfo(e));
            ctx.setSendZuulResponse(false);
            ResultEntity entity=new ResultEntity();
            entity.setCode(ResCode.系统异常.value());
            entity.setMsg(ResCode.系统异常.name());
            ctx.setResponseBody(WebUtil.parseFastJson(entity));
            return null;
        }

      
    }
}
