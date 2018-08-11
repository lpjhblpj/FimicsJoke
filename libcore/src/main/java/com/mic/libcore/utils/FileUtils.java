package com.mic.libcore.utils;


import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@SuppressWarnings("unused")
public class FileUtils {

    /**
     * 文件拷贝
     * @param src 源文件
     * @param dest  目标文件
     * @throws IOException
     */
    public static void copyFile(File src,File dest) throws IOException{

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            if(!dest.exists()){
                dest.createNewFile();
            }

            inChannel = new FileInputStream(src).getChannel();
            outChannel = new FileOutputStream(dest).getChannel();
            inChannel.transferTo(0,inChannel.size(),outChannel);
        }finally {
            if(inChannel!=null){
                inChannel.close();
            }

            if(outChannel!=null){
                outChannel.close();
            }
        }
    }

    /**
     * 获取 sdk 路径
     * @return
     */
    public static String getSDPath(){
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if(sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();
        }
        return sdDir.toString();
    }
}
