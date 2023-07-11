package com.example.websocket_fusedlocationprovider_demo.di


import com.example.websocket_fusedlocationprovider_demo.data.RealtimeBattleClient
import com.example.websocket_fusedlocationprovider_demo.data.RealtimeBattleClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @WSOkHttpClient
    @Singleton
    @Provides
    fun provideWSOkHttpClient(
        //authInterceptor: AuthInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.MINUTES)
        .writeTimeout(10, TimeUnit.MINUTES)
        .addInterceptor {
            it.proceed(
                it.request().newBuilder()
                    .header(
                        "Authorization",
                        "your--jwt--token"
                    )
                    .build()
            )
        }
        .build()

    @Singleton
    @Provides
    fun provideRealtimeBattleClient(@WSOkHttpClient httpClient: OkHttpClient): RealtimeBattleClient {
        return RealtimeBattleClientImpl(httpClient)
    }

}
