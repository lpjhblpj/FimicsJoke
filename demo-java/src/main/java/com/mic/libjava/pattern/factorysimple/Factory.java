package com.mic.libjava.pattern.factorysimple;

public class Factory<T> {


    public enum COLOR{
        YELLOW,RED,BLUE
    }


    public static IColorApi create(COLOR color){
        switch (color){
            case YELLOW:
                return new YellowImpl();
            case RED:
                return new RedImpl();
            case BLUE:
                return new BlueImpl();
        }
        return new YellowImpl();
    }

    /**
     * 简单工厂
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends IColorApi> T create(Class<T> clz){

        IColorApi colorApi =null;

        try {
            colorApi=(IColorApi) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException|ClassNotFoundException |IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T)colorApi;
    }
}
