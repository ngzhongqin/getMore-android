package getmore.com.getmore.vo;

import android.util.Log;

import com.parse.ParseGeoPoint;

import java.text.DecimalFormat;

/**
 * Created by zhongqinng on 2/1/15.
 */
public class ShopVO {
    private String TAG = "ShopVO";
    private String id;
    private String name;
    private String short_desc;
    private String small_pict_url;
    private Number numberOfMembers;
    private String numberOfMembersString;
    private ParseGeoPoint location;
    private Number distance;
    private String distanceString;

    private String address;
    private String hours;
    private String top_banner_url;
    private String guest_promo_url;
    private String tier1_item;
    private Number tier1_point;
    private String tier2_item;
    private Number tier2_point;
    private String tier3_item;
    private Number tier3_point;
    private String tier4_item;
    private Number tier4_point;
    private Number points;
    private String member_promo_url;
    private String member_promo_text;

    public ShopVO(String id,
                  String name,
                  String address,
                  String hours,
                  String top_banner_url,
                  String tier1_item,
                  Number tier1_point,
                  String tier2_item,
                  Number tier2_point,
                  String tier3_item,
                  Number tier3_point,
                  String tier4_item,
                  Number tier4_point){

        this.id=id;
        this.name=name;
        this.address=address;
        this.hours=hours;
        this.top_banner_url=top_banner_url;
        this.tier1_item=tier1_item;
        this.tier1_point=tier1_point;
        this.tier2_item=tier2_item;
        this.tier2_point=tier2_point;
        this.tier3_item=tier3_item;
        this.tier3_point=tier3_point;
        this.tier4_item=tier4_item;
        this.tier4_point=tier4_point;

        Log.i(TAG,"ShopVO created: "
                +" id: "+id
                +" name: "+name
                +" address: "+address
                +" hours: "+hours
                +" top_banner_url: "+top_banner_url
                +" tier1_item: "+tier1_item
                +" tier1_point: "+tier1_point
                +" tier2_item: "+tier2_item
                +" tier2_point: "+tier2_point
                +" tier3_item: "+tier3_item
                +" tier3_point: "+tier3_point
                +" tier4_item: "+tier4_item
                +" tier4_point: "+tier4_point
        );
    }

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
        String mShort_desc = null;
        if(short_desc!=null){
            if(!short_desc.isEmpty()){
                mShort_desc = "# "+short_desc;
            }
        }
        return mShort_desc;
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

    public void setNumberOfMembers(Number numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public Number getNumberOfMembers() {
        return numberOfMembers;
    }

    public String getNumberOfMembersString() {
        String returnString = null;
        DecimalFormat format=new DecimalFormat("###,###,###");
        if(numberOfMembers!=null){
            try{
//                int number = (int) Double.parseDouble(numberOfMembers.toString());
                String number_string = format.format(numberOfMembers);
                returnString = "~ "+ number_string+" Members";
            }catch (Exception e){
                Log.e(TAG,"getNumberOfMembersString: EXCEPTION: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return returnString;
    }

    public ParseGeoPoint getLocation() {
        return location;
    }

    public void setLocation(ParseGeoPoint location) {
//        Log.i(TAG,"location.getLatitude: "+location.getLatitude()+"location.getLongitude:"+location.getLongitude());
        this.location = location;
    }

    public Number getDistance() {
        return distance;
    }

    public void setDistance(Number distance) {
        Log.i(TAG,"setDistance: "+distance);
        this.distance = distance;
    }

    public String getDistanceString() {
        String returnString = null;

        if(distance!=null){
            if(distance.doubleValue()<1){
                try{
                    DecimalFormat format=new DecimalFormat("###");
                    Double mDistance = ((Double)distance)*1000;
                    returnString = format.format(mDistance);
                    returnString = "~ "+ returnString+"m away";
                }catch (Exception e){
                    Log.e(TAG,"getDistanceString: Less than 1 km EXCEPTION: "+e.getMessage());
                    e.printStackTrace();
                }
            }else{
                try{
                    DecimalFormat format=new DecimalFormat("###,###,###.##");
                    returnString = format.format(distance);
                    returnString = "~ "+ returnString+"km away";
                }catch (Exception e){
                    Log.e(TAG,"getDistanceString: more than 1 km EXCEPTION: "+e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return returnString;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getTop_banner_url() {
        return top_banner_url;
    }

    public void setTop_banner_url(String top_banner_url) {
        this.top_banner_url = top_banner_url;
    }

    public String getGuest_promo_url() {
        return guest_promo_url;
    }

    public void setGuest_promo_url(String guest_promo_url) {
        this.guest_promo_url = guest_promo_url;
    }

    public String getTier1_item() {
        return tier1_item;
    }

    public void setTier1_item(String tier1_item) {
        this.tier1_item = tier1_item;
    }

    public Number getTier1_point() {
        return tier1_point;
    }

    public void setTier1_point(Number tier1_point) {
        this.tier1_point = tier1_point;
    }

    public String getTier2_item() {
        return tier2_item;
    }

    public void setTier2_item(String tier2_item) {
        this.tier2_item = tier2_item;
    }

    public Number getTier2_point() {
        return tier2_point;
    }

    public void setTier2_point(Number tier2_point) {
        this.tier2_point = tier2_point;
    }

    public String getTier3_item() {
        return tier3_item;
    }

    public void setTier3_item(String tier3_item) {
        this.tier3_item = tier3_item;
    }

    public Number getTier3_point() {
        return tier3_point;
    }

    public void setTier3_point(Number tier3_point) {
        this.tier3_point = tier3_point;
    }

    public String getTier4_item() {
        return tier4_item;
    }

    public void setTier4_item(String tier4_item) {
        this.tier4_item = tier4_item;
    }

    public Number getTier4_point() {
        return tier4_point;
    }

    public void setTier4_point(Number tier4_point) {
        this.tier4_point = tier4_point;
    }

    public String getTier1_point_string() {
        return to_point_string(tier1_point);
    }

    public String getTier2_point_string() {
        return to_point_string(tier2_point);
    }

    public String getTier3_point_string() {
        return to_point_string(tier3_point);
    }

    public String getTier4_point_string() {
        return to_point_string(tier4_point);
    }

    private String to_point_string(Number number){
        String rtnString = null;
        if(tier1_point!=null){
            try{
                Number point_number = number.intValue();
                rtnString = point_number.toString()+ " pts";
            }catch (Exception e){
                Log.e(TAG,"getTier1_point_string EXCEPTION: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return rtnString;
    }

    public void setPoints(Number points) {
        Log.i(TAG,"setPoints: "+points);
        this.points = points;
    }

    public String getPointsString(){
        String returnString = null;
        if(this.points!=null){
            try{
                returnString = "~"+points.intValue() + " pts";
            }catch (Exception e){
                Log.e(TAG,"getPointsString: EXCEPTION: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return returnString;
    }

    public void setMember_promo_url(String member_promo_url) {
        Log.i(TAG,"setMember_promo_url: "+member_promo_url);
        this.member_promo_url=member_promo_url;
    }

    public String getMember_promo_url() {
        return member_promo_url;
    }

    public void setMember_promo_text(String member_promo_text) {
        Log.i(TAG,"setMember_promo_text: "+member_promo_text);
        this.member_promo_text=member_promo_text;
    }

    public String getMember_promo_text() {
        return member_promo_text;
    }
}
