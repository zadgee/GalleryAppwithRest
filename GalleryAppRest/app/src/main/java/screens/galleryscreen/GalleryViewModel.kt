package screens.galleryscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit.models.RequestPhotosResponse
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel@Inject constructor(private val repository: GalleryRequestRepository):ViewModel()
{
    private val _photostate  = MutableLiveData<Response<RequestPhotosResponse>>()
    val photostate : LiveData<Response<RequestPhotosResponse>> = _photostate

    fun getPhotosGallery(){
       viewModelScope.launch {
           try {
               _photostate.value = repository.getPhotos()
           }catch (e:Exception){
               Log.e("Response was unsuccessful","Something went wrong")
           }
       }
    }

}