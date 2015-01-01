package getmore.com.getmore.fragment.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import getmore.com.getmore.R;
import getmore.com.getmore.background.DownloadRoundImage;
import getmore.com.getmore.vo.ShopVO;


/***
 * ADAPTER
 */

public class SearchShopAdapter extends ArrayAdapter<ShopVO> {

    private static final String TAG = "ShopAdapter";
    private ViewHolder vh;
    private Context context;
    static class ViewHolder {
        TextView name;
        TextView short_desc;
        ImageView photo;

    }

    private final LayoutInflater mLayoutInflater;

    public SearchShopAdapter(final Context context, final int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Log.i(TAG,"get View -> OrdersItemAdapter:"+getItem(position).getId());
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.home_i_searchshop, parent, false);
            vh = new ViewHolder();
            vh.name = (TextView) convertView.findViewById(R.id.name);
            vh.short_desc = (TextView) convertView.findViewById(R.id.short_desc);
            vh.photo = (ImageView) convertView.findViewById(R.id.photo);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.name.setText(getItem(position).getName());
        vh.short_desc.setText(getItem(position).getShort_desc());
        new DownloadRoundImage(vh.photo).execute(getItem(position).getSmall_pict_url());

        return convertView;
    }
}