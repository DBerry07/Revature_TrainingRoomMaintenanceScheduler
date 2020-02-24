package com.revature.roommaintenanceprototype.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revature.roommaintenanceprototype.R;

public class CustomViewAnimator {
    private static final String DEBUG_TAG = "CustomViewAnimator";
    private static int animationSpeed = 500;

    public static void animateFloatingActionButtonOut(FloatingActionButton floatingActionButton){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton,"translationY",300f);
        objectAnimator.setDuration(animationSpeed);
        objectAnimator.start();
    }

    public static void animateFloatingActionButtonIn(FloatingActionButton floatingActionButton){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(floatingActionButton,"translationY",-300f);
        objectAnimator.setDuration(animationSpeed);
        objectAnimator.start();
    }

    public static void hideBottomNavComponents(View parentView){
        Log.d(DEBUG_TAG,"Hiding bottom nav");
        BottomNavigationView bottomNavigationView = parentView.findViewById(R.id.bottom_navigation);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(bottomNavigationView,"translationY",300);
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

    public static void animateSplashToLogin(View parentView){
        final ConstraintLayout splashContainer = parentView.findViewById(R.id.splashContainer);
        final ConstraintLayout loginContainer = parentView.findViewById(R.id.loginContainer);


        splashContainer.animate().setDuration(1500).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                splashContainer.animate().translationX(10000).setDuration(2000).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        splashContainer.setVisibility(View.GONE);
                    }
                }).start();
                loginContainer.animate().alpha(1f).setDuration(700).start();
            }
        }).start();
    }

    public static void hideInvalidMessage(final TextView tvMessage){
        Log.d(DEBUG_TAG,"Now Hiding Message");
        tvMessage.animate().alpha(0).setDuration(500).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                tvMessage.setVisibility(View.GONE);
            }
        }).start();
    }

    public static void showInvalidMessage(final TextView tvMessage, String message){
        Log.d(DEBUG_TAG,"Now Showing Message");
        tvMessage.setText("  "+message+"  ");
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setAlpha(1);
    }
}
