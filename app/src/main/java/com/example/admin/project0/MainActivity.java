package com.example.admin.project0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.graphics.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
        ImageView img = new ImageView(this);

        // Create alpaca, a copy of it, and make a canvas
        Bitmap alpaca = BitmapFactory.decodeResource(getResources(), R.drawable.alpaca);
        Bitmap bitmapCopy = alpaca.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(bitmapCopy);

        // Paint styling
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0x88FF91A4); //slightly transparent salmon pink

        // Draw on canvas
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        int circleSize = 35;

        for(int i = circleSize-10; i < height; i = i + circleSize*4){
            for(int j = circleSize+15; j < width; j = j + circleSize*4){
                canvas.drawCircle(j, i, circleSize, paint);
            }
        }

        // Set image view and display it
        img.setImageBitmap(bitmapCopy);
        setContentView(img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
