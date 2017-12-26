package cloud.test;


import cloud.common.AsyncHttpClientUtil;
import cloud.common.WebUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestApi {

    @Test
    public void test1(){
        String url="http://localhost:48080/api-a/api/users?agencyId=xx";
        Map<String,String> body=new HashMap<String,String>();
        body.put("a","11");
        body.put("b","22");
        String result=AsyncHttpClientUtil.post(url, WebUtil.parseFastJson(body));
        System.out.println(result);
    }
}
