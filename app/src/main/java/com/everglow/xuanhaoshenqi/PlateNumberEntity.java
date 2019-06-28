package com.everglow.xuanhaoshenqi;
/**
 * Created by EverGlow on 2019/5/24 15:33
 */
public    class PlateNumberEntity   {
    public PlateNumberEntity(String area, String numpre) {
        this.area = area;
        this.numpre = numpre;
    }

    public String area;
    public String numpre;

    public String getArea() {
        return area == null ? "" : area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumpre() {
        return numpre == null ? "" : numpre;
    }

    public void setNumpre(String numpre) {
        this.numpre = numpre;
    }
}
