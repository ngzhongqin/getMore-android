package getmore.com.getmore.util.assetSetter;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class AssetSetter {
    private String TAG = "AssetSetter";
    public FrameLayoutSetter frameLayoutSetter;
    public ImageButtonSetter imageButtonSetter;
    public LinearLayoutSetter linearLayoutSetter;
    public TextViewSetter textViewSetter;

    public AssetSetter(){
        frameLayoutSetter=new FrameLayoutSetter();
        imageButtonSetter=new ImageButtonSetter();
        linearLayoutSetter=new LinearLayoutSetter();
        textViewSetter=new TextViewSetter();
    }
}
