package com.zjy.small.domain;

import org.springframework.stereotype.Component;

/**
 * @PackageName: com.zjy.small.domain
 * @ClassName: AiqiyiCount
 * @Description:
 * @Author: ZhaoJinYuan
 * @Date: 2019/12/18 10:51
 */
@Component
public class AiqiyiCount {

    private String  name;
    private long value;

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
