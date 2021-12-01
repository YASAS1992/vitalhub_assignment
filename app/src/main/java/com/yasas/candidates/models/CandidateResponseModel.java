package com.yasas.candidates.models;

import com.yasas.candidates.models.models.Info;
import com.yasas.candidates.models.models.candidate.Candidate;

import java.util.ArrayList;

public class CandidateResponseModel {
    private ArrayList<Candidate> results;
    private Info info;

    public ArrayList<Candidate> getResults() {
        return results;
    }

    public void setResults(ArrayList<Candidate> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
