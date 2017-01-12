package nyc.c4q.tarynking.downloadimage.networks;

import nyc.c4q.tarynking.downloadimage.models.KeyList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tarynking on 1/11/17.
 */

public interface AvailableKeyApi {
    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<KeyList> getAvailableKeys();
}
