package getmore.com.getmore.vo;

import android.util.Log;

/**
 * Created by zhongqinng on 2/1/15.
 */
public class ShopVO {
    private String TAG = "ShopVO";
    private String id;
    private String name;
    private String short_desc;
    private String small_pict_url;

    public ShopVO(String id,
                  String name,
                  String short_desc,
                  String small_pict_url){
        this.id=id;
        this.name=name;
        this.short_desc=short_desc;
        this.small_pict_url=small_pict_url;
        Log.d(TAG,"ShopVO created: "
                +" id: "+id
                +" name: "+name
                +" short_desc: "+short_desc
                +" small_pict_url: "+small_pict_url);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getSmall_pict_url() {
        return small_pict_url;
    }

    public void setSmall_pict_url(String small_pict_url) {
        this.small_pict_url = small_pict_url;
    }
}
