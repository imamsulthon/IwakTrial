package sulthon.com.iwaktrial.model;

import android.content.Context;

/**
 * Created by Sulthon on 3/9/2017.
 */

public class DataKolam {

    private Context context;
    private String namaKolam;
    private String jumlahPakanKg, jumlahPakanSak, jumlahKematian;

    public DataKolam() {
    }

    public DataKolam(Context context, String namaKolam, String jumlahPakanKg, String jumlahPakanSak, String jumlahKematian) {
        this.context = context;
        this.namaKolam = namaKolam;
        this.jumlahPakanKg = jumlahPakanKg;
        this.jumlahPakanSak = jumlahPakanSak;
        this.jumlahKematian = jumlahKematian;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getNamaKolam() {
        return namaKolam;
    }

    public void setNamaKolam(String namaKolam) {
        this.namaKolam = namaKolam;
    }

    public String getJumlahPakanKg() {
        return jumlahPakanKg;
    }

    public void setJumlahPakanKg(String jumlahPakanKg) {
        this.jumlahPakanKg = jumlahPakanKg;
    }

    public String getJumlahPakanSak() {
        return jumlahPakanSak;
    }

    public void setJumlahPakanSak(String jumlahPakanSak) {
        this.jumlahPakanSak = jumlahPakanSak;
    }

    public String getJumlahKematian() {
        return jumlahKematian;
    }

    public void setJumlahKematian(String jumlahKematian) {
        this.jumlahKematian = jumlahKematian;
    }
}