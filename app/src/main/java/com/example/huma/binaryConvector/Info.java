package com.example.huma.binaryConvector;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Info extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView DevTextView = (TextView) findViewById(R.id.devName_textView);
        final TextView iaapTextView = (TextView) findViewById(R.id.iaap_textView);

        DevTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://facebook.com/huma.zed"));
                startActivity(intent);
            }
        });

        iaapTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iaapTextView.setText("I.A.A.P");
            }
        });
    }
}
