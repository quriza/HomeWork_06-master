package otus.homework.reactivecats

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CatsApiClient {
    private const val BASE_URL = "https://cat-fact.herokuapp.com/facts/"
    private const val CONNECT_TIMEOUT_SEC = 5L
    private const val READ_TIMEOUT_SEC = 5L
    private const val WRITE_TIMEOUT_SEC = 5L


    val apiClient: CatsService by lazy {
        val client = OkHttpClient.Builder()
        client.connectTimeout(this.CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
        client.readTimeout(this.READ_TIMEOUT_SEC, TimeUnit.SECONDS)
        client.writeTimeout(this.WRITE_TIMEOUT_SEC, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
            .baseUrl(this.BASE_URL)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return@lazy retrofit.create(CatsService::class.java)
    }

}
