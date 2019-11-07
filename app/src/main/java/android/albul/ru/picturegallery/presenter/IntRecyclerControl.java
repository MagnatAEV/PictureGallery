package android.albul.ru.picturegallery.presenter;

import android.albul.ru.picturegallery.view.IntViewHolder;

public interface IntRecyclerControl {

    void bindView(IntViewHolder intViewHolder);
    int getItemCount();

}
