package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-09-18.
 */

public class DrawView2 extends View {

    ArrayList<PathFinder> pathfinders = new ArrayList<>();
    DrawActivity drawActivity;


    public DrawView2(Context context) {
        super(context);
        PathFinder pathFinder = new PathFinder();
        drawActivity = new DrawActivity();
        pathfinders.add(pathFinder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                if(pathfinders.isEmpty()){
                    pathfinders.add(new PathFinder());

                }

                pathfinders.get(pathfinders.size()-1).path.moveTo(event.getX(), event.getY());

                break;

            case MotionEvent.ACTION_MOVE:
                pathfinders.get(pathfinders.size()-1).path.lineTo(event.getX(), event.getY());
                invalidate();

                break;

            case MotionEvent.ACTION_UP:
                pathfinders.add(new PathFinder());
                pathfinders.get(pathfinders.size()-1).paint.setColor();
                pathfinders.get(pathfinders.size()-1).paint.setStrokeWidth(drawActivity.getSeek());
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawPath(pathfinders.get(pathfinders.size()-1).path, pathfinders.get(pathfinders.size()-1).paint);
        for(PathFinder pathFinder : pathfinders){
            canvas.drawPath(pathFinder.path, pathFinder.paint);
        }
    }
    public void setColor(int color) {
        //pathfinders.add(new PathFinder());

        pathfinders.get(pathfinders.size()-1).paint.setColor(color);


    }

    public void setWidth(int width){
        //pathfinders.add(new PathFinder());

        pathfinders.get(pathfinders.size()-1).paint.setStrokeWidth((float) width);
    }

    public void delete(){
        if(pathfinders.size()>0) {
            pathfinders.remove(pathfinders.size() - 1);

        invalidate();
        }
    }
}

class PathFinder {

    Path path = new Path();
    Paint paint = new Paint();

    public PathFinder() {
        paint.setStyle(Paint.Style.STROKE);
    }

}