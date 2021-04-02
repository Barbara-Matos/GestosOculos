package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.android.glass.cardsample.R;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class videochamada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videochamada);
        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    //.setRoom("test123")
                    //.setAudioMuted(false)
                    //.setVideoMuted(false)
                    //.setAudioOnly(false)
                    .setWelcomePageEnabled(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // ISTO AINDA ESTÁ ERRADO PORQUE ESTÁ COM O BOTÃO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void onButtonClick(View view) {
        //EditText editText = findViewById(R.id.conferenceName);
        //String text = editText.getText().toString();
        String text = "HufChamadas";

        if(text.length() > 0) {
            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder().setRoom(text).build();
            JitsiMeetActivity.launch(this, options);
        }
    }
}