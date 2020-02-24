package com.zjy.small.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @PackageName: com.zjy.small.demo
 * @ClassName: HelloSpring
 * @Description: 第一个sprigboot程序测试
 * @Author: ZhaoJinYuan
 * @Date: 2019/12/17 17:17
 */

@RestController
public class HelloSpring {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World Spring Boot...";
    }

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public ModelAndView firstDemo() {
        return new ModelAndView("echarts");
    }

   /* @RequestMapping(value = "/getrili", method = RequestMethod.GET)
    public ModelAndView getrili() {
        return new ModelAndView("rili");
    }*/
}
