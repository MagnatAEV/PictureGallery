package android.albul.ru.picturegallery;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment picturesFragment = fragmentManager.findFragmentById(R.id.pictures_fragment);

        if (picturesFragment == null){
            picturesFragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.pictures_fragment, picturesFragment)
            .commit();
        }

    }
}
