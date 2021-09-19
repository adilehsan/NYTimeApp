package com.example.nytimeapp.dao.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ArticleResultModel(
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("published_date")
    val published_date: String?,
    @SerializedName("abstract")
    val abstract: String?,
    @SerializedName("source")
    val source: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(byline)
        parcel.writeString(title)
        parcel.writeString(published_date)
        parcel.writeString(abstract)
        parcel.writeString(source)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleResultModel> {
        override fun createFromParcel(parcel: Parcel): ArticleResultModel {
            return ArticleResultModel(parcel)
        }

        override fun newArray(size: Int): Array<ArticleResultModel?> {
            return arrayOfNulls(size)
        }
    }
}