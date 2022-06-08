package com.yfh.ncu_weixin_health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    private HealthService service;

    @GetMapping("/test")
    public String test() {
        service.testCron();
        return "测试成功";
    }

    @GetMapping("/health")
    public String health() throws Exception {
        String health = service.health();
        return health;
    }
}
