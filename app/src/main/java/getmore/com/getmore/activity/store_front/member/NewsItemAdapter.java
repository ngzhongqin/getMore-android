package getmore.com.getmore.activity.store_front.member;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import getmore.com.getmore.R;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.vo.NewsItemVO;


/***
 * ADAPTER
 */

public class NewsItemAdapter extends ArrayAdapter<NewsItemVO> {

    private static final String TAG = "NewsItemAdapter";
    private ViewHolder vh;
    private Context context;
    private FragmentActivity mActivity;
    private AssetHandler assetHandler;
    static class ViewHolder {
        TextView text;
    }

    private final LayoutInflater mLayoutInflater;

    public NewsItemAdapter(FragmentActivity mActivity, final Context context, final int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
        this.mActivity=mActivity;
        mLayoutInflater = LayoutInflater.from(context);
        assetHandler = new AssetHandler(mActivity);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.store_front_member_i_news_item, parent, false);
            vh = new ViewHolder();

            vh.text = assetHandler.textViewHandler.set(convertView,R.id.text);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        if(getItem(position)!=null) {
            assetHandler.textViewHandler.setText(vh.text, getItem(position).getText());
        }
        return convertView;
    }
}