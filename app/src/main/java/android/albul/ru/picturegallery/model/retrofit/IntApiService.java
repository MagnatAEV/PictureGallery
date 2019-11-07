package android.albul.ru.picturegallery.model.retrofit;

import android.albul.ru.picturegallery.model.Picture;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IntApiService {
    @GET("api")
    Observable<Picture> getPicture(@Query("key") String key);
}
