package com.example.brandonward.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.revmob.RevMob;
import com.revmob.RevMobAdsListener;
import com.revmob.RevMobTestingMode;
import com.revmob.ads.banner.RevMobBanner;


public class MyCalculator extends Activity implements IMyCalculator {
    private RevMob revmob;
    private RevMobBanner myBanner;
    private String revMobAppId = "53b5e88de55519520b88ca31";
    private String display = "";

    private RevMobAdsListener listener = new RevMobAdsListener() {
        @Override
        public void onRevMobSessionIsStarted() {

        }

        @Override
        public void onRevMobSessionNotStarted(String s) {

        }

        public void onRevMobAdReceived() {

        }
        public void onRevMobAdNotReceived(String message) {

        }
         public void onRevMobAdDisplayed(){

         }
        public void onRevMobAdDismiss() {

        }
        public void onRevMobAdClicked() {

        }

        @Override
        public void onRevMobEulaIsShown() {

        }

        @Override
        public void onRevMobEulaWasAcceptedAndDismissed() {

        }

        @Override
        public void onRevMobEulaWasRejected() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calculator);

        // Starting RevMob session
        revmob = RevMob.startWithListenerForWrapper(this,revMobAppId, listener); //RevMob Media ID configured in the AndroidManifest.xml file
        revmob.setTestingMode(RevMobTestingMode.WITH_ADS); // with this line, RevMob will always deliver a sample ad
        RevMobBanner banner = revmob.createBanner(this, listener);
        ViewGroup view = (ViewGroup) findViewById(R.id.banner);
        view.addView(banner);
        //revmob.showBanner(this);
    }

    @Override
    public void onResume(Bundle savedInstanceState) {
        super.onResume();
        setContentView(R.layout.activity_my_calculator);

        RevMob revmob = RevMob.start(this); // RevMob Media ID configured in the AndroidManifest.xml file
        RevMobBanner banner = revmob.createBanner(this, listener);
        ViewGroup view = (ViewGroup) findViewById(R.id.banner);
        view.addView(banner);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View v){
        Button button = (Button) v;
    }
}
