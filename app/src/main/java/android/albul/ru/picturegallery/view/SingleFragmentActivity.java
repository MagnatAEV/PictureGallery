package android.albul.ru.picturegallery.view;

import android.albul.ru.picturegallery.R;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import moxy.MvpAppCompatActivity;

public abstract class SingleFragmentActivity extends MvpAppCompatActivity {

    protected abstract Fragment createFragment();

    protected Fragment picturesFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMainFragment();

    }

    private void initMainFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        picturesFragment = fragmentManager.findFragmentById(R.id.pictures_fragment);

        if (picturesFragment == null){
            picturesFragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.pictures_fragment, picturesFragment)
            .commit();
        }
    }


}
