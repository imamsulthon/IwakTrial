package sulthon.com.iwaktrial.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sulthon.com.iwaktrial.R;
import sulthon.com.iwaktrial.adapater.LaporanHarianAdapater;
import sulthon.com.iwaktrial.model.LaporanHarian;

/**
 * Created by Sulthon on 3/10/2017.
 */

public class LaporanHarianMainFragment extends Fragment {

    private View view;
    private RecyclerView rvLaporanHarian;
    private LaporanHarianAdapater laporanHarianAdapater;
    private LaporanHarian laporanHarian;
    private List<LaporanHarian> laporanHarianList = new ArrayList<>();

    public LaporanHarianMainFragment() {

    }

    public static LaporanHarianMainFragment newInstance() {
        LaporanHarianMainFragment fragment = new LaporanHarianMainFragment();

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_laporan_harian, container, false);

        prepareView();

        loadDummyData();;

        laporanHarianAdapater = new LaporanHarianAdapater(laporanHarianList);
        rvLaporanHarian.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvLaporanHarian.setItemAnimator(new DefaultItemAnimator());
        rvLaporanHarian.setAdapter(laporanHarianAdapater);
        return view;
    }

    private void prepareView() {

        rvLaporanHarian = (RecyclerView) view.findViewById(R.id.rv_laporan_harian);
    }

    private void loadDummyData() {
        laporanHarian = new LaporanHarian(getContext(), "Kolam GR04", false, false);
        laporanHarianList.add(laporanHarian);

        laporanHarian = new LaporanHarian(getContext(), "Kolam GR05", false, false);
        laporanHarianList.add(laporanHarian);
    }
}
