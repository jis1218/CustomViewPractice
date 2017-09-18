package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 정인섭 on 2017-09-18.
 */

public class CustomView extends View {

    //내가 소스코드에서 생성할 때 시스템에서 호출해주는 생성자
    public CustomView(Context context){
        super(context);
    }

    //xml에서 태그로 사용할 때 시스템에서 호출해주는 생성자
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs); //뷰는 xml을 꼭 쓰기 때문에 attrs가 있는게 좋음, 3번째 4번째 파라미터는 테마와 관련된 것
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //그림그리기(사각형 그리기)

        Paint paint = new Paint(); //물감 - 겉모양을 결정하는 도구
        paint.setColor(Color.RED);

        //drawRect가 붓이고, 그려지는 곳이 canvas, paint는 말 그대로 paint
        canvas.drawRect(100, 100, 200, 200, paint); //x는 100, y는 100이 왼쪽 위 꼭지점, 200, 200이 오른쪽 아래 꼭지점

    }


}
