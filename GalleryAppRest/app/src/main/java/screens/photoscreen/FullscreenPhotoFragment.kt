package screens.photoscreen
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.galleryapprest.R
import com.example.galleryapprest.databinding.FragmentFullscreenPhotoBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FullscreenPhotoFragment : Fragment() {
   private lateinit var binding : FragmentFullscreenPhotoBinding
private val args:FullscreenPhotoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentFullscreenPhotoBinding.inflate(inflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_photoFragment_to_galleryListFragment)
        }

        Glide.with(this).load(args.imageURL).into(binding.fullscreenimage)

}
}