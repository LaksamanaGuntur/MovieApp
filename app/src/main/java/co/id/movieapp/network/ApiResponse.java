package co.id.movieapp.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import co.id.movieapp.data.ResultData;

/**
 * Created by Laksamana Guntur Dzulfikar.
 * Android Developer
 */

public class ApiResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<ResultData> results;

    public List<ResultData> getResults() {
        return results;
    }

    public void setResults(List<ResultData> results) {
        this.results = results;
    }
}
