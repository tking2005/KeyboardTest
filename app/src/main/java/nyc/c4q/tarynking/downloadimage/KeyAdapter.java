package nyc.c4q.tarynking.downloadimage;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.tarynking.downloadimage.models.AvailableKey;

/**
 * Created by tarynking on 1/11/17.
 */

public class KeyAdapter extends RecyclerView.Adapter {
    private List<AvailableKey> availableKeys = new ArrayList<>(10);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AvailableKeyHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AvailableKeyHolder availableKeyHolder = (AvailableKeyHolder) holder;

        AvailableKey availableKey = availableKeys.get(position);
        availableKeyHolder.bind(availableKey);

    }

    @Override
    public int getItemCount() {
//        return availableKeys.size();
        return 10;
    }

    public void setData(List<AvailableKey> availableKeys1){
        this.availableKeys = availableKeys1;
        notifyDataSetChanged();
    }
}





