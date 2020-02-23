package com.revature.roommaintenanceprototype.animation;

import android.animation.ObjectAnimator;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomViewAnimator {

    public static void animateFloatingActionButtonOut(FloatingActionButton floatingActionButton){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton,"translationY",250f);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }

    public static void animateFloatingActionButtonIn(FloatingActionButton floatingActionButton){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton,"translationY",-250f);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }
}
