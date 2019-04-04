package com.zr.gansu.common.utils;

import java.text.SimpleDateFormat;

/**
 * @Author: yufei
 * @Description:获取20位随机数生成数据库主键ID
 * 	4位年份+13位时间戳+3位随机数
 * @Date: Create in 11:22 2018/12/24
 */
public class IDUtils {
    /**
     * 20位末尾的数字id
     */
    public static int Guid=100;

    public static String getGuid() {

        IDUtils.Guid+=1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran=0;
        if(IDUtils.Guid>999){
            IDUtils.Guid=100;
        }
        ran=IDUtils.Guid;

        return time+info.substring(2, info.length())+ran;
    }



   /* public static void main(String[] args) {
        //调用生成id方法
        for(int i=0;i<10;i++){
            System.out.println(getGuid());
        }

    }*/

}
