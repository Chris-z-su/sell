package com.shubao.sell.utils;

import java.util.Random;

/**
 * @author Mr.Chris
 * @title: KeyUtil
 * @projectName sell
 * @description: TODO
 * @date 2019/07/11 0011 16:20
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数
     * @return
     */
    public static synchronized String genUniquekey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
