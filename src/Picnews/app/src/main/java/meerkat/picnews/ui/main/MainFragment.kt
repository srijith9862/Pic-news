package meerkat.picnews.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.google.android.material.tabs.TabLayout
import meerkat.picnews.R
import meerkat.picnews.model.NewsArticle


class MainFragment : Fragment() {

    companion object {
        const val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var newsRv : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tb = view.findViewById<TabLayout>(R.id.tb_main)
        //setup tab layout.
        initTabs(tb)
        //
        newsRv = view.findViewById<RecyclerView>(R.id.news_rv)
        initRV(newsRv)
        //newsRv.layoutManager = Car
        //setup rv.
        //newsRv.setHasFixedSize(true)
        //val carouselLayoutManager = CarouselLayoutManager.Builder(this@MainActivity, 100).build()
        //recyclerView.setLayoutManager(carouselLayoutManager)
    }


    class viewPager(context: Context) : ViewPager(context){

    }


    private fun initTabs(tb : TabLayout){
        tb.addTab(tb.newTab().setText("Categories"))
        tb.addTab(tb.newTab().setText("Publishers"))
    }

    private fun initRV(rv : RecyclerView){
        rv.layoutManager = LinearLayoutManager(activity)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.filterNewsByEnt()
        //after getting news from entertainment category, we will use carousel layout manager to display a
        //grid view of articles based on the category.
        viewModel.entNewsLiveData.observe(this, Observer{
            Log.d(TAG, "it: $it")
            newsRv?.adapter = NewsAdapter(requireContext(), ArrayList(it.values))
        })
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
            var imageView: ImageView = itemView.findViewById<ImageView>(R.id.img_item)
            val textView: TextView = itemView.findViewById<TextView>(R.id.title_news)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return itemsArray?.size!!
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val newsArticle : NewsArticle? = itemsArray?.get(holder.adapterPosition)
            //set news image.
            GlideApp.with(context!!)
                    .load(newsArticle?.urlToImage)
                    .centerInside()
                    .into(holder.imageView)
            //set news title
            holder.textView.text = newsArticle?.title
        }

    }





















    /*val newsRv = activity?.findViewById<RecyclerView>(R.id.news_rv)

    //val layoutManager = LinearLayoutManager(requireContext())

    val carouselLayoutManager  = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)

    newsRv?.layoutManager = carouselLayoutManager




    viewModel.newsLiveData.observe(this, Observer {
        //Log.d(TAG, "it: $it")

        val adapter = NewsAdapter(requireContext(), it)
        newsRv?.adapter = adapter

        }
    )



    viewModel.entNewsLiveData.observe(this, Observer{
        Log.d(TAG, "it: $it")

        val adapter = NewsAdapter(requireContext(), ArrayList(it.values))
        newsRv?.adapter = adapter


    })*/
    /*internal class TestAdapter(strings: java.util.ArrayList<ChildNewsArticle>) :
        RecyclerView.Adapter<TestAdapter.ViewHolder>() {
        var stringArrayList: java.util.ArrayList<ChildNewsArticle>
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            val view: View =
                LayoutInflater.from(this@MainActivity).inflate(R.layout.test_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(
            holder: ViewHolder,
            position: Int
        ) {

            //System.out.println("onBindViewHolder");
            val childNewsArticle: ChildNewsArticle =
                stringArrayList[holder.adapterPosition]
            if (childNewsArticle != null) {


                //holder.frontCard.setVisibility(View.VISIBLE);
                if (childNewsArticle.urlToImage != null) {
                    GlideApp.with(this@MainActivity)
                        .load(childNewsArticle.urlToImage)
                        .placeholder(R.drawable.ic_image_black_300dp)
                        .centerCrop()
                        .into(holder.iv)
                }
                if (childNewsArticle.title != null) {
                    holder.title.setText(childNewsArticle.title)
                }
                if (childNewsArticle.source != null) {
                    if (childNewsArticle.source.get("name") != null) {
                        holder.sourceName.setText(childNewsArticle.source.get("name").toString())
                    }
                }

                *//*
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(childNewsArticle.url != null){

                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(childNewsArticle.url));
                            startActivity(browserIntent);
                        }

                    }
                });
                *//*
            }
        }

        override fun getItemCount(): Int {
            return stringArrayList.size
        }

        internal inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView),
            View.OnClickListener {
            var iv: ImageView
            var title: TextView
            var sourceName: TextView
            var cardView: CardView
            var frontCard: RelativeLayout
            var backCard: LinearLayout? = null
            var myEasyFlipView: EasyFlipView? = null

            //private Button refresh;
            private val startVideoAdsMuted: CheckBox? = null
            private val videoStatus: TextView? = null
            override fun onClick(v: View) {
                myEasyFlipView.flipTheView()
                //if (mClickListener != null) {
                //  mClickListener.onItemClick(view, getAdapterPosition());
                //}
            }

            init {
                iv = itemView.findViewById(R.id.iv)
                title = itemView.findViewById(R.id.title)
                cardView = itemView.findViewById(R.id.card)
                frontCard = itemView.findViewById(R.id.card_front)
                //backCard = itemView.findViewById(R.id.card_back);
                sourceName = itemView.findViewById(R.id.source_name)
                // = itemView.findViewById(R.id.myEasyFlipView);
                itemView.setOnClickListener(this)


                //refresh = findViewById(R.id.btn_refresh);
                //startVideoAdsMuted = findViewById(R.id.cb_start_muted);
                //videoStatus = findViewById(R.id.tv_video_status);
            }
        }

        init {
            stringArrayList = strings
        }
    }*/

}