package src.Old;

/**
 * Created by luoxianzhuo on 2019/8/26 15:31
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class Singleton {

    private volatile static Singleton singleton = null;    //注意此处加上了volatile关键字

    private Singleton(){//这边不能省略
    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized(Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                    //return singleton;    //有人提议在此处进行一次返回
                }
                //return singleton;    //也有人提议在此处进行一次返回
            }
        }
        return singleton;
    }

}