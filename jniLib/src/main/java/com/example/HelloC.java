package com.example;

public class HelloC {
    static {
        System.loadLibrary("testndk");
    }
    public static native String helloFromC();
}
/**
 * Created By leiyao6 on
 */