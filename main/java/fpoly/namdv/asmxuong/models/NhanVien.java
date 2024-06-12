package fpoly.namdv.asmxuong.models;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String manv;
    private String tenvn;
    private String tenpb;

    public NhanVien(String manv, String tenvn, String tenpb) {
        this.manv = manv;
        this.tenvn = tenvn;
        this.tenpb = tenpb;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTenvn() {
        return tenvn;
    }

    public void setTenvn(String tenvn) {
        this.tenvn = tenvn;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
}
