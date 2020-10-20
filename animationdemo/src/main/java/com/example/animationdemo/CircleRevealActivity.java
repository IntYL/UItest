package com.example.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class CircleRevealActivity extends Activity {
    private ImageView myView;
   private boolean reveal  = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_layout);
        myView = findViewById(R.id.my_image);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reveal){
                    reveal = false;
                    translateX();
                   // unreveal();
                }else {
                    reveal = true;
                    //reveal();
                    translateY();
                }
            }
        });
    }

    private void reveal(){
        // previously invisible view

        // Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            // get the final radius for the clipping circle
            float finalRadius = (float) Math.hypot(cx, cy);

            // create the animator for this view (the start radius is zero)
            Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius).setDuration(5000);

            // make the view visible and start the animation
            myView.setVisibility(View.VISIBLE);
            anim.start();
        } else {
            // set the view to invisible without a circular reveal animation below Lollipop
            myView.setVisibility(View.INVISIBLE);
        }
    }

    private void unreveal(){
        // previously visible view


        // Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            // get the initial radius for the clipping circle
            float initialRadius = (float) Math.hypot(cx, cy);

            // create the animation (the final radius is zero)
            Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0f).setDuration(5000);

            // make the view invisible when the animation is done
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.VISIBLE);
                }
            });

            // start the animation
            anim.start();
        } else {
            // set the view to visible without a circular reveal animation below Lollipop
            myView.setVisibility(View.VISIBLE);
        }
    }

    private void translateX(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(myView,"translationX",100f);
        animator.setDuration(5000);
        animator.start();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(myView,"translationY",100f);
        animator1.setDuration(5000);
        animator1.start();
    }

    private void translateY(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(myView,"translationX",500f);
        animator.setDuration(5000);
        animator.start();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(myView,"translationY",500f);
        animator1.setDuration(5000);
        animator1.start();
    }
}
