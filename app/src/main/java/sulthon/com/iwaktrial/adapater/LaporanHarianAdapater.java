package sulthon.com.iwaktrial.adapater;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import sulthon.com.iwaktrial.R;
import sulthon.com.iwaktrial.activity.HomeActivity;
import sulthon.com.iwaktrial.model.LaporanHarian;

/**
 * Created by Sulthon on 3/10/2017.
 */

public class LaporanHarianAdapater extends RecyclerView.Adapter<LaporanHarianAdapater.MyViewHolder>  {

    private List<LaporanHarian> laporanHarianList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaKolam;
        public Button simpanJumlahPakan, simpanJumlahKematian;

        public MyViewHolder(View view) {
            super(view);

            namaKolam = (TextView) view.findViewById(R.id.tv_laporan_label_namakolam);
            simpanJumlahPakan = (Button) view.findViewById(R.id.btn_harian1_simpan_jumlahPakan);
            simpanJumlahKematian = (Button) view.findViewById(R.id.btn_simpan_jumlahKematian);

        }
    }

    public LaporanHarianAdapater(List<LaporanHarian> laporanHarianList) {
        this.laporanHarianList = laporanHarianList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_laporan_harian, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        LaporanHarian laporanHarian = laporanHarianList.get(position);

        holder.namaKolam.setText(laporanHarian.getNamaKolam());

        holder.simpanJumlahPakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt(HomeActivity.Key_CHANGE_FRAGMENT, 1);
                EventBus.getDefault().post(bundle);

            }
        });

        holder.simpanJumlahKematian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt(HomeActivity.Key_CHANGE_FRAGMENT, 2);
                EventBus.getDefault().post(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return laporanHarianList.size();
    }

}
