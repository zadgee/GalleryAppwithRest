package di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit.service.GetDataServiceAPI
import screens.galleryscreen.GalleryRequestRepository
import screens.galleryscreen.GalleryRequestRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    @ViewModelScoped
    fun providegalleryrepo(api:GetDataServiceAPI):GalleryRequestRepository{
        return GalleryRequestRepositoryImpl(
            api
        )
    }
    @Provides
    fun providecontext(app: Application): Context {
        return app
    }
}