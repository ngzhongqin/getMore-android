package getmore.com.getmore.vo;

import android.util.Log;

import java.util.Date;

/**
 * Created by zhongqinng on 12/1/15.
 */
public class NewsItemVO {
    private String TAG = "NewsItemVO";
    private String text;
    private Date createdAt;

    public NewsItemVO(String text, Date createdAt){
        this.text=text;
        this.createdAt=createdAt;
        Log.i(TAG,"NewsItemVO created: "
                + "text: "+text
                + "Date: "+createdAt);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
