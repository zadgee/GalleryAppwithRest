package screens.galleryscreen

import retrofit.models.RequestPhotosResponse
import retrofit2.Response

interface GalleryRequestRepository {
    suspend fun getPhotos():Response<RequestPhotosResponse>
}