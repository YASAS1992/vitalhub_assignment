package com.yasas.candidates.network;

import android.content.Context;

public class CommunicationManager extends VolleyNetwork{

    public CommunicationManager(Context context) {
        super(context);
    }

    public void GET(Object pair, String url, ICommunication listener) {

        RequestParams params = new RequestParams();
        params.setPair(pair);
        params.setUrl(url);
        params.setListener(listener);
        params.setHttpMethod(HttpMethod.GET);
        invokeService(params);
    }
}
