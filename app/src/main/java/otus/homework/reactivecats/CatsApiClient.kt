package otus.homework.reactivecats

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object CatsApiClient {
        private const val BASE_URL = "https://cat-fact.herokuapp.com/facts/"

        val apiClient: CatsService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(this.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
            return@lazy retrofit.create(CatsService::class.java)
        }

}
