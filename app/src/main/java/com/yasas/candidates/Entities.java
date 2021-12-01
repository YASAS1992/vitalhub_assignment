package com.yasas.candidates;

import android.content.Context;

public class Entities {

    Context context;

    public Entities(Context context) {
        this.context = context;
    }

    public String getCandidatesApiEndPoint(){
        return "https://randomuser.me/documentation#intro";
    }
}
