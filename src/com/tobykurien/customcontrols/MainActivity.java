package com.tobykurien.customcontrols;

import com.tobykurien.photoshow.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Gallery;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SpinnerAdapter;

public class MainActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
      SpinnerAdapter adapter = new GalleryAdapter(this);
      Gallery g = (Gallery) findViewById(R.id.gallery);
      g.setAdapter(adapter);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }

}
