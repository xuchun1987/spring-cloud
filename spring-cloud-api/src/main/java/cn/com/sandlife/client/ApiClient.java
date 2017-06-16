package cn.com.sandlife.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xuchun on 2017/5/20.
 */
@FeignClient(value="spring-cloud-service",fallback = ApiClientHystrix.class)
public interface ApiClient {

    @RequestMapping(method = RequestMethod.POST, value = "/index/service")
    Object index();
}
