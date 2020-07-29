package test.singleton;

import java.security.Signature;

public class SingleTon {

    /*懒汉单例*/
    private static SingleTon mInstance = new SingleTon();

    private SingleTon(){}
    public static SingleTon  getmInstance() {
        return mInstance;
    }

    /*DCL单例*/
    public static SingleTon getInstance(){
        if (mInstance ==null){}
        synchronized (SingleTon.class){
            if (mInstance == null){
                mInstance = new SingleTon();
            }
        }
        return mInstance;
    }

    /*静态内部类*/

    private static class SingleTonHolder{
        private static final SingleTon lInstance = new SingleTon();
    }

    public static SingleTon getLL(){
        return SingleTonHolder.lInstance;
    }

}
