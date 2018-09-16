package com.mic.libbusiness.db;

import android.database.sqlite.SQLiteDatabase;

import com.mic.libcore.utils.FileUtils;

import java.io.File;

@SuppressWarnings("unused")
public class DaoSupportFactory {

    private static final String DB_NAME ="fimics.db";
    private static final String DB_DIR = "fimics";
    private SQLiteDatabase database;


    private DaoSupportFactory(){

        File dbRoot = new File(FileUtils.getSDPath()+File.separator+DB_DIR+File.separator);

        if(!dbRoot.exists()){
            dbRoot.mkdirs();
        }

        File databaseFile = new File(dbRoot,DB_NAME);
        database =SQLiteDatabase.openOrCreateDatabase(databaseFile,null);
    }

    private static class Holder{
        private static  DaoSupportFactory instance = new DaoSupportFactory();
    }


    public static DaoSupportFactory getInstance(){
        return  Holder.instance;
    }

    /**
     * 1.所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前
     * 2.
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> DaoSupport<T> getDao(Class<T> clazz){

        DaoSupport<T> daoSupport = new DaoSupportImpl();
        daoSupport.init(database,clazz);
        return daoSupport;
    }
}
