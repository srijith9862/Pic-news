package meerkat.picnews.ui.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import meerkat.picnews.model.NewsArticle

class MainViewModel : ViewModel() {


    companion object{
        const val TAG = "MainViewModel"
    }


    private var db: FirebaseFirestore

    val tags_array = arrayOf<String>("technology", "sports", "entertainment")


    init{
        db = FirebaseFirestore.getInstance()
        //Log.d(TAG, "db: $db")
    }



    val newsLiveData: MutableLiveData<ArrayList<NewsArticle>> =  MutableLiveData()
    val entNewsLiveData: MutableLiveData<HashMap<String, NewsArticle>> =  MutableLiveData()
    val busNewsLiveData: MutableLiveData<HashMap<String, NewsArticle>> =  MutableLiveData()
    val techNewsLiveData: MutableLiveData<HashMap<String, NewsArticle>> =  MutableLiveData()


    private val allNewsArticles = ArrayList<NewsArticle>()
    private val entCatNewsArticles : HashMap<String, NewsArticle> = HashMap()
    private val busCatNewsArticles : HashMap<String, NewsArticle> = HashMap()
    private val techCatNewsArticles : HashMap<String, NewsArticle> = HashMap()
    val ndtvLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val ndtvNewsArticle : HashMap<String, NewsArticle> = HashMap()

    val gnewsLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val gnewsNewsArticle : HashMap<String, NewsArticle> = HashMap()

    val htLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val htNewsArticle : HashMap<String, NewsArticle> = HashMap()

    val news18LiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val news18NewsArticle : HashMap<String, NewsArticle> = HashMap()

    val otherLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val otherNewsArticle : HashMap<String, NewsArticle> = HashMap()
//    private val ndtvNewsArticle : HashMap<String, NewsArticle> = HashMap()


    val techLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val techNewsArticle : HashMap<String, NewsArticle> = HashMap()

    val busLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val busNewsArticle : HashMap<String, NewsArticle> = HashMap()

    val entLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val entNewsArticle : HashMap<String, NewsArticle> = HashMap()



    val catLiveData : MutableLiveData<HashMap<String,NewsArticle>> = MutableLiveData()
    private  val catNewsArticle : HashMap<String, NewsArticle> = HashMap()


    val singleData : MutableLiveData<LinkedHashMap<String, HashMap<String, NewsArticle>>> = MutableLiveData()



