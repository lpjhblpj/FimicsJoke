package com.mic.libbusiness.utils;


@SuppressWarnings("all")
public class PatchUtils {

    /**
     * patch合并
     * @param oldApkPath 原来的apk , 1.0 本地安装的apk
     * @param newApkPath 合并后新的apk 需要生成2.0
     * @param patchPatch 差分包，从服务器下载下来
     */
    public static native void combine(String oldApkPath,String newApkPath,String patchPatch);

}
