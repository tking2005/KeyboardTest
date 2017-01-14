package nyc.c4q.tarynking.downloadimage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by tarynking on 1/11/17.
 */

public class SecondFragment extends AppCompatActivity {

    private ImageView imageView;
    private String urlKey;
    private int countOnBackPressed = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView= (ImageView) findViewById(R.id.frag_key_image);

        urlKey = getIntent().getStringExtra("keyString");

        Picasso.with(this)
                .load("http://jsjrobotics.nyc"+ urlKey)
                .into(imageView);

    }



    public void onBackPressed() {
        if (countOnBackPressed ==0){
        Toast.makeText(getBaseContext(), "Press once more to see list", Toast.LENGTH_SHORT).show();
        countOnBackPressed++;
        }else

            super.onBackPressed();
        }
}

