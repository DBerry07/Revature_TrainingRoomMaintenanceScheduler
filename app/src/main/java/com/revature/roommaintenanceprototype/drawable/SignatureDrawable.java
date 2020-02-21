package com.revature.roommaintenanceprototype.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class SignatureDrawable extends View {
    private Paint mPaint;
    private Path mPath;
    private float mCurX, mCurY;
    private float mStartX, mStartY;
    private float strokeWidth;

    private float distance;

    public SignatureDrawable(Context context) {
        super(context);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPath = new Path();
        mCurX = 0;
        mCurY = 0;
        mStartX = 0;
        mStartY = 0;
        strokeWidth = 3f;
        distance = 5f;

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setAntiAlias(true);
        mPaint.setPathEffect(new CornerPathEffect(6));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                actionDown(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                actionMove(x,y);
                break;
            case MotionEvent.ACTION_UP:
                actionUp();
                break;
        }
        invalidate();
        return true;
    }

    //pencil down on paper
    private void actionDown(float x, float y){
        mPath.moveTo(x,y);
    }

    //hand still puts pressure on the pencil while moving across paper
    private void actionMove(float x, float y){
        mPath.lineTo(x,y);
        mCurX = x;
        mCurY = y;
    }

    //hand lifts off the paper
    private void actionUp(){
        mPath.lineTo(mCurX, mCurY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }

    public void clearCanvas(){
        mPath.reset();
        invalidate();
    }
}
