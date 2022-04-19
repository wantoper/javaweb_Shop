package com.wantoper.Util;

import org.junit.Test;

import java.util.UUID;

public class UidUtil {

    public static String getid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(UidUtil.getid());
    }
}
