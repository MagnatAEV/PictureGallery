package android.albul.ru.picturegallery.view;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

import android.albul.ru.picturegallery.R;
import android.albul.ru.picturegallery.presenter.PictureGalleryPresenter;
import android.albul.ru.picturegallery.presenter.RecyclerAdapter;
import android.albul.ru.picturegallery.view.fragments.PicturesFragment;

public class PictureGalleryActivity extends SingleFragmentActivity implements MainView {

    private RecyclerAdapter recyclerAdapter;

    RecyclerView recyclerView;

    @InjectPresenter
    PictureGalleryPresenter presenter;

    @ProvidePresenter
    public PictureGalleryPresenter providePresenter() {
        return new PictureGalleryPresenter();
    }


    public PictureGalleryActivity() {
        super();
        ButterKnife.bind(this);
        recyclerAdapter = new RecyclerAdapter(this, presenter.getRecyclerControl());
        ((PicturesFragment)picturesFragment).setRecyclerAdapter(recyclerAdapter);
    }

    @Override
    protected Fragment createFragment() {
        return PicturesFragment.newInstance();
    }


    @Override
    public void updateRecyclerView() {
        recyclerAdapter.notifyDataSetChanged();
    }
}
