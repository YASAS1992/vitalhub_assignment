package com.yasas.candidates.network;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.*;

public class VolleyNetwork {
    private RequestQueue requestQueue;

    public VolleyNetwork(Context context) {
//        Instantiate the cache
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024); // 1MB cap
//        Set up the network to use HttpURLConnection as the HTTP client.
        BasicNetwork network = new BasicNetwork(new HurlStack(null));
//        Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);
//        Start the queue
        requestQueue.start();
    }

    public void invokeService(RequestParams reqParams) {
        try {
            JSONObject jsonObj = null;
            if (reqParams.getPair() != null) {
                Gson gson = new Gson();

                String jsonString = null;
                try {
                    jsonString = gson.toJson(reqParams.getPair());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jsonObj = new JSONObject(jsonString);
            }

            JsonObjectRequest request = new JsonObjectRequest(reqParams.getHttpMethod().ordinal(), reqParams.getUrl(), jsonObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            reqParams.getListener().onRequestComplete(response.toString(), 200);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            reqParams.getListener().onRequestComplete("Network Connection Error", 999);
                        }
                    }) {

            };
            addRequest(request);
        } catch (JSONException e) {
            reqParams.getListener().onRequestComplete("Network Connection Error", 999);
        }
    }

    private void addRequest(Request request) {
        request.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(request);
    }
}
