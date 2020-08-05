package com.suek.ex41admobtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class SecondActivity extends AppCompatActivity {

    //전면광고는 View 가 아니라 다이얼로그 같은 것임
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //객체생성 및 광고단위 ID 설정
        interstitialAd= new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-8476409921730747/3918910274");

        //광고요청
        AdRequest adRequest= new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        //광고가 모두 laod 된후 interestitialAd 에 보여지도록!!
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Toast.makeText(SecondActivity.this, "광고로딩 실패", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Toast.makeText(SecondActivity.this, "", Toast.LENGTH_SHORT).show();
                interstitialAd.show();
            }
        });
    }





    public void clickShow(View view) {
        AdRequest adRequest= new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

    }
}
