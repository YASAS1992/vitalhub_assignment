package com.yasas.candidates.models.apiclients;

import android.content.Context;

import com.google.gson.Gson;
import com.yasas.candidates.models.CandidateResponseModel;
import com.yasas.candidates.models.models.candidate.Candidate;
import com.yasas.candidates.network.ICommunication;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CandidatesApiClient extends CommonApiClient{

    private CandidatesApiClient instance;
    private MutableLiveData<List<Candidate>> candidates;

    public CandidatesApiClient(Context context) {
        super(context);
        candidates = new MutableLiveData<>();
    }

    public CandidatesApiClient getInstance() {
        if(instance==null){
            instance = new CandidatesApiClient(context);
        }
        return instance;
    }

    public LiveData<List<Candidate>> getCandidates() {
        return candidates;
    }

    public void getCandidatesFromApi(){
        String url = app.getEntities(context).getCandidatesApiEndPoint();
        getCommunicationManager().GET(null, url, new ICommunication() {
            @Override
            public void onRequestComplete(String response, int responseCode) {
                if(responseCode == 200){

                    Gson gson = new Gson();
                    CandidateResponseModel candidateResponse = gson.fromJson(response,CandidateResponseModel.class);
                    candidates.postValue(candidateResponse.getResults());

                }else{

                }
            }
        });
    }
}
