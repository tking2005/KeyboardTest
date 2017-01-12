package nyc.c4q.tarynking.downloadimage;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.tarynking.downloadimage.models.AvailableKey;
import nyc.c4q.tarynking.downloadimage.models.KeyList;
import nyc.c4q.tarynking.downloadimage.networks.AvailableKeyApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tarynking on 1/11/17.
 */

public class MainFragment extends Fragment {

    private View rootView;
    private static final String BASE_URL = "http://jsjrobotics.nyc/";
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new KeyAdapter());

        //retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AvailableKeyApi api = retrofit.create(AvailableKeyApi.class);

        Call<KeyList> call = api.getAvailableKeys();
        call.enqueue(new Callback<KeyList>() {
            @Override
            public void onResponse(Call<KeyList> call, Response<KeyList> response) {
                KeyList model = response.body();
                List<AvailableKey> houses = model.getAvailableKeys();
                KeyAdapter adapter = (KeyAdapter) recyclerView.getAdapter();
                adapter.setData(houses);
            }

            @Override
            public void onFailure(Call<KeyList> call, Throwable t) {

            }
        });

    }



}
