package com.tobykurien.customcontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class GalleryImage extends ImageView {
   public GalleryImage(Context context) {
      super(context);
   }

   public GalleryImage(Context context, AttributeSet attrs) {
      super(context, attrs);
   }

   public GalleryImage(Context context, AttributeSet attrs, int defStyle) {
      super(context, attrs, defStyle);
   }

   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      // fit to width
      int width = MeasureSpec.getSize(widthMeasureSpec);
      int height = width * 1200 / 1920;
      setMeasuredDimension(width, height);
   }
}
