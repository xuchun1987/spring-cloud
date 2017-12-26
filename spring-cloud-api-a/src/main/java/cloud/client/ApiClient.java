package cloud.client;

import cloud.client.impl.ApiClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value ="spring-cloud-provider-a", fallback = ApiClientImpl.class)
public interface ApiClient {

    @RequestMapping(method = RequestMethod.POST, value = "/users/list")
    String usersList();
}