    //fetch all the news articles by tag.
    fun fetchNewsArticle(){
        db.collection("newsArticles1")
            //.whereEqualTo("tag", "entertainment")
            .get()
            .addOnSuccessListener { documents ->

                val arrayList = ArrayList<NewsArticle>()
                for (document in documents) {
                    //converting document to news article object.
                    val city : NewsArticle = document.toObject<NewsArticle>()
                    //Log.d(TAG, "${city.category_tag} => ${city.description}")
                    arrayList.add(city)
                }
                //
                allNewsArticles.addAll(arrayList)
                newsLiveData.postValue(allNewsArticles)
                //filter news articles by category.
                filterNewsBySource()
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }


    fun filterNewsByEnt(){
        db.collection("newsArticles1")
            .whereEqualTo("category_tag", "entertainment")
            .get()
            .addOnSuccessListener { documents ->

                //val arrayList = ArrayList<NewsArticle>()
                for (document in documents) {
                    //converting document to news article object.
                    val news : NewsArticle = document.toObject<NewsArticle>()
                    //Log.d(TAG, "${city.category_tag} => ${city.description}")
                    entCatNewsArticles[news.news_id!!] = news
                }
                //
                entNewsLiveData.postValue(entCatNewsArticles)
                //filter news articles by category.
                //filterNewsBySource(arrayList)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }

    fun filterNewsByBusiness(){
        db.collection("newsArticles1")
            .whereEqualTo("category_tag", "business")
            .get()
            .addOnSuccessListener { documents ->

                //val arrayList = ArrayList<NewsArticle>()
                for (document in documents) {
                    //converting document to news article object.
                    val news : NewsArticle = document.toObject<NewsArticle>()
                    //Log.d(TAG, "${city.category_tag} => ${city.description}")
                    busCatNewsArticles[news.news_id!!] = news
                }
                //
                busNewsLiveData.postValue(busCatNewsArticles)
                //filter news articles by category.
                //filterNewsBySource(arrayList)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }



    fun filterNewsByTech(){
        db.collection("newsArticles1")
            .whereEqualTo("category_tag", "technology")
            .get()
            .addOnSuccessListener { documents ->

                //val arrayList = ArrayList<NewsArticle>()
                for (document in documents) {
                    //converting document to news article object.
                    val news : NewsArticle = document.toObject<NewsArticle>()
                    //Log.d(TAG, "${city.category_tag} => ${city.description}")
                    techCatNewsArticles[news.news_id!!] = news
                }
                //
                techNewsLiveData.postValue(techCatNewsArticles)
                //filter news articles by category.
                //filterNewsBySource(arrayList)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }



    //sort by timestamp

     fun filterNewsBySource(){


         viewModelScope.launch(Dispatchers.IO) {
             //val jsonBody = "{ username: \"$username\", token: \"$token\"}"
             //loginRepository.makeLoginRequest(jsonBody)

             db.collection("newsArticles1").limit(80)
                 .get()
                 .addOnSuccessListener { documents ->
                     val allNews : ArrayList<NewsArticle>
                     for (document in documents){
                         val news : NewsArticle = document.toObject<NewsArticle>()
                         if(news.category_tag?.isNotEmpty()!!){
                             if(news.news_id?.isNotEmpty()!!){
                                 //Log.d(TAG, "news/2: $news ${news.category_tag} ${news.tag}")
                             }
                         }
                         if (news.source?.name == "Google News"){
                             continue
                         }

                         if(news.source?.name == "NDTV News") {
                             //Log.d(TAG, "news: ${news.news_id}")
                             ndtvNewsArticle[news.news_id!!] = news
                         }
                         else if(news.source?.name == "Hindustan Times"){
                             htNewsArticle[news.news_id!!] = news
                         }
                         else if(news.source?.name == "News18"){
                             news18NewsArticle[news.news_id!!] = news
                         }
                         else{
                             otherNewsArticle[news.news_id!!] = news
                         }
                     }
                     //entNewsLiveData.postValue(entCatNewsArticles)
                     ndtvLiveData.postValue(ndtvNewsArticle)
                     htLiveData.postValue(htNewsArticle)
                     news18LiveData.postValue(news18NewsArticle)
//                     gnewsLiveData.postValue(gnewsNewsArticle)
                     otherLiveData.postValue(otherNewsArticle)

                     val hashMap : LinkedHashMap<String, HashMap<String, NewsArticle>> = LinkedHashMap()

                     //hashMap["ent"] = entCatNewsArticles
                     hashMap["ndtv"] = ndtvNewsArticle
                     hashMap["ht"] = htNewsArticle
                     hashMap["news18"] = news18NewsArticle
//                     hashMap["gnews"] = gnewsNewsArticle
                     hashMap["other"] = otherNewsArticle

                     singleData.postValue(hashMap)
                 }
                 .addOnFailureListener{exception ->
                     Log.w(TAG,"Error Getting Documents", exception)
                 }


         }








         }

    fun filterNewsBySource2() {


        viewModelScope.launch(Dispatchers.IO) {
            //val jsonBody = "{ username: \"$username\", token: \"$token\"}"
            //loginRepository.makeLoginRequest(jsonBody)

            db.collection("newsArticles1").limit(80)
                    .get()
                    .addOnSuccessListener { documents ->
                        val allNews: ArrayList<NewsArticle>
                        for (document in documents) {
                            val news: NewsArticle = document.toObject<NewsArticle>()
                            if (news.category_tag?.isNotEmpty()!!) {
                                if (news.news_id?.isNotEmpty()!!) {
                                    //Log.d(TAG, "news/2: $news ${news.category_tag} ${news.tag}")
                                }
                            }
                            if (news.source?.name == "Google News"){
                                continue
                            }

                            if (news.category_tag == "technology") {
                                //Log.d(TAG, "news: ${news.news_id}")
                                techNewsArticle[news.news_id!!] = news
                            } else if (news.category_tag == "business") {
                                busNewsArticle[news.news_id!!] = news
                            } else if (news.category_tag == "entertainment") {
                                entNewsArticle[news.news_id!!] = news
                            } else {
                                catNewsArticle[news.news_id!!] = news
                            }
                        }
                        //entNewsLiveData.postValue(entCatNewsArticles)
                        techLiveData.postValue(techNewsArticle)

                        busLiveData.postValue(busNewsArticle)
                        entLiveData.postValue(entNewsArticle)
                        catLiveData.postValue(catNewsArticle)

                        val hashMap1: LinkedHashMap<String, HashMap<String, NewsArticle>> = LinkedHashMap()

                        //hashMap["ent"] = entCatNewsArticles
                        hashMap1["tech"] = techNewsArticle
                        hashMap1["bus"] = busNewsArticle
                        hashMap1["ent"] = entNewsArticle
//                     hashMap["gnews"] = gnewsNewsArticle
                        hashMap1["cat"] = catNewsArticle

                        singleData.postValue(hashMap1)
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error Getting Documents", exception)
                    }


        }
    }
}

