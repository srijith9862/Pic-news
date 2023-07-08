package meerkat.picnews

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class dump {




    /*class CustomAdapter2(
        var context: Context,
        personNames: ArrayList,
        personImages: ArrayList
    ) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        var personNames: ArrayList
        var personImages: ArrayList
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Any {
            // infalte the item Layout
            val v: View =
                LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
            // set the view's size, margins, paddings and layout parameters
            return MyViewHolder(v)
        }

        fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            // set the data in items
            holder.name.setText(personNames.get(position))
            holder.image.setImageResource(personImages.get(position))
            // implement setOnClickListener event on item view.
            holder.itemView.setOnClickListener {
                // open another activity on item click
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("image", personImages.get(position)) // put image data in Intent
                context.startActivity(intent) // start Intent
            }
        }

        override fun getItemCount(): Int {
            return personNames.size()
        }

        inner class MyViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            // init the item view's
            var name: TextView
            var image: ImageView

            init {
                // get the reference of item view's
                name = itemView.findViewById<View>(R.id.name) as TextView
                image = itemView.findViewById<View>(R.id.image) as ImageView
            }
        }

        init {
            this.personNames = personNames
            this.personImages = personImages
        }
    }*/
    class CustomAdapter(applicationContext: Context, logos: IntArray) :
        BaseAdapter() {
        var context: Context
        var logos: IntArray
        var inflter: LayoutInflater

        init {
            context = applicationContext
            this.logos = logos
            inflter = LayoutInflater.from(applicationContext)
        }


        override fun getCount(): Int {
            return logos.size
        }

        override fun getItem(i: Int): Any? {
            return null
        }

        override fun getItemId(i: Int): Long {
            return 0
        }

        /*override fun getView(
            i: Int,
            view: View,
            viewGroup: ViewGroup
        ): View {
            var view = view
            view = inflter.inflate(R.layout.activity_gridview, null) // inflate the layout
            val icon: ImageView =
                view.findViewById<View>(R.id.icon) as ImageView // get the reference of ImageView
            icon.setImageResource(logos[i]) // set logo images
            return view
        }*/


        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View? {
            // inflate the layout for each list row
            var convertView = convertView
            if (convertView == null) {
                convertView = LayoutInflater.from(context)
                    .inflate(R.layout.activity_gridview, parent, false)
            }

            // get current item to be displayed
            val currentItem = getItem(position) as ClipData.Item?

            // get the TextView for item name and item description
            /*val icon: ImageCarousel =
                convertView?.findViewById<ImageCarousel>(R.id.carousel) as ImageCarousel // get the reference of ImageView

            val list: MutableList<CarouselItem> = ArrayList()*/

// Image URL with caption

// Image URL with caption
            /*list.add(
                CarouselItem(
                    "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                    "Photo by Aaron Wu on Unsplash"
                )
            )*/


            //icon.addData(list)


            //val icon = convertView?.findViewById<ImageView>(R.id.icon)

            //icon?.setImageResource(logos[position])
            //icon.setImageResource(logos[position]) // set logo images

            // returns the view for the current row
            return convertView
        }


    }


}