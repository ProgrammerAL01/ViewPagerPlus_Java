package com.example.viewpagerplus_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        viewPager = findViewById(R.id.viewPager_2);
        List<ViewPagerModel> models = new ArrayList<>();
        models.add(new ViewPagerModel("Hi i'm Amirhossein Alizad"));
        models.add(new ViewPagerModel("I'm Android Developer"));
        models.add(new ViewPagerModel("and i work C#"));
        models.add(new ViewPagerModel("Nice to meet you and thank you for watching my project"));
        ViewPagerAdapter adapter = new ViewPagerAdapter(models);
        viewPager.setAdapter(adapter);
        MaterialButton next = findViewById(R.id.btn_Next);
        MaterialButton back = findViewById(R.id.btn_Back);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getNextPossibleIndexItem(+1), true);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getNextPossibleIndexItem(-1), true);
            }
        });
        viewPager.setUserInputEnabled(false);
    }

    private int getNextPossibleIndexItem(int change) {
        int currentIndex = viewPager.getCurrentItem();
        int total = viewPager.getAdapter().getItemCount();
        if (currentIndex + change < 0) {
            return 0;
        }
        return Math.abs((currentIndex + change) % total);
    }
}