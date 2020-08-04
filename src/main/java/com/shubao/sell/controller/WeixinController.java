package com.shubao.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法。。。");
        log.info("code={}", code);//2019-12-28 14:20:27,596 - code=021M5ibd0Atccz1pGfcd0KMhbd0M5ibV

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx99798ab2fc8509ec&secret=7f459dbda57fe01662bab35d85c142a0&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        //2019-12-28 14:20:29,474 - response={"access_token":"28_mob9P2ZRl580QC5aU83tCUPaJU5537HniE0yqSsJqiqbEoPjXsw52qwbx3igZknAG-EKCm3uBsTYsBqpBLo2Mtn86E5Mos6AOfIAqSYd0mA","expires_in":7200,"refresh_token":"28_sgPLwZKBPIyNBRn5X4ReWEZ7RoTtp9LA1VvGiMbDz18ZaFBZvhmnvZK_4ni472MLa6K-LGrNDCJszICtWTH52zkRsz8zkzt3Eq4Q7bzFph4","openid":"oAuvEuM_hrfB3pvgwRIvxvaDFUIE","scope":"snsapi_base"}
    }
}
