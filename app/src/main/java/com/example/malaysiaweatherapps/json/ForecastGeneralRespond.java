package com.example.malaysiaweatherapps.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ForecastGeneralRespond {

    @SerializedName("metadata")
    Metadata metadata;

    @SerializedName("results")
    List<ForecastGeneralResult> results = new ArrayList<>();

    public List<ForecastGeneralResult> getResults() {
        return results;
    }

    public void setResults(List<ForecastGeneralResult> results) {
        this.results = results;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
