package co.id.movieapp.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.id.movieapp.CoreApp;
import co.id.movieapp.R;
import co.id.movieapp.data.ResultData;
import co.id.movieapp.di.module.MainActivityModule;
import co.id.movieapp.helper.Constant;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {
    @Inject
    DetailPresenter detailPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.desc)
    TextView mTextView;

    private DetailContract.UserActionListener mUserActionListener;
    private ResultData mMovie;
    private boolean mIsInFavorites = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupActivityComponent();
        mUserActionListener = detailPresenter;
        detailPresenter.setView(this);
        initializeData();
    }

    private void setupActivityComponent() {
        CoreApp.get()
                .getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }

    public void initializeData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(Constant.MOVIE_DETAIL)) {
                Bundle b = intent.getBundleExtra(Constant.MOVIE_DETAIL);
                mMovie = b.getParcelable(Constant.MOVIE_DETAIL);

                Picasso.with(this)
                        .load(Constant.URL_IMAGE + mMovie.getBackdropPath())
                        .into(mImage);

                mTextView.setText(mMovie.getOverview());
                toolbar.setTitle(mMovie.getTitle());
                setSupportActionBar(toolbar);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
