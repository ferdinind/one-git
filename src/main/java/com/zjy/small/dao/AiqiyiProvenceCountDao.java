package com.zjy.small.dao;

import com.zjy.small.domain.ProvenceCount;
import com.zjy.small.domain.ReferCount;
import com.zjy.small.utils.AiqiyiHbaseUtils;
import com.zjy.small.utils.ProvenceHbaseUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.zjy.small.dao
 * @ClassName: AiqiyiCountDao
 * @Description:
 * @Author: ZhaoJinYuan
 * @Date: 2019/12/18 11:18
 */

@Component
public class AiqiyiProvenceCountDao {

    public List<ProvenceCount> query (String day) throws Exception {
        List<ProvenceCount> list=new ArrayList<>();
        Map<String,Long> map= ProvenceHbaseUtils.getInstance().query("provinceCount","20191220");
        for (Map.Entry<String,Long> entry:map.entrySet()){
            ProvenceCount ac=new ProvenceCount();
            ac.setName(entry.getKey());
            ac.setValue(entry.getValue());
            list.add(ac);
        }
        return list;
    }

    /**
     * 测试
     * @param args
     * @throws Exception
     */
//    public static void main(String[] args) throws Exception {
//        AiqiyiProvenceCountDao dao=new AiqiyiProvenceCountDao();
//        List<ProvenceCount> list=dao.query("20191220");
//        for (ProvenceCount ac:list) {
//            System.out.println(ac.getName().substring(9)+","+ac.getValue());
//        }
//    }
}
