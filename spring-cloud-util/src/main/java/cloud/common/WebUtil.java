package cloud.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.util.*;


/**
 * 常用方法工具类
 * @author xuchun&cqd
 * @date 2017-07-12
 *
 */
public class WebUtil {

	private final static Logger logger = LoggerFactory.getLogger(WebUtil.class);



	/**
	 * 获取异常错误信息打印格式化
	 * xuchun
	 * 2016-09-01
	 * @param e
	 * @return
	 */
	public static  String getErrorInfo(Exception e){
		StringBuilder sb=new StringBuilder();
		//记录到错误日志表
		for(StackTraceElement ste:e.getStackTrace()){
			sb.append(";");
			sb.append("\n");
			sb.append(ste);
		}
		sb.insert(0, e==null?"":e.toString());
		return sb.toString();
	}


	/**
	 * fitlers中解决返回中文乱码
	 * @param obj
	 * @return
	 */
	public static String getStringJsonISO_8859_1(Object obj){
		try {
			return new String(WebUtil.parseFastJson(obj).getBytes(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}


	
	public static String getGuid(){
		return UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
	}


	
	/**
     * object转json字符
     * xuchun
     * 2016-07-07
     * @param object
     * @return
     * @throws Exception
     */
	public static String parseFastJson(Object object){
		return JSON.toJSONString(object);
	}


}
