package com.zjy.small.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.zjy.small.utils
 * @ClassName: AiqiyiHbaseUtils
 * @Description:
 * @Author: ZhaoJinYuan
 * @Date: 2019/12/18 10:54
 */
public class AiqiyiHbaseUtils {

    HBaseAdmin admin=null;
    Configuration conf=null;

    /**
     * 加载配置
     */
    private AiqiyiHbaseUtils(){
        conf=new Configuration();
        conf.set("hbase.zookeeper.quorum","centos99:2181");
        conf.set("hbase.rootdir","hdfs://centos99:9000/hbase");
        try{
        admin=new HBaseAdmin(conf);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static AiqiyiHbaseUtils instance=null;

    public static synchronized AiqiyiHbaseUtils getInstance() {
        if(null==instance){
            instance=new AiqiyiHbaseUtils();
        }
        return instance;
    }

    /**
     * 获取Htable示例
     */
    public HTable getTable(String tableName){
        HTable table=null;
        try{
            table=new HTable(conf,tableName);
        }catch(Exception e){
            e.printStackTrace();
        }
        return table;
    }
    public Map<String,Long> query(String tableName,String cond) throws Exception{
        Map<String,Long> map=new HashMap<>();
        HTable table=getTable(tableName);
        String cf="info";
        String qualifier="click_count";
        Scan scan=new Scan();
        Filter filter=new PrefixFilter(Bytes.toBytes(cond));
        scan.setFilter(filter);
        ResultScanner rs = table.getScanner(scan);
        for (Result result:rs) {
            // 20191216_44,1
            String row=Bytes.toString(result.getRow());
            long AiqiyiCount=Bytes.toLong(result.getValue(cf.getBytes(),qualifier.getBytes()));
            map.put(row,AiqiyiCount);
        }
        return map;
    }
}
