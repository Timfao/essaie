package ci.esatic.sigl3.essaie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSms = findViewById(R.id.btnSms);
        Button btnVideo = findViewById(R.id.btnVideo);
        Button btnAppel = findViewById(R.id.btnAppel);

        Button btnMusique = findViewById(R.id.btnMusique);

        Button btnLoc = findViewById(R.id.btnLoc);

        Button btnSite = findViewById(R.id.btnSite);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lorsque le bouton est cliqué, ouvrez l'activité PageActivity
                Intent intent = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lorsque le bouton est cliqué, ouvrez l'activité PageActivity
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

        btnAppel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lorsque le bouton est cliqué, ouvrez l'activité PageActivity
                Intent intent = new Intent(MainActivity.this, AppelActivity.class);
                startActivity(intent);
            }
        });

        btnMusique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lorsque le bouton est cliqué, ouvrez l'activité PageActivity
                Intent intent = new Intent(MainActivity.this, MusiqueActivity.class);
                startActivity(intent);
            }
        });

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton est cliqué, ouvrez la carte Google avec l'emplacement de l'ESATIC
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=ESATIC");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps"); // Utiliser Google Maps
                startActivity(mapIntent);
            }
        });
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton est cliqué, ouvrez le navigateur web avec l'URL du site web de l'ESATIC
                String url = "https://www.esatic.ci";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
