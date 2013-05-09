package com.tobykurien.customcontrols;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.tobykurien.photoshow.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryAdapter extends BaseAdapter {
   Context context;
   BitmapFactory.Options o2;
   
   String[] images = { 
            "hills_and_mountains-wallpaper.jpg", 
            "iron_man_3_iron_man_vs_mandarin-wallpaper.jpg", 
            "sunset_over_the_tasman_sea-wallpaper.jpg", 
            "the_endless_fields_of_queenstown-wallpaper.jpg" };

   public GalleryAdapter(Context context) {
      this.context = context;
   }

   @Override
   public int getCount() {
      return images.length;
   }

   @Override
   public String getItem(int arg0) {
      return images[arg0];
   }

   @Override
   public long getItemId(int arg0) {
      return arg0;
   }

   @Override
   public View getView(int row, View convertView, ViewGroup parent) {
      Log.i("adapter", "getView called for " + row);
      if (convertView == null) {
         convertView = LayoutInflater.from(context).inflate(R.layout.gallery_item, null);
      }
      
      ImageView image = (ImageView) convertView.findViewById(R.id.gal_image);
      TextView caption = (TextView) convertView.findViewById(R.id.gal_caption);
      try {
         Bitmap bitmap = BitmapFactory.decodeStream(context.getAssets().open(getItem(row)));
         Log.i("adapter", "Bitmap size: " + (bitmap.getRowBytes() * bitmap.getHeight()));
         image.setImageBitmap(bitmap);
         caption.setText(getItem(row));
      } catch (IOException e) {
         Log.e("adapter", "error loading image", e);
      }      
      return convertView;
   }
}
