package com.example.drawapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private Path path;
    private List<Path> paths;
    private List<Integer> colors;
    private int currentColor;
    private List<PointF> startPoints;
    private List<PointF> endPoints;

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paths = new ArrayList<>();
        colors = new ArrayList<>();
        startPoints = new ArrayList<>();
        endPoints = new ArrayList<>();
        currentColor = Color.RED;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < paths.size(); i++) {
            paint.setColor(colors.get(i));
            canvas.drawPath(paths.get(i), paint);
            drawCircle(canvas, startPoints.get(i), colors.get(i));
            drawCircle(canvas, endPoints.get(i), colors.get(i));
        }
    }

    private void drawCircle(Canvas canvas, PointF point, int color) {
        paint.setColor(color);
        canvas.drawCircle(point.x, point.y, 6, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x, y);
                paths.add(path);
                colors.add(currentColor);
                startPoints.add(new PointF(x, y));
                endPoints.add(new PointF(x, y));
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                endPoints.set(endPoints.size() - 1, new PointF(x, y));
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public void setDrawingColor(int color) {
        currentColor = color;
    }

    public void clear() {
        paths.clear();
        colors.clear();
        startPoints.clear();
        endPoints.clear();
        invalidate();
    }
}


