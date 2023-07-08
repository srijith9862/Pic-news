package meerkat.picnews.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsArticle(
        val url: String?,
    val tag: String?,
    val title: String?,
    val author: String?,
    val category_tag: String?,
    val description: String?,
    val publishedAt: String?,
    val urlToImage: String?,
    val news_id: String?,
    val source : Source?
):Parcelable{
    constructor() : this("", "", "", "","", "","","", "", null)

    constructor(parcel: Parcel) : this(
            parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable<Source>(null))

    companion object : Parceler<NewsArticle> {

        override fun NewsArticle.write(parcel: Parcel, flags: Int) {
            parcel.writeString(title)
            parcel.writeString(description)
        }

        override fun create(parcel: Parcel): NewsArticle {
            return NewsArticle(parcel)
        }
    }

}


@Parcelize
data class Source(val id : String?, val name : String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    constructor() : this("", "")

    companion object : Parceler<Source> {

        override fun Source.write(parcel: Parcel, flags: Int) {
            parcel.writeString(id)
            parcel.writeString(name)
        }

        override fun create(parcel: Parcel): Source {
            return Source(parcel)
        }
    }
}


/*
fun acceptsSerializable(s: Serializable) { }

fun main(args: Array<String>) {
    val f: Foo = Foo("baz")
    acceptsSerializable(f)  // Will not compile
}*/
