package cn.com.sandlife.client;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuchun on 2017/5/20.
 */
@Component
public class ApiClientHystrix implements ApiClient{

    @Override
    public Object index() {
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("code","02");
        res.put("msg","断路由生效！");
        return res;
    }
}
