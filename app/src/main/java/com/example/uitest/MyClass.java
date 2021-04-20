package com.example.uitest;

import androidx.annotation.Nullable;

public class MyClass extends ParentClass {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        //写你自己计算hashCode的逻辑然后return
        //一般hashcode都是

        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        //写你自己计算equals的逻辑然后return
        return super.equals(obj);
    }
}
