package com.zjy.small;

import com.zjy.small.dao.AiqiyiCountDao;
import com.zjy.small.domain.AiqiyiCount;
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
public class AiqiyiStartApp {

    private static Map<String,String> aiqiyi=new HashMap<>();
    static{
        aiqiyi.put("1","OLG");
        aiqiyi.put("2","电影");
        aiqiyi.put("3","体育");
        aiqiyi.put("4","动漫");
        aiqiyi.put("6","综艺");
    }
    @Autowired
    AiqiyiCountDao aiqiyiCountDao;
    @RequestMapping(value = "/aiqiyiCount",method = RequestMethod.POST)
    @ResponseBody
    public List<AiqiyiCount> listCount() throws Exception {
        List<AiqiyiCount> list=aiqiyiCountDao.query("20191220");
        for (AiqiyiCount ac:list) {
            ac.setName(aiqiyi.get(ac.getName().substring(9)));
            //System.out.println(ac.getName()+":"+ac.getValue());
        }
            //System.out.println("----------------------");
        return list;
    }
    @RequestMapping(value = "/echart",method = RequestMethod.GET)
    public ModelAndView echarts(){
        return new ModelAndView("echart");
    }
}
