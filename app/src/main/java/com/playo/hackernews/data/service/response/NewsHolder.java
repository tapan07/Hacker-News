
package com.playo.hackernews.data.service.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsHolder implements Parcelable {

    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;
    @SerializedName("nbHits")
    @Expose
    private Integer nbHits;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("nbPages")
    @Expose
    private Integer nbPages;
    @SerializedName("hitsPerPage")
    @Expose
    private Integer hitsPerPage;
    @SerializedName("processingTimeMS")
    @Expose
    private Integer processingTimeMS;
    @SerializedName("exhaustiveNbHits")
    @Expose
    private Boolean exhaustiveNbHits;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("params")
    @Expose
    private String params;
    public final static Parcelable.Creator<NewsHolder> CREATOR = new Creator<NewsHolder>() {

        public NewsHolder createFromParcel(Parcel in) {
            return new NewsHolder(in);
        }

        public NewsHolder[] newArray(int size) {
            return (new NewsHolder[size]);
        }

    };

    protected NewsHolder(Parcel in) {
        in.readList(this.hits, (Hit.class.getClassLoader()));
        this.nbHits = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nbPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hitsPerPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.processingTimeMS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exhaustiveNbHits = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.query = ((String) in.readValue((String.class.getClassLoader())));
        this.params = ((String) in.readValue((String.class.getClassLoader())));
    }

    public NewsHolder() {
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public Integer getNbHits() {
        return nbHits;
    }

    public void setNbHits(Integer nbHits) {
        this.nbHits = nbHits;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public Integer getHitsPerPage() {
        return hitsPerPage;
    }

    public void setHitsPerPage(Integer hitsPerPage) {
        this.hitsPerPage = hitsPerPage;
    }

    public Integer getProcessingTimeMS() {
        return processingTimeMS;
    }

    public void setProcessingTimeMS(Integer processingTimeMS) {
        this.processingTimeMS = processingTimeMS;
    }

    public Boolean getExhaustiveNbHits() {
        return exhaustiveNbHits;
    }

    public void setExhaustiveNbHits(Boolean exhaustiveNbHits) {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(hits);
        dest.writeValue(nbHits);
        dest.writeValue(page);
        dest.writeValue(nbPages);
        dest.writeValue(hitsPerPage);
        dest.writeValue(processingTimeMS);
        dest.writeValue(exhaustiveNbHits);
        dest.writeValue(query);
        dest.writeValue(params);
    }

    public int describeContents() {
        return 0;
    }
}
