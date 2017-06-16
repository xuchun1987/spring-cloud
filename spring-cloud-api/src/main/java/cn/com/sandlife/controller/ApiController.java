package cn.com.sandlife.controller;

import cn.com.sandlife.client.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xuchun on 2017/5/20.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ApiClient apiClient;


    @RequestMapping("/index")
    public Object index(){
       logger.info("---------------------------------------");
        logger.info(new Date().toString());
        return apiClient.index();
    }
}
