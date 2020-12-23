package com.example.uitest;

import android.os.Parcel;
import android.os.Parcelable;

public class TestBean implements Parcelable {
    private int name;
    private int age;


    public TestBean(int name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(age);
    }

    public static final Parcelable.Creator<TestBean> CREATOR = new Parcelable.Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel source) {
            return new TestBean(source);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };

    private TestBean(Parcel in) {
        name = in.readInt();
        age = in.readInt();
    }
}
