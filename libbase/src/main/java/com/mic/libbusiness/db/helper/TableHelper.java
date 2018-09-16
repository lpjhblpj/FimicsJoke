package com.mic.libbusiness.db.helper;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mic.libbusiness.db.DaoUtil;

import java.lang.reflect.Field;

@SuppressWarnings("unusec")
public class TableHelper {

    private static String TAG = "TableHelper";

    public static void createTable(SQLiteDatabase database,Class clazz){
        // 创建表
        /*"create table if not exists Person ("
                + "id integer primary key autoincrement, "
                + "name text, "
                + "age integer, "
                + "flag boolean)";*/

        StringBuffer sb = new StringBuffer();

        sb.append("create table if not exists ")
                .append(DaoUtil.getTableName(clazz))
                .append("(id integer primary key autoincrement, ");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);// 设置权限
            String name = field.getName();
            String type = field.getType().getSimpleName();// int String boolean
            //  type需要进行转换 int --> integer, String text;
            sb.append(name).append(DaoUtil.getColumnType(type)).append(", ");
        }

        sb.replace(sb.length() - 2, sb.length(), ")");

        String createTableSql = sb.toString();

        Log.e(TAG, "表语句--> " + createTableSql);

        // 创建表
        database.execSQL(createTableSql);
    }
}
