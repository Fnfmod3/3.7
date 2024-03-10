package com.example.myapplication;

import android.app.Activity;
import android.view.View;

public class Key extends View {

    private int width;
    private int height;

    public Key(Context context) {
        super(context);

        width = 50;
        height = 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, width, height, paint);
    }

    public boolean isTouched(float x, float y) {
        return x >= getX() && x <= getX() + width && y >= getY() && y <= getY() + height;
    }
}