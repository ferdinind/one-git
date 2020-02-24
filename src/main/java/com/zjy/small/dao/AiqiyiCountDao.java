package com.zjy.small.dao;

import com.zjy.small.domain.AiqiyiCount;
import com.zjy.small.utils.AiqiyiHbaseUtils;
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
public class AiqiyiCountDao {

    public List<AiqiyiCount> query (String day) throws Exception {
        List<AiqiyiCount> list=new ArrayList<>();
        Map<String,Long> map= AiqiyiHbaseUtils.getInstance().query("categary_search_count",day);
        for (Map.Entry<String,Long> entry:map.entrySet()){
            AiqiyiCount ac=new AiqiyiCount();
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
    public static void main(String[] args) throws Exception {
        AiqiyiCountDao dao=new AiqiyiCountDao();
        List<AiqiyiCount> list=dao.query("20191220");
        for (AiqiyiCount ac:list) {
            System.out.println(ac.getName()+","+ac.getValue());
        }
    }
}
