package meerkat.picnews.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class MainViewModel : ViewModel() {


    companion object{
        const val TAG = "MainViewModel"
    }


    private var db: FirebaseFirestore

    val tags_array = arrayOf<String>("technology", "sports", "entertainment")


    init{
        db = FirebaseFirestore.getInstance()
        Log.d(TAG, "db: $db")
    }



    val newsLiveData: MutableLiveData<ArrayList<DocumentSnapshot>> =  MutableLiveData()

    val snapShotArray = ArrayList<DocumentSnapshot>()

    //fetch all the news articles by tag.
    fun fetchNewsArticle(){
        db.collection("newsArticles")
            .whereEqualTo("tag", "entertainment")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    //val city = document.toObject<NewsArticle>()
                    //Log.d(TAG, "${document.id} => ${document.data}")
                }
                snapShotArray.addAll(documents)
                newsLiveData.postValue(snapShotArray)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }

    //sort by timestamp
}