package com.mic.libbusiness.db;

import android.database.sqlite.SQLiteDatabase;

import com.mic.libbusiness.db.curd.QuerySupport;

import java.util.List;

@SuppressWarnings("unused")
public interface DaoSupport<T> {

    public void init(SQLiteDatabase database, Class<T> clazz);

    public long insert(T t);

    // 批量插入  检测性能
    public void insert(List<T> datas);

    public List<T> queryAll();

    public int delete(String whereClause, String[] whereArgs);

    public int update(T obj, String whereClause, String... whereArgs);

    // 获取专门查询的支持类
    QuerySupport<T> querySupport();
}
