package meerkat.picnews.ui.main

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
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import meerkat.picnews.R

class MainFragment : Fragment() {

    companion object {
        const val TAG = "e"
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.fetchNewsArticle()

        val newsRv = activity?.findViewById<RecyclerView>(R.id.news_rv)

        val layoutManager = LinearLayoutManager(requireContext())
        newsRv?.layoutManager = layoutManager


        viewModel.newsLiveData.observe(this, Observer {
            Log.d(TAG, "it: $it")

            val adapter = NewsAdapter(requireContext(), it)
            newsRv?.adapter = adapter

            }
        )
    }


    class NewsAdapter(cxt : Context,
                      itemsArray : ArrayList<DocumentSnapshot>) :
            RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


        var context : Context? = null
        var itemsArray : ArrayList<DocumentSnapshot> ?= null
        val TAG = "NewsAdapter"

        init{
            this.context = cxt
            this.itemsArray = itemsArray
        }


        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            var imageView = itemView.findViewById<ImageView>(R.id.img_item)
            val textView = itemView.findViewById<TextView>(R.id.title_news)
            val sourceView = itemView.findViewById<TextView>(R.id.sourceName)
            val locationView = itemView.findViewById<TextView>(R.id.locationname)
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

            Log.d(TAG, "onBindViewHolder holder:${holder} position:${position} ${snapShot?.getString("title")}")
            Log.d(TAG, "pos: $position snapShot: $snapShot")
            Log.d(TAG, "urlToImage: ${snapShot?.getString("urlToImage")}")
            Log.d(TAG, "title: ${snapShot?.getString("title")}")

            //set news image.
            //Glide.with(context!!).load(snapShot?.getString("urlToImage")).into(holder.imageView)
            GlideApp.with(context!!)
                    .load(snapShot?.getString("urlToImage"))
                    .fitCenter()
                    .into(holder.imageView)
            //set news title
            holder.textView.setText(snapShot?.getString("title"))
            holder.sourceView.setText(snapShot?.getString(("author"))+"|"+snapShot?.getString(("source.name")))
            holder.locationView.setText(snapShot?.getString(("publishedAt")))   // this has some layout error overlaps on the screen, correct it
            //holder.imageView.set
            holder.button_share.setOnClickListener{
                // do something on click

                val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                val clip = ClipData.newPlainText("Copied Text", snapShot?.getString(("url")))
                clipboard.setPrimaryClip(clip)
            }
            holder.button_open.setOnClickListener{
                // open link in browser
                val webIntent: Intent = Uri.parse(snapShot?.getString(("url"))).let { webpage ->
                    Intent(Intent.ACTION_VIEW, webpage)}
                    context!!.startActivity(webIntent)
                }
            }


        }

    }

