package com.mic.libbusiness.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;
import android.util.Log;

import com.mic.libbusiness.db.curd.QuerySupport;
import com.mic.libbusiness.db.helper.CursorHelper;
import com.mic.libbusiness.db.helper.TableHelper;
import com.mic.libbusiness.db.helper.ValuesHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
@SuppressWarnings("unused")
public class DaoSupportImpl<T>  implements DaoSupport<T>{

    private String TAG = "DaoSupport";

    // SQLiteDatabase
    private SQLiteDatabase mSqLiteDatabase;
    // 泛型类
    private Class<T> mClazz;

    private QuerySupport<T> querySupport;




    public void init(SQLiteDatabase database,Class<T> clazz){
        this.mSqLiteDatabase = database;
        this.mClazz=clazz;
        TableHelper.createTable(mSqLiteDatabase,mClazz);
    }




    // 插入数据库 t 是任意对象
    @Override
    public long insert(T obj) {
        /*ContentValues values = new ContentValues();
        values.put("name",person.getName());
        values.put("age",person.getAge());
        values.put("flag",person.getFlag());
        db.insert("Person",null,values);*/

        // 使用的其实还是  原生的使用方式，只是我们是封装一下而已
        ContentValues values = ValuesHelper.contentValuesByObj(obj,mClazz);

        // null  速度比第三方的快一倍左右
        return mSqLiteDatabase.insert(DaoUtil.getTableName(mClazz), null, values);
    }

    @Override
    public void insert(List<T> datas) {
        // 批量插入采用 事物
        mSqLiteDatabase.beginTransaction();
        for (T data : datas) {
            // 调用单条插入
            insert(data);
        }
        mSqLiteDatabase.setTransactionSuccessful();
        mSqLiteDatabase.endTransaction();
    }

    // 查询目前直接查询所有,希望单独写一个类做到按条件查询:age = 22  name = darren
    @Override
    public List<T> queryAll() {
        Cursor cursor = mSqLiteDatabase.query(DaoUtil.getTableName(mClazz),
                null, null, null, null, null, null);
        return CursorHelper.cursorToList(cursor,mClazz);
    }

    /**
     * 删除
     */
    @Override
    public int delete(String whereClause, String[] whereArgs) {
        return mSqLiteDatabase.delete(DaoUtil.getTableName(mClazz), whereClause, whereArgs);
    }

    /**
     * 更新  这些你需要对  最原始的写法比较明了 extends
     */

    @Override
    public int update(T obj, String whereClause, String... whereArgs) {
        ContentValues values = ValuesHelper.contentValuesByObj(obj,mClazz);
        return mSqLiteDatabase.update(DaoUtil.getTableName(mClazz),
                values, whereClause, whereArgs);
    }

    @Override
    public QuerySupport<T> querySupport() {

        if(querySupport==null){
            querySupport=new QuerySupport<>(mSqLiteDatabase,mClazz);
        }
        return querySupport;
    }


}
