package sulthon.com.iwaktrial.model;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Sulthon on 3/10/2017.
 */

public class LaporanHarian {

    private Context context;
    private String namaKolam;
    private boolean checkToDo1, checkToDo2;

    public LaporanHarian() {

    }

    public LaporanHarian(Context context, String namaKolam, boolean checkToDo1, boolean checkToDo2) {
        this.context = context;
        this.namaKolam = namaKolam;
        this.checkToDo1 = checkToDo1;
        this.checkToDo2 = checkToDo2;
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

    public boolean isCheckToDo1() {
        return checkToDo1;
    }

    public void setCheckToDo1(boolean checkToDo1) {
        this.checkToDo1 = checkToDo1;
    }

    public boolean isCheckToDo2() {
        return checkToDo2;
    }

    public void setCheckToDo2(boolean checkToDo2) {
        this.checkToDo2 = checkToDo2;
    }
}
