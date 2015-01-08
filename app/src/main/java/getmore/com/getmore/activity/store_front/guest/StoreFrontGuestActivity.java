package getmore.com.getmore.activity.store_front.guest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import getmore.com.getmore.R;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.vo.ShopVO;

public class StoreFrontGuestActivity extends FragmentActivity {
    private StoreFrontGuestWebService storeFrontGuestWebService;
    private ShopVO shopVO;
    private AssetHandler ah;
    private ViewHolder vh;

    class ViewHolder{
        LinearLayout spinner_placeholder;
        LinearLayout btn_holder;
        SmartImageView top_banner_img;
        TextView name;
        TextView address;
        TextView hours;
        SmartImageView guest_promo_img;
        TextView tier1_name;
        TextView tier1_point;
        TextView tier2_name;
        TextView tier2_point;
        TextView tier3_name;
        TextView tier3_point;
        TextView tier4_name;
        TextView tier4_point;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.store_front_guest_a);
        storeFrontGuestWebService = new StoreFrontGuestWebService(this);
        ah = new AssetHandler(this);
        initialise_assets();
        String shop_id = intent.getStringExtra("shop_id");
        storeFrontGuestWebService.get_shop(shop_id);

    }

    public void initialise_assets(){
        vh = new ViewHolder();
        vh.spinner_placeholder = ah.linearLayoutHandler.set(this,R.id.spinner_placeholder);
        vh.btn_holder = ah.linearLayoutHandler.set(this,R.id.btn_holder);
        vh.top_banner_img = ah.smartImageViewHandler.set(this,R.id.top_banner_img);
        vh.name = ah.textViewHandler.set(this,R.id.name);
        vh.address =ah.textViewHandler.set(this,R.id.address);
        vh.hours=ah.textViewHandler.set(this,R.id.hours);
        vh.guest_promo_img=ah.smartImageViewHandler.set(this,R.id.guest_promo_img);
        vh.tier1_name=ah.textViewHandler.set(this,R.id.tier1_name);
        vh.tier1_point=ah.textViewHandler.set(this,R.id.tier1_point);
        vh.tier2_name=ah.textViewHandler.set(this,R.id.tier2_name);
        vh.tier2_point=ah.textViewHandler.set(this,R.id.tier2_point);
        vh.tier3_name=ah.textViewHandler.set(this,R.id.tier3_name);
        vh.tier3_point=ah.textViewHandler.set(this,R.id.tier3_point);
        vh.tier4_name=ah.textViewHandler.set(this,R.id.tier4_name);
        vh.tier4_point=ah.textViewHandler.set(this,R.id.tier4_point);

        ah.linearLayoutHandler.setVisible(vh.btn_holder,false);
    }

    public void setShopVO(ShopVO shopVO) {
        this.shopVO = shopVO;
        ah.linearLayoutHandler.setVisible(vh.spinner_placeholder, false);
        ah.linearLayoutHandler.setVisible(vh.btn_holder, true);

        set_asset();
    }

    private void set_asset(){
        if(shopVO!=null){
            if(shopVO.getTop_banner_url()!=null){
                ah.smartImageViewHandler.setImageURL(vh.top_banner_img,shopVO.getTop_banner_url());
            }
            if(shopVO.getName()!=null){
                ah.textViewHandler.setText(vh.name,shopVO.getName());
            }
            if(shopVO.getAddress()!=null){
                ah.textViewHandler.setText(vh.address,shopVO.getAddress());
            }
            if(shopVO.getHours()!=null){
                ah.textViewHandler.setText(vh.hours,shopVO.getHours());
            }
            if(shopVO.getGuest_promo_url()!=null){
                ah.smartImageViewHandler.setImageURL(vh.guest_promo_img,shopVO.getGuest_promo_url());
            }
            if(shopVO.getTier1_item()!=null){
                ah.textViewHandler.setText(vh.tier1_name,"~ "+shopVO.getTier1_item());
            }
            if(shopVO.getTier1_point_string()!=null){
                ah.textViewHandler.setText(vh.tier1_point,shopVO.getTier1_point_string());
            }
            if(shopVO.getTier2_item()!=null){
                ah.textViewHandler.setText(vh.tier2_name,"~ "+shopVO.getTier2_item());
            }
            if(shopVO.getTier2_point_string()!=null){
                ah.textViewHandler.setText(vh.tier2_point,shopVO.getTier2_point_string());
            }
            if(shopVO.getTier3_item()!=null){
                ah.textViewHandler.setText(vh.tier3_name,"~ "+shopVO.getTier3_item());
            }
            if(shopVO.getTier3_point_string()!=null){
                ah.textViewHandler.setText(vh.tier3_point,shopVO.getTier3_point_string());
            }
            if(shopVO.getTier4_item()!=null){
                ah.textViewHandler.setText(vh.tier4_name,"~ "+shopVO.getTier4_item());
            }
            if(shopVO.getTier4_point_string()!=null){
                ah.textViewHandler.setText(vh.tier4_point,shopVO.getTier4_point_string());
            }


        }
    }


}
