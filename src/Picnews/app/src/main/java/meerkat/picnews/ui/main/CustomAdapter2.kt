package meerkat.picnews.ui.main

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import meerkat.picnews.Config
import meerkat.picnews.MainActivity
import meerkat.picnews.R
import meerkat.picnews.SecondActivity
import meerkat.picnews.model.NewsArticle
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.OnItemClickListener


class CustomAdapter2(it:LinkedHashMap<String, HashMap<String, NewsArticle>>,
                     mainActivity: MainActivity,
                     recyclerView: RecyclerView,
                     clickListener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>()/*,
        View.OnClickListener*/{


    companion object {
        const val TAG = "CustomAdapter3"
    }


    var recyclerView: RecyclerView ?= null
    var newsArray: ArrayList<HashMap<String, NewsArticle>> = ArrayList<HashMap<String, NewsArticle>>()
    var mainActivity : MainActivity ?= null
    var mOnClickListener : View.OnClickListener?= null
    //it is a map of news sources name vs a hash map of news_id vs news articles.
    var newsMap: LinkedHashMap<String, HashMap<String, NewsArticle>> = it
    init{
        this.newsArray.addAll(newsMap.values)
        this.mainActivity = mainActivity
        this.recyclerView = recyclerView
        this.mOnClickListener = clickListener
    }

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        // init the item view's
        var name: TextView = itemView.findViewById<View>(R.id.item_name) as TextView
        //var image: ImageView
        var carousel: ImageCarousel = itemView.findViewById<ImageCarousel>(R.id.carousel) as ImageCarousel
        //
        var titleText = itemView.findViewById<TextView>(R.id.item_title) as TextView
    }


    /*private val mOnClickListener =  View.OnClickListener(){


    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        Log.d(TAG, "view: $view")
        view.setOnClickListener(mOnClickListener);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return newsMap.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list: MutableList<CarouselItem> = ArrayList<CarouselItem>()
        val x :  HashMap<String, NewsArticle> = newsArray[holder.adapterPosition]
        //
        if(holder.adapterPosition == 0){
            holder.titleText.text = "Technology"
        }
        if(holder.adapterPosition == 1){
            holder.titleText.text = "Business"
        }
        if(holder.adapterPosition == 2){
            holder.titleText.text = "Entertainment"
        }
        if(holder.adapterPosition == 3){
            holder.titleText.text = "Others"
        }
        //
        //x is a hash map of news_id vs news articles
        //iterate over map to populate carousel list.
        val keys = x.keys
        for(key in keys){
            //news article.
            val value = x[key]
            list.add(
                    CarouselItem(
                            value?.urlToImage,
                            value?.title
                    )
            )

            //
            //holder.titleText.text =value?.description
        }
        //finally add to carousel layout.
        holder.carousel.addData(list)
        //
        holder.carousel.tag = position
        //
        holder.carousel.onItemClickListener = object : OnItemClickListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Log.d(TAG, "position: $position carouselItem: $carouselItem ${holder.carousel.tag}")
                //after getting position and carousel item. traverse to fragment with recyclerview to the said position.

                Config.item = newsArray[holder.carousel.tag as Int]
                Config.position  = position

                val i = Intent(mainActivity, SecondActivity::class.java)
                //i.putExtra(SecondActivity.ITEM, newsArray)
                //i.putExtra(SecondActivity.POS, position)
                //i.putParcelableArrayListExtra(SecondActivity.CAROUSEL_ITEM, carouselItem)
                mainActivity?.startActivity(i)
            }

            override fun onLongClick(position: Int, carouselItem: CarouselItem) {
                Log.d(TAG, "onLongClick/position: $position carouselItem: $carouselItem")
            }

        }


        //
        holder.carousel.setOnClickListener {
            //Log.d(TAG, )
        }


    }

    /*override fun onClick(v: View?) {
        val itemPosition: Int = recyclerView?.getChildLayoutPosition(v!!)!!
        //val item: String = mList.get(itemPosition)
        Log.d(TAG, "itemPosition: $itemPosition")
    }*/
}