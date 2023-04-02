package screens.galleryscreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapprest.R
import retrofit.models.RequestPhotosResponseItem
import javax.inject.Inject


class GalleryRecyclerView@Inject constructor(private val view: View):RecyclerView.Adapter<GalleryRecyclerView.GalleryViewHolder>() {

    var listwithelements =ArrayList<RequestPhotosResponseItem>()
    class GalleryViewHolder(view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_layout,parent,false)
        return GalleryViewHolder(view)
    }

    override fun getItemCount(): Int = listwithelements.size




    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
      holder.itemView.findViewById<TextView>(R.id.author).text = listwithelements[position].user.username
        holder.itemView.findViewById<TextView>(R.id.titleforphoto).text = listwithelements[position].alt_description
        Glide.with(view).load(listwithelements[position].urls.small).into(holder.itemView.findViewById(R.id.imageforrest))

holder.itemView.findViewById<ImageView>(R.id.imageforrest).setOnClickListener{
    val image = listwithelements[position].urls.regular
    val action = GalleryListFragmentDirections.actionGalleryListFragmentToPhotoFragment(image)
    view.findNavController().navigate(action)
}




    }
    fun createlistwithphotos(list: List<RequestPhotosResponseItem>){
        listwithelements.addAll(list)
        notifyDataSetChanged()
    }

    }