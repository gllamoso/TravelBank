package dev.gtcl.travelbank.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.gtcl.travelbank.data.network.service.ExpenseService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(OkHttpClient())
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()

    @Singleton
    @Provides
    fun expenseService(
        retrofit: Retrofit
    ): ExpenseService = retrofit.create(ExpenseService::class.java)
}