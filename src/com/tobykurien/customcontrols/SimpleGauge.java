package com.tobykurien.customcontrols;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class SimpleGauge extends View {
   int value = 0;
   int max = 100;
   int min = 0;

   Paint pCirc;
   Paint pLine;

   boolean tracking = false;
   int startVal = 0;
   int startX = 0;

   public SimpleGauge(Context context) {
      super(context);
      // TODO Auto-generated constructor stub
   }

   public SimpleGauge(Context context, AttributeSet attrs) {
      super(context, attrs);
      // TODO Auto-generated constructor stub
   }

   public SimpleGauge(Context context, AttributeSet attrs, int defStyle) {
      super(context, attrs, defStyle);
      // TODO Auto-generated constructor stub
   }

   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      setMeasuredDimension(250, 250);
   }

   @Override
   protected void onFinishInflate() {
      super.onFinishInflate();
      pCirc = new Paint();
      pCirc.setARGB(255, 255, 0, 0);

      pLine = new Paint();
      pLine.setARGB(255, 0, 0, 255);
      pLine.setStrokeWidth(10);
   }

   @Override
   public void draw(Canvas canvas) {
      super.draw(canvas);
      canvas.save();

      int centerX = getWidth() / 2;
      int centerY = getHeight() / 2;

      // draw background
      canvas.drawCircle(centerX, centerY, 100, pCirc);
      canvas.rotate(getValue() * 360 / 100, centerX, centerY);
      canvas.drawLine(centerX, centerY, centerX - 100, centerY, pLine);

      canvas.restore();
   }
   
   @Override
   public boolean onTouchEvent(MotionEvent event) {

      if (event.getAction() == MotionEvent.ACTION_DOWN) {
         // start tracking
         startVal = value;
         startX = (int) event.getX();
         return true;
      }

      if (event.getAction() == MotionEvent.ACTION_MOVE) {
         if (Math.abs(event.getX() - startX) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
            // prevent scrollview from grabbing events
            getParent().requestDisallowInterceptTouchEvent(true);
            tracking = true;
         }
         if (tracking) {
            value = startVal + (int) (event.getX() - startX);
            if (value < min) value = min;
            if (value > max) value = max;
            invalidate();
         }
         return true;
      }

      if (event.getAction() == MotionEvent.ACTION_UP) {
         getParent().requestDisallowInterceptTouchEvent(false);
         tracking = false;
         invalidate();
         return true;
      }
      
      return super.onTouchEvent(event);
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
      invalidate();
   }

   public int getMax() {
      return max;
   }

   public void setMax(int max) {
      this.max = max;
   }

   public int getMin() {
      return min;
   }

   public void setMin(int min) {
      this.min = min;
   }
}
