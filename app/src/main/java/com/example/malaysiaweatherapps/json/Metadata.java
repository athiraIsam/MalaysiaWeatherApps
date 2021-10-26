package com.example.malaysiaweatherapps.json;

import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("resultset")
    ResultSet resultSet;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
