package android.albul.ru.picturegallery.view.fragments;

import android.albul.ru.picturegallery.R;
import android.albul.ru.picturegallery.presenter.PictureGalleryPresenter;
import android.albul.ru.picturegallery.presenter.RecyclerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PicturesFragment extends Fragment {

    private RecyclerView picturesRecyclerView;

    private RecyclerAdapter recyclerAdapter;

    public void setRecyclerAdapter(RecyclerAdapter recyclerAdapter) {
        this.recyclerAdapter = recyclerAdapter;
    }


    public static Fragment newInstance() {
        return  new PicturesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); //удеражание фрагмента;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.pictures_fragment, container, false);
       picturesRecyclerView = (RecyclerView) v.findViewById(R.id.pictures_fragment);
       picturesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
       picturesRecyclerView.setAdapter(recyclerAdapter);
       return v;
    }
}
