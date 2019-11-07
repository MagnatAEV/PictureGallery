package android.albul.ru.picturegallery.model;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoLoader {
    private Context context;

    public PicassoLoader(Context context) {
        this.context = context;
    }

    public void loadImage(String url, ImageView imageView){
        Picasso
                .get()
                .load(url)
                .into(imageView);
    }
}
