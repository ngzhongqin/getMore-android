package getmore.com.getmore.fragment.home.favourite;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import getmore.com.getmore.R;
import getmore.com.getmore.activity.store_front.guest.StoreFrontGuestActivity;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.vo.ShopVO;


/***
 * ADAPTER
 */

public class FavShopAdapter extends ArrayAdapter<ShopVO> {

    private static final String TAG = "FavShopAdapter";
    private ViewHolder vh;
    private Context context;
    private FragmentActivity mActivity;
    private AssetHandler assetHandler;
    static class ViewHolder {
        TextView name;
        TextView short_desc;
        ImageView photo;
        Button shop_btn;
        TextView points;
    }

    private final LayoutInflater mLayoutInflater;

    public FavShopAdapter(FragmentActivity mActivity, final Context context, final int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
        this.mActivity=mActivity;
        mLayoutInflater = LayoutInflater.from(context);
        assetHandler = new AssetHandler(mActivity);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Log.i(TAG,"get View -> OrdersItemAdapter:"+getItem(position).getId());
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.home_i_favshop, parent, false);
            vh = new ViewHolder();

            vh.name = assetHandler.textViewHandler.set(convertView,R.id.name);
            vh.short_desc = assetHandler.textViewHandler.set(convertView,R.id.short_desc);
            vh.photo = assetHandler.imageViewHandler.set(convertView,R.id.photo);
            vh.shop_btn = assetHandler.buttonHandler.set(convertView,R.id.shop_btn);
            vh.points = assetHandler.textViewHandler.set(convertView,R.id.points);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        if(getItem(position)!=null) {
            assetHandler.textViewHandler.setText(vh.name, getItem(position).getName());
            assetHandler.textViewHandler.setText(vh.points,getItem(position).getPointsString());
            assetHandler.textViewHandler.setText(vh.short_desc, getItem(position).getShort_desc());
            assetHandler.imageViewHandler.setRoundImage(vh.photo,getItem(position).getSmall_pict_url());
            vh.shop_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if(getItem(position)!=null) {
                        navigator_to_store_guest(getItem(position).getId());
                    }
                }
            });
        }
        return convertView;
    }

    private void navigator_to_store_guest(String shop_id){
        Intent myIntent = new Intent(mActivity, StoreFrontGuestActivity.class);
        myIntent.putExtra("shop_id", shop_id); //Optional parameters
        mActivity.startActivity(myIntent);
    }
}