package com.example.uitest;

import android.view.View;
import android.widget.Toast;

/**
 * Created By leiyao6 on
 */
public class GuideBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onClick(View view,String string){
        Toast.makeText(view.getContext().getApplicationContext(),string,Toast.LENGTH_LONG).show();
    }
}
