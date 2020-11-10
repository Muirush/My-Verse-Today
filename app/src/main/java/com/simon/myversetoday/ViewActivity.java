package com.simon.myversetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    private TextView tv;
    private Button btShare, btCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv = findViewById(R.id.FameTxt);
        btCopy = findViewById(R.id.copy);
        btShare = findViewById(R.id.share);

       String Sverse = getIntent().getStringExtra("verse");
       tv.setText(Sverse);
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,tv.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent,"Complete action using");
                startActivity(shareIntent);
                Toast.makeText(ViewActivity.this, "Thanks for using My Verse Today App", Toast.LENGTH_SHORT).show();


            }
        });
        btCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager manager =  (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData  clipData = ClipData.newPlainText("editText", tv.getText().toString());
                manager.setPrimaryClip(clipData);
                Toast.makeText(ViewActivity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

    }
}