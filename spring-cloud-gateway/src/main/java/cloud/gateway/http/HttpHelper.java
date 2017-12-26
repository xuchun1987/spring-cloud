package cloud.gateway.http;

import cloud.common.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HttpHelper {
    private static Logger log= LoggerFactory.getLogger(HttpHelper.class);
	 /** 
     * 获取请求Body 
     * 
     * @param request 
     * @return 
     */  
    public static String getBodyString(ServletRequest request) {  
        StringBuilder sb = new StringBuilder();  
        InputStream inputStream = null;  
        BufferedReader reader = null;  
        try {  
            inputStream = request.getInputStream();  
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));  
            String line = "";  
            while ((line = reader.readLine()) != null) {  
                sb.append(line);  
            }  
        } catch (IOException e) {
            log.error(WebUtil.getErrorInfo(e));
        } finally {
            if (inputStream != null) {  
                try {  
                    inputStream.close();  
                } catch (IOException e) {
                    log.error(WebUtil.getErrorInfo(e));
                }
            }  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e) {
                    log.error(WebUtil.getErrorInfo(e));
                }
            }  
        }  
        return sb.toString();  
    }  
}
