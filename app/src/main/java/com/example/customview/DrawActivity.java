package com.example.customview;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class DrawActivity extends AppCompatActivity {

    FrameLayout stage;
    RadioGroup radioGroup;
    DrawView2 drawView;
    Button btnDlt;
    SeekBar seekBar;
    int colorcolor = Color.BLACK;
    int seek = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        stage = (FrameLayout) findViewById(R.id.stage);

        drawView = new DrawView2(DrawActivity.this);
        stage.addView(drawView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        btnDlt = (Button) findViewById(R.id.btnDlt);
        btnDlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawView.delete();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                drawView.setWidth(i);
                seek = i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radioColor);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                switch(id){
                    case R.id.radioBlack:
//                        drawView = new DrawView(DrawActivity.this);
//                        stage.addView(drawView);
                        drawView.setColor(Color.BLACK);
                        colorcolor = Color.BLACK;

                        break;

                    case R.id.radioCyan:
//                        drawView = new DrawView(DrawActivity.this);
//                        stage.addView(drawView);
                        drawView.setColor(Color.CYAN);
                        colorcolor = Color.CYAN;
                        break;

                    case R.id.radioMagneta:
//                        drawView = new DrawView(DrawActivity.this);
//                        stage.addView(drawView);
                        drawView.setColor(Color.MAGENTA);
                        colorcolor = Color.MAGENTA;
                        break;

                    case R.id.radioYellow:
//                        drawView = new DrawView(DrawActivity.this);
//                        stage.addView(drawView);
                        drawView.setColor(Color.YELLOW);
                        colorcolor = Color.YELLOW;
                        break;
                }
            }
        });
    }

    public int getColor(){
        return colorcolor;
    }
    public int getSeek(){
        return seek;
    }
}
