package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 정인섭 on 2017-09-18.
 */

public class DrawView extends View {
    //그림이 그려지는 좌표
    float x = -1;
    float y = -1;
    final float RADIUS = 10;

    //Path currentPath = new Path();

    Paint paint;

    ArrayList<PathTool> pathList = new ArrayList<>();
    PathTool pathTool = new PathTool();

    //좌표값을 저장하는 저장소를 만들어야 함
    ArrayList<Float> tempX = new ArrayList<>();
    ArrayList<Float> tempY = new ArrayList<>();

    //소스코드에서 사용하기 때문에 생성자 파라미터는 context만 필요
    public DrawView(Context context) {
        super(context);

        //currentPath = new Path();
        paint = new Paint();
        //paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);

        pathList.add(pathTool);

    }//생성자에 함수를 되도록이면 안 넣는 것이 좋다. 외부 함수를 참조할 경우 생성자가 다 만들어져야 객체가 하나 생기기 때문이다.
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //터치가 일어나면 Path를 해당 좌표까지 선을 긋는다.
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //최초 터치시 해당 좌표로 이동
                //currentPath = new Path();

                pathList.get(pathList.size()-1).moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:

                pathList.get(pathList.size()-1).lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                //pathList.add(new Path());
                break;
        }
        //currentPath.lineTo(event.getX(), event.getY());

//        x = event.getX();
//        y = event.getY();
//
//        tempX.add(x);
//        tempY.add(y);

        // onDraw를 호출하는 메서드를 호출
        invalidate();

        // 다른 언어에서는 대부분 그림을 그려주는 함수를 호출하는 메서드는 기존 그림을 유지하는데
        // 안드로이드는 지운다. 따라서 좌표값을 저장하는 저장소를 지정해야 한다.


        return true; //return이 false일 경우 touchEvent를 연속해서 발생시키지 않고 true일 때만 연속해서 발생함
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //1. 화면에 터치가 되면
        //2. 연속해서 그림을 그려줌
        //3. 터치된 좌표에 작은 동그라미를 그려준다.

//        for(Path path : pathList){
//            canvas.drawPath(path, paint);
//        }

        canvas.drawPath(pathList.get(pathList.size()-1), pathList.get(pathList.size()-1).getPaint());


//        if(x > -1 && y > -1){
//
//
//            canvas.drawCircle(x, y, RADIUS, paint);
//            for(int i=0; i<tempX.size(); i++){
//                canvas.drawCircle(tempX.get(i), tempY.get(i), RADIUS, paint);
//            }
//        }

    }

    public void setColorr(int color){

        PathTool tool = new PathTool();
        tool.setColor(color);

        pathList.add(tool);

    }
}

class PathTool extends Path{

    private Paint paint = new Paint();


    public void setColor(int color){
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    public Paint getPaint(){
        return this.paint;
    }

}
