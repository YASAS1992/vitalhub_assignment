package com.yasas.candidates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActCommon extends AppCompatActivity {

    public CandidateApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (CandidateApplication) this.getApplication();
    }
}