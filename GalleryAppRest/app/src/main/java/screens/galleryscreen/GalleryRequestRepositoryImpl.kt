package screens.galleryscreen

import retrofit.models.RequestPhotosResponse
import retrofit.service.GetDataServiceAPI
import retrofit2.Response
import javax.inject.Inject

class GalleryRequestRepositoryImpl@Inject constructor(private val api:GetDataServiceAPI) : GalleryRequestRepository {
    override suspend fun getPhotos(): Response<RequestPhotosResponse> {
        val response = api.getPhotosandTexts()
        if(response.isSuccessful){
             response.body()
        }else{
            response.errorBody()
        }
        return  response
    }
}