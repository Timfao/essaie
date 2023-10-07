package ci.esatic.sigl3.essaie;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SmsActivity extends AppCompatActivity {

    EditText editTextPhone;
    EditText editTextMessage;
    Button btnEnvoie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editTextPhone = findViewById(R.id.editTextPhone); // Utilisez "R.id" au lieu de "R.layout"
        editTextMessage = findViewById(R.id.editTextMessage); // Utilisez "R.id" au lieu de "R.layout"
        btnEnvoie = findViewById(R.id.btnEnvoie); // Utilisez "R.id" au lieu de "R.layout"

        Button retourButton = findViewById(R.id.btnRetour);

        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton Retour est cliqué, revenez à activity_main
                Intent intent = new Intent(SmsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnEnvoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Vérifiez si la permission SEND_SMS est accordée
                if (ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    envoieSms();
                } else {
                    // Demande la permission si elle n'est pas accordée
                    ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS},
                            100);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            envoieSms();
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void envoieSms() {
        String phone = editTextPhone.getText().toString();
        String message = editTextMessage.getText().toString();

        if (!phone.isEmpty() && !message.isEmpty()) {
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phone, null, message, null, null); // Utilisez "sendTextMessage" au lieu de "envoieTextMessage"
            Toast.makeText(this, "Message envoyé avec succès", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Veuillez entrer le numéro et le message", Toast.LENGTH_SHORT).show();
        }
    }

    public void retourMenu() {
        onBackPressed();
    }
}



