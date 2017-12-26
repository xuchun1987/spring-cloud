package cloud.gateway.filter;

import cloud.common.WebUtil;
import cloud.common.entity.ResultEntity;
import cloud.common.enums.ResCode;
import cloud.gateway.http.BodyReaderHttpServletRequestWrapper;
import cloud.gateway.http.HttpHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccessFilter extends ZuulFilter {

	private static Logger log=LoggerFactory.getLogger(AccessFilter.class);





	@Override
	public Object run() {

		RequestContext ctx=RequestContext.getCurrentContext();
		try {

			HttpServletRequest request=ctx.getRequest();
			log.info(" request method："
					+request.getMethod()+"\n request url："+request.getRequestURL().toString());

			//请求参数效验
			String agencyId=request.getParameter("agencyId");
			String sign=request.getParameter("sign");
			ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
			String body = HttpHelper.getBodyString(requestWrapper);
			log.info("---------------AccessFilter获取params-----------");
			log.info(request.getQueryString());
			log.info("---------------AccessFilter获取body-----------");
			log.info(body);
			//检查header params
			if(StringUtils.isEmpty(agencyId)){
				ctx.setSendZuulResponse(false);
				ResultEntity entity=new ResultEntity();
				entity.setCode(ResCode.请求参数验证不通过.value());
				entity.setMsg("agencyId不能为空！");
				ctx.setResponseBody(WebUtil.getStringJsonISO_8859_1(entity));
				ctx.set("isPass", false);
				log.info("---------------检查header params验证未过-----------");
				return null;
			}

			//检查body
			if(StringUtils.isEmpty(body)){
				ctx.setSendZuulResponse(false);
				ResultEntity entity=new ResultEntity();
				entity.setCode(ResCode.请求参数验证不通过.value());
				entity.setMsg("请求体body不能为空！");
				ctx.setResponseBody(WebUtil.getStringJsonISO_8859_1(entity));
				ctx.set("isPass", false);
				log.info("---------------检查body验证未过-----------");
				return null;
			}

			return null;
		}catch(Exception e){
			log.error(WebUtil.getErrorInfo(e));
			ctx.setSendZuulResponse(false);
			ResultEntity entity=new ResultEntity();
			entity.setCode(ResCode.系统异常.value());
			entity.setMsg(ResCode.系统异常.name());
			ctx.setResponseBody(WebUtil.getStringJsonISO_8859_1(entity));
			ctx.set("isPass", false);
			return null;
		}
	}

	@Override
	public boolean shouldFilter() {
		//过滤器的执行范围，类似拦截的路径范围
		return true;
	}

	@Override
	public int filterOrder() {
		//根据值类判断过滤器的执行顺序，类似于优先级权重
		return 0;
	}

	@Override
	public String filterType() {
		//类型为pre，请求在被路由前执行
		return "pre";
	}

}
