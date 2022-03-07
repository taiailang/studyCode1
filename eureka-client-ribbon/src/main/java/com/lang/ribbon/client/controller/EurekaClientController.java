package com.lang.ribbon.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Raye on 2017/5/22.
 */
@RestController
public class EurekaClientController {

    @Autowired
    private RestTemplate template;

    @RequestMapping("hello")
    public String ribbon(String name){
        return template.getForObject("http://SERVICE-HI/ribbonhello?name="+name,String.class);
    }

    @RequestMapping("feignhello")
    public String hello(String name){
        return "hello "+name+" this is ribbon spring cloud";
    }

    /**
     * 自测远程调用
     * @return
     */
    @RequestMapping("test")
    public String test(){
        return template.getForObject("http://SERVICE-HI/test",String.class);
    }
}
