package nyc.c4q.tarynking.downloadimage.models;

import java.util.List;

/**
 * Created by tarynking on 1/11/17.
 */
public class KeyList {


    private Boolean success;

    private List<AvailableKey> availableKeys = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<AvailableKey> getAvailableKeys() {
        return availableKeys;
    }

    public void setAvailableKeys(List<AvailableKey> availableKeys) {
        this.availableKeys = availableKeys;
    }

}
