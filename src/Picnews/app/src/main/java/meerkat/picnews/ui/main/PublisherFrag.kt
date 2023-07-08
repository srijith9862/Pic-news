package meerkat.picnews.ui.main

import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import meerkat.picnews.R
import meerkat.picnews.model.NewsArticle
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import java.util.*
import kotlin.collections.ArrayList


class PublisherFrag: Fragment() {

    companion object {
        const val TAG = "PublisherFrag"
        fun newInstance():PublisherFrag{
            return PublisherFrag()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.publisher_frag, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // get the reference of RecyclerView
        // get the reference of RecyclerView
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        // set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        // set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
    }




}