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
        }
    }


}
