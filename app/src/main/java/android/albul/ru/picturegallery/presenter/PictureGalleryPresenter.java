package android.albul.ru.picturegallery.presenter;

import android.albul.ru.picturegallery.model.Hit;
import android.albul.ru.picturegallery.model.Picture;
import android.albul.ru.picturegallery.model.retrofit.ApiHelper;
import android.albul.ru.picturegallery.view.IntViewHolder;
import android.albul.ru.picturegallery.view.MainView;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.MvpPresenter;

import static android.content.ContentValues.TAG;

public class PictureGalleryPresenter extends MvpPresenter<MainView> {

    RecyclerControl recyclerControl;
    List<Hit> hits;
    private ApiHelper apiHelper;

    public PictureGalleryPresenter() {
        recyclerControl = new RecyclerControl();
        apiHelper = new ApiHelper();
    }

    @Override
    protected void onFirstViewAttach()
    {
        getAllPictures();
    }

    public void getAllPictures() {
        Observable<Picture> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(pictures -> {
            hits = pictures.hits;
            getViewState().updateRecyclerView();

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    public RecyclerControl getRecyclerControl() {
        return recyclerControl;
    }

    private class RecyclerControl implements IntRecyclerControl {

        @Override
        public void bindView(IntViewHolder intViewHolder) {
            intViewHolder.setImage(hits.get(intViewHolder.getPos()).webformatURL);
        }

        @Override
        public int getItemCount() {
            if (hits != null) {
                return hits.size();
            }
            return 0;
        }
    }

}
