package com.example.smartdeviceconnector;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("alljoyn_java");
    }

    private native String generateWifiKey(String macAddress);

    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        Button connectButton = findViewById(R.id.connectButton);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String result = generateWifiKey("88:D0:39:B2:64:3D");
                    statusText.setText("Generated WiFi Key:\n" + result);
                } catch (UnsatisfiedLinkError e) {
                    statusText.setText("Failed to load native library or method not found.");
                }
            }
        });
    }
}
