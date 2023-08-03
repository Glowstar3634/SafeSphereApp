package com.example.safesphereapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    // creating object of ViewPager
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.ssintro1, R.drawable.ssintro2, R.drawable.ssintro3, R.drawable.ssintro4, R.drawable.ssintro5};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideshow_activity);

        // Initializing the ViewPager Object
        mViewPager = (ViewPager) findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(SignUpActivity.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                Button signUpButton = findViewById(R.id.appCompatButton);
                ProgressBar progressBar = findViewById(R.id.progressBar);
                if (position == 0){
                    progressBar.setProgress(20);
                }
                if (position == 1){
                    progressBar.setProgress(40);

                }
                if (position == 2){
                    progressBar.setProgress(60);

                }
                if (position == 3){
                    progressBar.setProgress(80);

                }
                if (position == 4) {
                    progressBar.setProgress(100);
                    signUpButton.setAlpha(0);
                    signUpButton.setVisibility(View.VISIBLE);
                    signUpButton.animate()
                            .alpha(1F)
                            .translationYBy(-25)
                            .setDuration(400)
                            .setListener(new Animator.AnimatorListener(){

                                @Override
                                public void onAnimationStart(@NonNull Animator animation) {

                                }

                                public void onAnimationEnd(@NonNull Animator animation) {
                                    signUpButton.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onAnimationCancel(@NonNull Animator animation) {

                                }

                                @Override
                                public void onAnimationRepeat(@NonNull Animator animation) {

                                }
                            });

                } else {
                    signUpButton.animate()
                            .alpha(0)
                            .translationYBy(25)
                            .setDuration(400)
                            .setListener(new Animator.AnimatorListener() {

                                @Override
                                public void onAnimationStart(@NonNull Animator animation) {

                                }

                                public void onAnimationEnd(@NonNull Animator animation) {
                                    signUpButton.setVisibility(View.GONE);
                                }

                                @Override
                                public void onAnimationCancel(@NonNull Animator animation) {

                                }

                                @Override
                                public void onAnimationRepeat(@NonNull Animator animation) {

                                }
                            });
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void signUp(View view){
        Intent switchActivity = new Intent(SignUpActivity.this, AccountCreation.class);
        SignUpActivity.this.startActivity(switchActivity);
    }
}