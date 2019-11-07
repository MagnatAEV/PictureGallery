package android.albul.ru.picturegallery.presenter;

import android.albul.ru.picturegallery.R;
import android.albul.ru.picturegallery.model.PicassoLoader;
import android.albul.ru.picturegallery.view.IntViewHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private IntRecyclerControl intRecyclerControl;
    private PicassoLoader picassoLoader;

    public RecyclerAdapter(Context context, IntRecyclerControl intRecyclerControl) {
        this.intRecyclerControl = intRecyclerControl;
        picassoLoader = new PicassoLoader(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.position = position;
        intRecyclerControl.bindView(viewHolder);
    }

    @Override
    public int getItemCount() {
        return intRecyclerControl.getItemCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements IntViewHolder {

        private int position = 0;

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view_item);
        }

        @Override
        public void setImage(String url) {
            picassoLoader.loadImage(url, imageView);
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
