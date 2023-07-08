package meerkat.picnews

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import meerkat.picnews.model.NewsArticle
import meerkat.picnews.ui.main.GlideApp


class SecondActivity : AppCompatActivity() {


    companion object{
        const val TAG = "SecondActivity"
        const val POS = "POSITION"
        const val ITEM = "Item"
        const val CAROUSEL_ITEM = "CAROUSEL_ITEM"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val layoutManager = LinearLayoutManager(this)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = layoutManager

        val hMap : HashMap<String, NewsArticle>? = Config.item
        val values = hMap?.values

        Log.d(TAG, "${values}")

        // Creating an ArrayList of values
        // Creating an ArrayList of values
        val listOfValues: ArrayList<NewsArticle> = ArrayList(values)

        val newsAdapter = NewsAdapter(baseContext, listOfValues)
        rv.adapter = newsAdapter

        rv.scrollToPosition(Config.position)


        /*val smoothScroller: SmoothScroller = object : LinearSmoothScroller(baseContext) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }

        smoothScroller.setTargetPosition(Config.position);

        layoutManager.startSmoothScroll(smoothScroller);*/

        /*val array : MutableList<NewsArticle> = arrayListOf<NewsArticle>()
        array.addAll(values)

        */

        /*val bundle = intent?.extras
        val item : ArrayList<HashMap<String, NewsArticle>> = bundle?.getParcelable<>(ITEM) as ArrayList<HashMap<String, NewsArticle>>
        val pos = bundle?.getInt(POS)*/

        //Log.d(TAG, "item: $item pos: $pos")
    }


    class NewsAdapter(cxt : Context,
                      itemsArray : ArrayList<NewsArticle>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


        var context : Context? = null
        var itemsArray : ArrayList<NewsArticle> ?= null
        val TAG = "NewsAdapter"

        init{
            this.context = cxt
            this.itemsArray = itemsArray
        }


        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            var imageView = itemView.findViewById<ImageView>(R.id.img_item)
            val textView = itemView.findViewById<TextView>(R.id.title_news)
            val sourceView = itemView.findViewById<TextView>(R.id.sourceName)
//            val locationView = itemView.findViewById<TextView>(R.id.locationname)
            // changed findByViewID
            val button_share: Button = itemView.findViewById(R.id.button2)
            val button_open: Button = itemView.findViewById(R.id.button)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return itemsArray?.size!!
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val snapShot = itemsArray?.get(holder.adapterPosition)

            //Log.d(TAG, "onBindViewHolder holder:${holder} position:${position} ${snapShot?.getString("title")}")
            Log.d(TAG, "pos: $position snapShot: $snapShot")

            GlideApp.with(context!!)
                .load(snapShot?.urlToImage)
                .fitCenter()
                .into(holder.imageView)
            //set news title
            holder.textView.setText(snapShot?.title)
            if (snapShot?.author != null) {
                holder.sourceView.setText(snapShot?.author + "|" + snapShot?.source?.name)
            }
            else{
                holder.sourceView.setText(snapShot?.source?.name)

            }
//            holder.locationView.setText(snapShot?.publishedAt)   // this has some layout error overlaps on the screen, correct it
            //holder.imageView.set
            holder.imageView.setOnClickListener{
                // open link in browser
                val webIntent: Intent = Uri.parse(snapShot?.url).let { webpage ->
                    Intent(Intent.ACTION_VIEW, webpage)}
                webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context!!.startActivity(webIntent)
            }
            holder.button_share.setOnClickListener{
                // do something on click
//
//

                val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                val clip = ClipData.newPlainText("Copied Text", snapShot?.url)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(context , "Copied Link to clipboard", Toast.LENGTH_LONG).show()
            }
            holder.button_open.setOnClickListener{
                // open link in browser
                val webIntent: Intent = Uri.parse(snapShot?.url).let { webpage ->
                    Intent(Intent.ACTION_VIEW, webpage)}
                webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context!!.startActivity(webIntent)
                Toast.makeText(context , "Opening News article", Toast.LENGTH_LONG).show()
            }
            holder.imageView.setOnClickListener{
                // open link in browser
                val webIntent: Intent = Uri.parse(snapShot?.url).let { webpage ->
                    Intent(Intent.ACTION_VIEW, webpage)}
                webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context!!.startActivity(webIntent)
                Toast.makeText(context , "Opening News article", Toast.LENGTH_LONG).show()

            }
        }

    }

}