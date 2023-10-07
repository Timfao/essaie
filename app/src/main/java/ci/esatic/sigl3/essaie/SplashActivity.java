package ci.esatic.sigl3.essaie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.os.CountDownTimer;

/*
public class MainActivity extends AppCompatActivity {

    private LinearLayout LoadingPage;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.LoadingPage =(LinearLayout) findViewById(R.id.LoadingPage);


        countDownTimer = new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent otherActivity = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(otherActivity);
                finish();
                isTimerRunning = false;
            } // Durée de 60 secondes, mise à jour toutes les 1 seconde

        };

        countDownTimer.start();
        isTimerRunning = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Assurez-vous d'annuler le CountDownTimer lorsque l'activité est détruite
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
*/


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        new Handler().postDelayed(runnable, 3000);
    }
}
