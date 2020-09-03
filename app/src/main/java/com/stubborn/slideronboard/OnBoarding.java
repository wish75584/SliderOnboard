package com.stubborn.slideronboard;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    SliderAdapterClass sliderAdapterClass;
    LinearLayout dotsLayout;

    //textview for dots
    TextView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);//linear layout


        //calling slider adapter clss

        sliderAdapterClass = new SliderAdapterClass(this);
        viewPager.setAdapter(sliderAdapterClass);

        //calling add dots function

        addDots(0);//passing position to get colored dots after selection

        viewPager.addOnPageChangeListener(changeListener);//passing on page change listener on view pager

    }


    private void addDots(int position) {
        dots = new TextView[4];//4 dots for four pages
        dotsLayout.removeAllViews();//removimg all views

        //using for loop to get all four dots
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            //getting dots using html
            dots[i].setText(Html.fromHtml("&#8226"));

            //setting text size
            dots[i].setTextSize(35);

            //adding dots to linear layout
            dotsLayout.addView(dots[i]);
        }

        //if section for coloring or changing dots as per page changes 
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);//dots will get changed when pages will be changed
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
