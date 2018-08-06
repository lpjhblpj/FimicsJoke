package com.mic.libcore.utils;

public class DeviceInfoTools {

    /**
     * 获取手机核心数据
     * @return 返回手机核数
     */
    public static int getNumAvailableCores() {
        return  Runtime.getRuntime().availableProcessors();
    }

}
