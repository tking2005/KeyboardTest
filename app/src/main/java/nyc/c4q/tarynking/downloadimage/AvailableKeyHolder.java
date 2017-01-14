package nyc.c4q.tarynking.downloadimage;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.tarynking.downloadimage.models.AvailableKey;

/**
 * Created by tarynking on 1/11/17.
 */
public class AvailableKeyHolder extends RecyclerView.ViewHolder {

    private TextView keyNameTv;
    private int keyTextColor;
    private String keyUrl;
    private Fragment fragment;

    public AvailableKeyHolder(ViewGroup parent) {
        super(inflateView(parent));
        keyNameTv = (TextView) itemView.findViewById(R.id.vh_letter_name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.letter_item_layout, parent, false);
    }

   public void bind(final AvailableKey availableKey) {
        keyNameTv.setText(availableKey.getName());
        keyTextColor = Color.parseColor(availableKey.getTextColor());
        keyNameTv.setTextColor(keyTextColor);
        keyUrl = availableKey.getUrl();


        itemView.setOnClickListener(new View.OnClickListener() { //itemview is the parent view of the viewholder...this is the view

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(itemView.getContext(), SecondActivity.class);
                intent.putExtra("keyString", keyUrl);
                itemView.getContext().startActivity(intent);


            }


        });
    }
}




