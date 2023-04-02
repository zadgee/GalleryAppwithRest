package retrofit.service

import retrofit.models.RequestPhotosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface GetDataServiceAPI {
    @GET("photos?client_id=896d4f52c589547b2134bd75ed48742db637fa51810b49b607e37e46ab2c0043")
    @Headers("Authorization:896d4f52c589547b2134bd75ed48742db637fa51810b49b607e37e46ab2c0043")
    suspend fun getPhotosandTexts():Response<RequestPhotosResponse>
}