package br.com.moryta.imagedownloader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ivImage)
    ImageView ivImage;

    private final static String URL = "https://previews.123rf.com/images/iqoncept/iqoncept1412/iqoncept141200074/34515342-Job-Well-Done-words-in-red-stamp-to-illustrate-a-good-review-for-a-job-task-or-project-completed-to--Stock-Photo.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btDownload)
    public void onClick() {
        if (ContextCompat.checkSelfPermission(this
                , Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    100);
        } else {
            downloadImage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        downloadImage();
    }

    private void downloadImage() {
        Picasso.with(this)
                .load(this.URL)
                .into(ivImage);
    }
}
