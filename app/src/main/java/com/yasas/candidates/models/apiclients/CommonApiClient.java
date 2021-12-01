package com.yasas.candidates.models.apiclients;

import android.content.Context;

import com.yasas.candidates.CandidateApplication;
import com.yasas.candidates.Entities;
import com.yasas.candidates.network.CommunicationManager;

public class CommonApiClient {
    public Context context;
    public CandidateApplication app;

    public CommonApiClient(Context context) {
        this.context = context;
        app = (CandidateApplication) context;
    }

    public CommunicationManager getCommunicationManager(){
        return app.getCommunicationManager(context);
    }

    public Entities getEntities(){
        return app.getEntities(context);
    }
}
