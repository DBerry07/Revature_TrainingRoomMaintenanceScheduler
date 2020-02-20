package com.revature.roommaintenanceprototype.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class SignatureDrawable {
    private Canvas canvas;
    private Paint paint;
    private Bitmap bitmap;
    private int signatureHeight, signatureWidth;
    private ImageView imageView;
    private ArrayList<Point> pathPoints = new ArrayList<>();
    private Path pathGraphic;

    private SignatureDrawable(){}

    public SignatureDrawable(int signatureWidth, int signatureHeight){
        this.signatureWidth = signatureWidth;
        this.signatureHeight = signatureHeight;
        Log.d("DIMEN",signatureWidth+" | "+signatureHeight);
        initPaint();
        initBitmap();
        initCanvas();
        pathGraphic = new Path();
        fillPathWithDummyPoints();
    }

    private void fillPathWithDummyPoints(){
        for(int i=0; i<signatureWidth;i++){
            pathPoints.add(new Point(0,i));
        }
    }

    private void initPaint(){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
    }

    private void initCanvas(){
        if(bitmap != null){
            canvas = new Canvas(bitmap);
            canvas.drawColor(Color.YELLOW);//set background color of canvas
        }
    }

    private void initBitmap(){
        bitmap = Bitmap.createBitmap(
             signatureWidth,
             signatureHeight,
             Bitmap.Config.ARGB_8888
        );
    }

    public Bitmap drawPath(){
        //canvas.drawPath(pathGraphic, paint);
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.TRANSPARENT);
        canvas.drawPaint(paint);
        for (int i = 50; i < 100; i++) {
            path.moveTo(i, i-1);
            path.lineTo(i, i);
        }
        path.close();
        paint.setStrokeWidth(3);
        paint.setPathEffect(null);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
        return bitmap;
    }

    class Point{
        float x,y;

        private Point(){}
        Point(float x, float y){
            this.x = x;
            this.y = y;
        }
    }
}
