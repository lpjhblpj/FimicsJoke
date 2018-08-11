package com.mic.libcore.utils;

import java.lang.reflect.Array;

@SuppressWarnings("unused")
public class ArrayUtils {

    /**
     * 合并两个数组
     * @param arrayLhs  左边数据
     * @param arrayRls  右边数据
     * @return
     */
    public static Object combineArray(Object arrayLhs,Object arrayRls){
        Class<?> localClass =arrayLhs.getClass().getComponentType();
        int i = Array.getLength(arrayLhs);
        int j = Array.getLength(arrayRls);

        Object result = Array.newInstance(localClass,j);

        for (int k=0;k<j;k++){

            if(k<i){
                Array.set(result,k,Array.get(arrayLhs,k));
            }else {
                Array.set(result,k,Array.get(arrayRls,k-i));
            }
        }

        return  result;
    }
}
