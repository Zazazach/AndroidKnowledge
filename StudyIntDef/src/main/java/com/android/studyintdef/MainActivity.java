package com.android.studyintdef;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;

    @Numbers
    int num = THREE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (ColorEnum color : ColorEnum.values()) {
                    switch (color) {
                        case RED:
                            Log.e("MainActivity", color.getName() + color.getValue());
                            break;
                        case GREEN:
                            Log.e("MainActivity", color.getName() + color.getValue());
                            break;
                        case WHITE:
                            Log.e("MainActivity", color.getName() + color.getValue());
                            break;
                        case YELLOW:
                            Log.e("MainActivity", color.getName() + color.getValue());
                            break;
                    }
                }
            }
        });


        setNum(TWO);
        int n = getNum();
    }

    @IntDef({ONE, TWO, THREE, FOUR})
    public @interface Numbers {
    }

    @Numbers
    public int getNum() {
        return num;
    }

    public void setNum(@Numbers int num) {
        this.num = num;
    }
}