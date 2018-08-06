package com.mic.ioc;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@SuppressWarnings("unused")
public class ViewUtils {

    public static void inject(Activity activity) {
        inject(new ViewFinderHelper(activity), activity);
    }

    public static void inject(View view) {
        inject(new ViewFinderHelper(view), view);
    }

    public static void inject(View view, Object obj) {
        inject(new ViewFinderHelper(view), obj);
    }

    /**
     * 兼容上面三种方式法
     *
     * @param helper
     * @param object 反射需要执行的类
     */
    private static void inject(ViewFinderHelper helper, Object object) {
        injectFiled(helper, object);
        injectEvent(helper, object);
    }

    /**
     * 注入属性
     * @param helper  注解辅助类
     * @param object  反射对象
     */
    private static void injectEvent(ViewFinderHelper helper, Object object) {

        Class<?> clazz = object.getClass();
        Method methods []=clazz.getDeclaredMethods();

        if(methods!= null && methods.length!=0){

            for (Method method:methods){
                OnClick onClick =method.getAnnotation(OnClick.class);
                if(onClick!=null){
                    method.setAccessible(true);
                    int viewIds []=onClick.value();

                    if(viewIds!= null && viewIds.length!=0){

                        for(int viewId:viewIds){
                            View view = helper.findViewById(viewId);
                            if(view!=null){
                                view.setOnClickListener(new DeclaredOnClickListener(object,method));
                            }
                        }
                    }

                }




            }
        }

    }


    private static class DeclaredOnClickListener implements  View.OnClickListener{

        private Object object;
        private Method method;

        public DeclaredOnClickListener(Object object, Method method) {
            this.object = object;
            this.method = method;
        }

        @Override

        public void onClick(View v) {

            try {
                method.invoke(object,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 注入事件
     *
     * @param helper  注解辅助类
     * @param object  反射对象
     */
    private static void injectFiled(ViewFinderHelper helper, Object object) {

        /**
         * 1.获取类的所有属性
         *2.获取ViewFinder的value值
         *3.findViewBy找到View
         *4.动态注入找到View
         */

        Class<?> clazz = object.getClass();
        Field fields [] =clazz.getDeclaredFields();


        for (Field field:fields){
            ViewById viewById =field.getAnnotation(ViewById.class);

            if(viewById != null){
                field.setAccessible(true);
                int viewId = viewById.value();
                View view =helper.findViewById(viewId);

                if(view !=null){

                    try {
                        //动态的注入找到的View
                        field.set(object,view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }


}
