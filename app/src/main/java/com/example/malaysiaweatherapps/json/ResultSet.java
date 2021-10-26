package com.example.malaysiaweatherapps.json;

import com.google.gson.annotations.SerializedName;

public class ResultSet {

    @SerializedName("count")
    Integer count;

    @SerializedName("offset")
    Integer offset;

    @SerializedName("limit")
    Integer limit;

    @SerializedName("locationid")
    String locationId;

    @SerializedName("datasetid")
    String dataSetId;

    @SerializedName("datacategoryid")
    String dataCategoryId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(String dataSetId) {
        this.dataSetId = dataSetId;
    }

    public String getDataCategoryId() {
        return dataCategoryId;
    }

    public void setDataCategoryId(String dataCategoryId) {
        this.dataCategoryId = dataCategoryId;
    }
}
