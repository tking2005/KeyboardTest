package nyc.c4q.tarynking.downloadimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .replace(R.id.activity_main, new MainFragment())
                .commit();

//        imageView= (ImageView) findViewById(R.id.image_id);
//
//        Picasso.with(this)
//                .load("http://i.imgur.com/DvpvklR.png")
//                .into(imageView);
    }
}
