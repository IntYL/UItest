package com.example.uitest;

public class WinDowBean{
 private int dpi=0;
 private String resolution="1920x1200";
 private float sw=600;
 private String testStr;
 private int intTest;

    public WinDowBean(int dpi, String resolution, int sw) {
        this.dpi = dpi;
        this.resolution = resolution;
        this.sw = sw;
    }

    public WinDowBean() {

    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public int getIntTest() {
        return intTest;
    }

    public void setIntTest(int intTest) {
        this.intTest = intTest;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public float getSw() {
        return sw;
    }

    public void setSw(float sw) {
        this.sw = sw;
    }
}
/**
 * Created By leiyao6 on
 */