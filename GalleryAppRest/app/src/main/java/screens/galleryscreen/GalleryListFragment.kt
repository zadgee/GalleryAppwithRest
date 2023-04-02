package screens.galleryscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galleryapprest.R
import com.example.galleryapprest.databinding.FragmentGalleryListBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit.models.RequestPhotosResponseItem
import retrofit.models.Urls

@AndroidEntryPoint
class GalleryListFragment : Fragment() {
    lateinit var adapter:GalleryRecyclerView
private lateinit var binding : FragmentGalleryListBinding
private val viewmodel by viewModels<GalleryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentGalleryListBinding.inflate(inflater)
return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = GalleryRecyclerView(view)
        binding.listforgallery.layoutManager = LinearLayoutManager(context)
        binding.listforgallery.adapter = adapter
        viewmodel.getPhotosGallery()
        viewmodel.photostate.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.createlistwithphotos(it) }
        }

    }
}