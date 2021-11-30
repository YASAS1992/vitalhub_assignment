package com.yasas.candidates;

import android.app.Application;
import android.content.Context;

import com.yasas.candidates.network.CommunicationManager;

public class CandidateApplication extends Application {

    private Entities entities;
    private CommunicationManager communicationManager;

    public Entities getEntities(Context context) {
        if(entities == null){
            entities = new Entities(context);
        }
        return entities;
    }

    public CommunicationManager getCommunicationManager(Context context) {
        if(communicationManager == null){
            communicationManager = new CommunicationManager(context);
        }
        return communicationManager;
    }
}
