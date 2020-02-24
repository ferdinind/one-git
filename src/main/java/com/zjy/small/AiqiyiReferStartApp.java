package com.zjy.small;

import com.zjy.small.dao.AiqiyiCountDao;
import com.zjy.small.dao.AiqiyiReferCountDao;
import com.zjy.small.domain.AiqiyiCount;
import com.zjy.small.domain.ReferCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.zjy.small
 * @ClassName: AiqiyiStartApp
 * @Description:
 * @Author: ZhaoJinYuan
 * @Date: 2019/12/18 16:07
 */

@RestController
public class AiqiyiReferStartApp {

    private static Map<String,String> aiqiyi=new HashMap<>();
    static{
        aiqiyi.put("www.baidu.com","百度");
        aiqiyi.put("cn.bing.com","必应");
        aiqiyi.put("search.yahoo.com","雅虎");
        aiqiyi.put("www.sogou.com","搜狗");
    }
    @Autowired
    AiqiyiReferCountDao aiqiyiReferCountDao;
    @RequestMapping(value = "/referCount",method = RequestMethod.POST)
    @ResponseBody
    public List<ReferCount> listCount() throws Exception {
        List<ReferCount> list=aiqiyiReferCountDao.query("20191218");
        for (ReferCount ac:list) {
            ac.setName(aiqiyi.get(ac.getName().substring(11)));
        }
            System.out.println("----------------------");
        return list;
    }
    @RequestMapping(value = "/refer",method = RequestMethod.GET)
    public ModelAndView echarts(){
        return new ModelAndView("echart1");
    }
}
