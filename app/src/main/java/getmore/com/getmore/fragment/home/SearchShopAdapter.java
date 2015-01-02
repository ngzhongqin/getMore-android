package getmore.com.getmore.fragment.home;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import getmore.com.getmore.R;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.vo.ShopVO;


/***
 * ADAPTER
 */

public class SearchShopAdapter extends ArrayAdapter<ShopVO> {

    private static final String TAG = "ShopAdapter";
    private ViewHolder vh;
    private Context context;
    private AssetHandler assetHandler;
    static class ViewHolder {
        TextView name;
        TextView short_desc;
        ImageView photo;

    }

    private final LayoutInflater mLayoutInflater;

    public SearchShopAdapter(FragmentActivity fragmentActivity, final Context context, final int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        assetHandler = new AssetHandler(fragmentActivity);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Log.i(TAG,"get View -> OrdersItemAdapter:"+getItem(position).getId());
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.home_i_searchshop, parent, false);
            vh = new ViewHolder();

            vh.name = assetHandler.textViewHandler.set(convertView,R.id.name);
            vh.short_desc = assetHandler.textViewHandler.set(convertView,R.id.short_desc);
            vh.photo = assetHandler.imageViewHandler.set(convertView,R.id.photo);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        if(getItem(position)!=null) {
            assetHandler.textViewHandler.setText(vh.name, getItem(position).getName());
            assetHandler.textViewHandler.setText(vh.short_desc, getItem(position).getShort_desc());
            assetHandler.imageViewHandler.setRoundImage(vh.photo,getItem(position).getSmall_pict_url());
        }
        return convertView;
    }
}