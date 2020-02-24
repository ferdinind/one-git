package com.zjy.small;

import com.zjy.small.dao.AiqiyiProvenceCountDao;
import com.zjy.small.dao.AiqiyiReferCountDao;
import com.zjy.small.domain.ProvenceCount;
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
public class AiqiyiProvenceStartApp {

    @Autowired
    AiqiyiProvenceCountDao aiqiyiProvenceCountDao;
    @RequestMapping(value = "/province",method = RequestMethod.POST)
    @ResponseBody
    public List<ProvenceCount> listCount() throws Exception {
        List<ProvenceCount> list=aiqiyiProvenceCountDao.query("20191220");
        for (ProvenceCount ac:list) {
            ac.setName(ac.getName().substring(9));
        }
        return list;
    }
    @RequestMapping(value = "/provence",method = RequestMethod.GET)
    public ModelAndView echarts(){
        return new ModelAndView("echart2");
    }
}
