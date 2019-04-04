package com.zr.gansu.web.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yufei
 * @Description:
 * @Date: Create in 17:33 2018/12/21
 */
public class test {

    public static void main(String[] args){
        String str = "12345";
        //int[] temp_int=null;
        List list = new ArrayList<>();
        for(int i = 0;i<str.length();i++) {
            list.add(str.charAt(i));
            //把字符转换成数字方法一
            //temp_int[i] = temp_char - '0';
            //把字符转换成数字方法二
            //int temp_int = Integer.parseInt(String.valueOf(temp_char));
        }
       /* for(int num:temp_int){
            list.add(num);
        }*/
       for(int j=0;j<list.size();j++){
           System.out.println(list.get(j));
       }
    }
}
