package com.yasas.candidates.network;

public class RequestParams {
    Object pair;
    String url;
    ICommunication listener;
    HttpMethod httpMethod;

    public Object getPair() {
        return pair;
    }

    public void setPair(Object pair) {
        this.pair = pair;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ICommunication getListener() {
        return listener;
    }

    public void setListener(ICommunication listener) {
        this.listener = listener;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }
}
