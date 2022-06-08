package com.yfh.ncu_weixin_health;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    // 在一个特定的时间执行这个方法——Timer
    //cron表达式
    // 秒 分 时 日 月 周几

    /*
        0 49 11 * * ?   每天的11点49分00秒执行
        0 0/5 11,12 * * ?   每天的11点和12点每个五分钟执行一次
        0 15 10 ? * 1-6     每个月的周一到周六的10点15分执行一次
        0/2 * * * * ?     每2秒执行一次
     */

//    @Scheduled(cron = "0/3 * * * * ?")
    public void testCron() {
        System.out.println("cron: dfdf" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }


//    @Scheduled(cron = "0 31 21 * * ?")
    @Scheduled(cron = "0 5 6 * * ?")
    public String health() throws Exception {
        Map<String, String> params = new HashMap<>();

        Map<String, String> headers = new HashMap<>();

        params.put("inChina", "是");
        params.put("addressProvince", "江西省");
        params.put("addressCity", "南昌市");
        params.put("temperatureStatus", "正常");
        params.put("temperature", "0");
        params.put("isIll", "否");
        params.put("closeHb", "否");
        params.put("closeIll", "否");
        params.put("healthDetail", "无异常");
        params.put("isIsolation", "否");
        params.put("isolationPlace", "无");
        params.put("userId", "411716620396");
        params.put("addressInfo", "青山湖区南昌大学软件学院");
        params.put("isGraduate", "否");
        params.put("healthStatus", "无异常");
        params.put("isIsolate", "否");
        params.put("isolatePlace", "无");

        headers.put("Cookie",
                "ncu_rygk_work_weixin_userData={%22id%22:365600%2C%22userId%22:%22411716620396%22%2C%22userName%22:%22%E5%8F%B6%E8%8A%B3%E5%8D%8E%22%2C%22userCode%22:%22411716620396%22%2C%22avatar%22:%22gate/image/head/student/postgraduate/f67ec333-ec2d-4510-a805-b792bdc89449.jpeg%22%2C%22sex%22:%22%E7%94%B7%22%2C%22idCard%22:%22360732199612140613%22%2C%22mobile%22:%2218172745452%22%2C%22email%22:null%2C%22originPlace%22:%22%E6%B1%9F%E8%A5%BF%E7%9C%81%E5%85%B4%E5%9B%BD%E5%8E%BF%22%2C%22userType%22:%221%22%2C%22roleId%22:%220005%22%2C%22deptId%22:null%2C%22deptName%22:null%2C%22campus%22:null%2C%22college%22:%228000%22%2C%22collegeName%22:%22%E8%BD%AF%E4%BB%B6%E5%AD%A6%E9%99%A2%22%2C%22major%22:%22085405%22%2C%22majorName%22:null%2C%22grade%22:%222020%22%2C%22aClass%22:null%2C%22className%22:null%2C%22cardId%22:%2207595321370656548519%22%2C%22cardStatus%22:%221%22%2C%22role%22:null}; ncu_rygk_work_weixin_token=eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuIiwic3ViIjoiNDExNzE2NjIwMzk2IiwiaWF0IjoxNjUzOTkzMzk0fQ.b9Ro9tjsiK2MtaHSEHUeRbcF6aZlrnqRrJ_p6qYZY4GbpkeCESB9cbEruZbLTjDKH5R3ZXrzUK9TBe0Y5AkJ8A");
        headers.put("token", "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuIiwic3ViIjoiNDExNzE2NjIwMzk2IiwiaWF0IjoxNjUzOTkzMzk0fQ.b9Ro9tjsiK2MtaHSEHUeRbcF6aZlrnqRrJ_p6qYZY4GbpkeCESB9cbEruZbLTjDKH5R3ZXrzUK9TBe0Y5AkJ8A");

        String response = HttpClientUtils.postForm("http://jc.ncu.edu.cn/gate/student/signIn",
                params, headers, 10000, 10000);
        System.out.println(response);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "打卡");
        return response;
    }
}
