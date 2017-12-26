package cloud.controller;


import cloud.client.ApiClient;
import cloud.common.WebUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ApiClient apiClient;

    @PostMapping("/users")
    public String users(@RequestBody Map<String,String> body,
                        @RequestParam(value="agencyId",required = true) String agencyId){
        logger.info("----------------consumer-params:"+ agencyId);
        logger.info("----------------consumer-body:"+ WebUtil.parseFastJson(body));
        return apiClient.usersList();
    }
}
