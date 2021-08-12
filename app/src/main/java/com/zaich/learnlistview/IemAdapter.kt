package com.zaich.learnlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zaich.learnlistview.databinding.ItemIemBinding
import de.hdodenhof.circleimageview.CircleImageView
import androidx.recyclerview.widget.RecyclerView.ViewHolder as ViewHolder1

class IemAdapter internal constructor(private val context: Context):BaseAdapter(){
    internal var iem = arrayListOf<IEM>()

    override fun getCount(): Int {
        return iem.size
    }
/**
 * dikotlin dapat di singkat seperti ini

        override fun getCount(): Int = iem.size

 */

    override fun getItem(position: Int): Any {
        return iem[position]
    }


/**
 *  di kotlin bisa disingkat seperti ini

        override fun getItem(position: Int): Any = iem[position]

 */



    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    /**
     * dikotlin dapat di persingkat seperti ini

            override fun getItemId(position: Int): Long:position.toLong()

     */

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_iem, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val iem = getItem(position) as IEM
        viewHolder.bind(iem)
        return itemView

    }

    private inner class ViewHolder internal constructor(private val view: View) {
//        private val txtName: TextView = view.findViewById(R.id.txt_name)
//        private val txtDescription: TextView = view.findViewById(R.id.txt_description)

        private val binding = ItemIemBinding.bind(view)

        /**
         *    photo kotak / normal
         *    private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)
         */

//        //circle photo
//        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(iem:IEM) {
            binding.txtName.text = iem.name
            binding.txtDescription.text = iem.price
            binding.imgPhoto.setImageResource(iem.photo)
        }
    }
}