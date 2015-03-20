package de.flowment.flowmentapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;


public class SplashScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView bild = (ImageView)findViewById(R.id.centerImage);
        // Fix issue with renderer on certain devices
        bild.setLayerType(View.LAYER_TYPE_SOFTWARE, null); // Nötig weil das Bild sonst weiß bleibt



        SVG svg = SVGParser.getSVGFromResource(getResources(), R.drawable.kreis); // Parse the SVG file from the resource
        bild.setImageDrawable(svg.createPictureDrawable());  // Get a drawable from the parsed SVG and set it as the drawable for the ImageView

        bild.animate().rotation(550).setDuration(3500);


        final Handler handler = new Handler(); // Ein neuer Handler der ein Event auslöst 3s später
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadFlowFeed();
            }
        }, 3000);


    }


    void LoadFlowFeed(){
        startActivity(new Intent(this, FlowFeedActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu__splash_screen, menu);
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
