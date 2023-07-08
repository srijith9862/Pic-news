package meerkat.picnews.new

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import meerkat.picnews.MainActivity
import meerkat.picnews.R
import meerkat.picnews.ui.main.CustomAdapter3
import meerkat.picnews.ui.main.MainFragment
import meerkat.picnews.ui.main.MainViewModel
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.OnItemClickListener

class PublisherFragment : Fragment() {

    companion object {
        const val TAG = "PublisherFragment"
        fun newInstance(): PublisherFragment {
            return PublisherFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.publisher_list, container, false)
    }

    private lateinit var viewModel: MainViewModel

    private val mOnClickListener: View.OnClickListener = View.OnClickListener(){
        val itemPosition: Int = recyclerView.getChildLayoutPosition(it)
        //val item: String = mList.get(itemPosition)

        Log.d(TAG, "itemPosition===============================================================: $itemPosition")

        Toast.makeText(context, itemPosition, Toast.LENGTH_LONG).show()
    }

    lateinit var recyclerView : RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initialize vm.
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //
        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //setup rv.
        // Changed here the grid layout, please see it once.
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        //
//        Toast.makeText(context , "Loading news sorted based on publisher!!", Toast.LENGTH_LONG).show()

        viewModel.filterNewsBySource()
        //attach observer.
        viewModel.singleData.observe(viewLifecycleOwner, Observer{
            Log.d(TAG, "it/1001: $it")
            //initialize adapter.
            val customAdapter3 = CustomAdapter3(it, activity as MainActivity, recyclerView, mOnClickListener)
            recyclerView.adapter = customAdapter3
        })
    }





    private fun secondFun(view : View){
        val carousel: ImageCarousel = view.findViewById(R.id.carousel)
        val carousel2: ImageCarousel = view.findViewById(R.id.carousel2)
        val carousel3: ImageCarousel = view.findViewById(R.id.carousel3)
        viewModel.filterNewsBySource()
        //after getting news from entertainment category, we will use carousel layout manager to display a
        //grid view of articles based on the category.
        viewModel.ndtvLiveData.observe(this, Observer{
            Log.d(MainFragment.TAG, "it/1000: $it")
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
        viewModel.news18LiveData.observe(this, Observer{
            Log.d(MainFragment.TAG, "it/1001: $it")
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

        viewModel.gnewsLiveData.observe(this, Observer{
            Log.d(MainFragment.TAG, "it/1002: $it")
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
    }
}