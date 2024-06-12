package fpoly.namdv.asmxuong.models;

public class PhongBan {
    private String mapb;
    private String tenpb;

    public PhongBan(String mapb, String tenpb){
        this.mapb=mapb;
        this.tenpb=tenpb;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
}
