package meerkat.picnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import meerkat.picnews.ui.main.CategoryFrag
import meerkat.picnews.new.PublisherFragment
import meerkat.picnews.new.CategoriesFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Instantiate a ViewPager and a PagerAdapter.
        val mPager = findViewById<ViewPager>(R.id.pager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter = pagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tb)
        tabLayout.setupWithViewPager(mPager)
        Toast.makeText(applicationContext , "Loading your favorite news!!", Toast.LENGTH_LONG).show()


        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CategoryFrag.newInstance())
                    .commitNow()
        }*/
    }


    val NUM_PAGES = 2

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        val titles = arrayOf<String>("Categories", "Publishers")


        override fun getCount(): Int = NUM_PAGES

        /*override fun getItem(position: Int): Fragment = ScreenSlidePageFragment()*/

        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> CategoriesFragment.newInstance()
                1 -> PublisherFragment.newInstance()
                else -> Fragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence {
            return "${titles[position]}"
        }

    }


    class ScreenSlidePageFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
    }

}