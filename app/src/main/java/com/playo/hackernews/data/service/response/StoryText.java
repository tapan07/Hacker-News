
package com.playo.hackernews.data.service.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryText implements Parcelable {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("matchLevel")
    @Expose
    private String matchLevel;
    @SerializedName("matchedWords")
    @Expose
    private List<Object> matchedWords = null;
    public final static Parcelable.Creator<StoryText> CREATOR = new Creator<StoryText>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StoryText createFromParcel(Parcel in) {
            return new StoryText(in);
        }

        public StoryText[] newArray(int size) {
            return (new StoryText[size]);
        }

    };

    protected StoryText(Parcel in) {
        this.value = ((String) in.readValue((String.class.getClassLoader())));
        this.matchLevel = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.matchedWords, (java.lang.Object.class.getClassLoader()));
    }

    public StoryText() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    public List<Object> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<Object> matchedWords) {
        this.matchedWords = matchedWords;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
        dest.writeValue(matchLevel);
        dest.writeList(matchedWords);
    }

    public int describeContents() {
        return 0;
    }

}
