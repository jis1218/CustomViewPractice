package com.example.customview;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout stage;
    Button button;
    /*
    커스텀뷰 만들기
    1. 커스텀 속성을 attrs.xml 파일에 정의

    2. 커스텀할 객체(위젯)을 상속받은 후 재정의

    3. 커스텀할 위젯을 레이아웃.xml에서 태그로 사용
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stage = (ConstraintLayout) findViewById(R.id.stage);
        button = (Button) findViewById(R.id.btnDraw);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawActivity.class);
                startActivity(intent);
            }
        });

        CustomView cv = new CustomView(this);
        stage.addView(cv);

    }
}
