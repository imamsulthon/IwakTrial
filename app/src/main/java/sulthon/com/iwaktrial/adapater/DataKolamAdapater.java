package sulthon.com.iwaktrial.adapater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sulthon.com.iwaktrial.R;
import sulthon.com.iwaktrial.model.DataKolam;

/**
 * Created by Sulthon on 3/9/2017.
 */

public class DataKolamAdapater extends RecyclerView.Adapter<DataKolamAdapater.MyViewHolder> {

    private List<DataKolam> dataKolamList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaKolam, jumlahPakanKg, jumlahPakanSak, jumlahKematian;

        public MyViewHolder(View view) {
            super(view);

            tvNamaKolam = (TextView) view.findViewById(R.id.tv_laporan_label_namakolam);
            jumlahPakanKg = (TextView) view.findViewById(R.id.tv_datakolam_jumlahpakan_kg);
            jumlahPakanSak = (TextView) view.findViewById(R.id.tv_datakolam_jumlahpakan_sak);
            jumlahKematian = (TextView) view.findViewById(R.id.tv_dataKolam_jumlahKematian);
        }
    }

    public DataKolamAdapater(List<DataKolam> dataKolamList) {
        this.dataKolamList = dataKolamList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data_kolam, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        DataKolam dataKolam = dataKolamList.get(position);

        holder.tvNamaKolam.setText(dataKolam.getNamaKolam());
        holder.jumlahPakanKg.setText(dataKolam.getJumlahPakanKg());
        holder.jumlahPakanSak.setText(dataKolam.getJumlahPakanSak());
        holder.jumlahKematian.setText(dataKolam.getJumlahKematian());
    }

    @Override
    public int getItemCount() {
        return dataKolamList.size();
    }
}
