package meerkat.picnews.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import meerkat.picnews.R
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class CategoryFrag : Fragment() {

    companion object {
        fun newInstance():CategoryFrag{
            return CategoryFrag()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.category_frag, container, false)
    }



    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)























        //val tb = view.findViewById<TabLayout>(R.id.tb_main)
        //initTabs(tb)

        val carousel: ImageCarousel = view.findViewById(R.id.carousel)
        val carousel2: ImageCarousel = view.findViewById(R.id.carousel2)
        val carousel3: ImageCarousel = view.findViewById(R.id.carousel3)




        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.filterNewsByEnt()
        viewModel.filterNewsByBusiness()
        viewModel.filterNewsByTech()
        //after getting news from entertainment category, we will use carousel layout manager to display a
        //grid view of articles based on the category.
        viewModel.entNewsLiveData.observe(this, Observer{
            Log.d(MainFragment.TAG, "it: $it")
            //newsRv?.adapter = MainFragment.NewsAdapter(requireContext(), ArrayList(it.values))
            val arrayList = it.values
            val collection = ArrayList<CarouselItem>()
            val list = mutableListOf<CarouselItem>()
            for(item in arrayList){
                val cItem = CarouselItem(
                        imageUrl = item.urlToImage,
                        caption = item.title
                )
                //
                collection.add(cItem)
            }
            //
            list.addAll(
                    collection
            )
            //
            carousel.addData(list)
        })

        //
        viewModel.techNewsLiveData.observe(this, Observer{
            Log.d(MainFragment.TAG, "it: $it")
            //newsRv?.adapter = MainFragment.NewsAdapter(requireContext(), ArrayList(it.values))
            val arrayList = it.values
            val collection = ArrayList<CarouselItem>()
            val list = mutableListOf<CarouselItem>()
            for(item in arrayList){
                val cItem = CarouselItem(
                        imageUrl = item.urlToImage,
                        caption = item.title
                )
                //
                collection.add(cItem)
            }
            //
            list.addAll(
                    collection
            )
            //
            carousel2.addData(list)
        })

        viewModel.busNewsLiveData.observe(this, Observer{
            Log.d(MainFragment.TAG, "it: $it")
            //newsRv?.adapter = MainFragment.NewsAdapter(requireContext(), ArrayList(it.values))
            val arrayList = it.values
            val collection = ArrayList<CarouselItem>()
            val list = mutableListOf<CarouselItem>()
            for(item in arrayList){
                val cItem = CarouselItem(
                        imageUrl = item.urlToImage,
                        caption = item.title
                )
                //
                collection.add(cItem)
            }
            //
            list.addAll(
                    collection
            )
            //
            carousel3.addData(list)
        })

// Image URL with caption



    }


    private fun initTabs(tb : TabLayout){
        tb.addTab(tb.newTab().setText("Categories"))
        tb.addTab(tb.newTab().setText("Publishers"))
    }


}