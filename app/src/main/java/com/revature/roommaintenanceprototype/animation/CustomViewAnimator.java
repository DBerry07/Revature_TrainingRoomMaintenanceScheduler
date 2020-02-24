package com.revature.roommaintenanceprototype.animation;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;

public class CustomViewAnimator {
    private static int animationSpeed = 500;

    public static void animateFloatingActionButtonOut(FloatingActionButton floatingActionButton){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton,"translationY",250f);
        objectAnimator.setDuration(animationSpeed);
        objectAnimator.start();
    }

    public static void animateFloatingActionButtonIn(FloatingActionButton floatingActionButton){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton,"translationY",-250f);
        objectAnimator.setDuration(animationSpeed);
        objectAnimator.start();
    }

    public static void hideBottomNavComponents(View parentView){
        BottomNavigationView bottomNavigationView = parentView.findViewById(R.id.bottom_navigation);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(bottomNavigationView,"translationy",300);
        objectAnimator.setDuration(animationSpeed);
        objectAnimator.start();
        bottomNavigationView.setVisibility(View.GONE);

        ImageView imgHoverBtn = parentView.findViewById(R.id.img_hover_btn);
        imgHoverBtn.setVisibility(View.GONE);
    }

    public static void showBottomNavComponents(View parentView){
        BottomNavigationView bottomNavigationView = parentView.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setX(0);
        bottomNavigationView.setVisibility(View.VISIBLE);

        ImageView imgHoverBtn = parentView.findViewById(R.id.img_hover_btn);
        imgHoverBtn.setVisibility(View.VISIBLE);
    }
}
