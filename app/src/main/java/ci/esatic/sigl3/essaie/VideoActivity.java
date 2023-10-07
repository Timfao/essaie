package ci.esatic.sigl3.essaie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Button retourButton = findViewById(R.id.btnRetour);

        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton Retour est cliqué, revenez à activity_main
                Intent intent = new Intent(VideoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        VideoView videoView = findViewById(R.id.video_view); // Utilisez "R.id" pour trouver la vue vidéo, pas "R.layout"
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video; // Utilisez "android.resource" au lieu de "android.ressource"
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start(); // Vous devez également démarrer la lecture de la vidéo
    }
}

