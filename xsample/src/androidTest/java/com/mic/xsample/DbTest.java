package com.mic.xsample;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.mic.libbusiness.db.DaoSupport;
import com.mic.libbusiness.db.DaoSupportFactory;
import com.mic.xsample.model.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


@RunWith(AndroidJUnit4.class)
public class DbTest {


    DaoSupport<Person> personDao;

    @Before
    public void setUp() throws Exception {
        personDao = DaoSupportFactory.getInstance().getDao(Person.class);
    }

    @Test
    public void save(){

        Person person =new Person("lipengju",22);
        personDao.insert(person);

    }

    @Test
    public void batchInsert(){
        List<Person> list = new ArrayList<>();
        for (int i =0;i<100;i++){
            Person p = new Person("dbtest_"+i,i);
            list.add(p);
        }
        personDao.insert(list);

    }

    @Test
    public void query(){
        List<Person> list = personDao.querySupport().selection("age = ?").selectionArgs("23").query();
        for (Person p:list){
            p.toString();
        }
    }
}


