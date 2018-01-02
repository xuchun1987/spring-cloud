package cloud.controller;


import cloud.redis.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RedisService redisService;

    @PostMapping("/list")
    public List<Map<String,String>> usersList(){
        logger.info("---------------provider:------");
        List<Map<String,String>> list= new ArrayList<>();
        Map<String,String> map=new HashMap<String,String>();
        map.put("name","xuchun");
        map.put("age","30");
        Map<String,String> map2=new HashMap<String,String>();
        map2.put("name","wangfei");
        map2.put("age","31");
        list.add(map);
        list.add(map2);
        return list;
    }

    @PostMapping("/redis")
    public String redisTest(String key){
       return redisService.get(key);
    }
}
