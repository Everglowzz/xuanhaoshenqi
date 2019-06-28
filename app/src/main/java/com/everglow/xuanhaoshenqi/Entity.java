package com.everglow.xuanhaoshenqi;

/**
 * Created by Youga on 2015/7/1.
 */
public class Entity {


//    {"success":"true","ShowWeb":"1","PushKey":"","Url":"https://bxvip.oss-cn-zhangjiakou.aliyuncs.com/bxvip/androidapk/152caizy.apk"}
    private int code;
    private String message;
    private String url;
    private String savepath;
    private String last_id;
    private int a0;
    private String creditsid;
    private String ShowWeb;
    private String PushKey;
    private String Url;

    public String getShowWeb() {
        return ShowWeb;
    }

    public String getPushKey() {
        return PushKey;
    }

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    private APPCONFIG AppConfig;

    public APPCONFIG getAppConfig() {
        return AppConfig;
    }

    public static class APPCONFIG {
        private String ShowWeb;

        public String getShowWeb() {
            return ShowWeb == null ? "" : ShowWeb;
        }

        public String getUrl() {
            return Url == null ? "" : Url;
        }

        private String Url;
    }

    public String getCreditsid() {
        return creditsid == null ? "" : creditsid;
    }

    private int a1;
    private String signplaceid;
    private String orderauthid;

    public String getOrderauthid() {
        return orderauthid == null ? "" : orderauthid;
    }

    public void setOrderauthid(String orderauthid) {
        this.orderauthid = orderauthid;
    }

    public Entity() {
    }

    public Entity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getA0() {
        return a0;
    }

    public int getA1() {
        return a1;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return Url;
    }

    public String getSavepath() {
        return savepath;
    }

    public String getLast_id() {
        return last_id;
    }

    public String getSignplaceid() {
        return signplaceid;
    }
}
