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
import sulthon.com.iwaktrial.adapater.DataKolamAdapater;
import sulthon.com.iwaktrial.model.DataKolam;

/**
 * Created by Sulthon on 3/7/2017.
 */

public class DataKolamFragment extends Fragment{

    private View view;
    private RecyclerView rvDataKolam;
    private DataKolamAdapater dataKolamAdapater;
    private List<DataKolam> dataKolamList = new ArrayList<>();
    private DataKolam dataKolam;

    public DataKolamFragment() {
    }

    public static DataKolamFragment newInstance() {
        DataKolamFragment fragment = new DataKolamFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_kolam, container, false);

        prepareView();

        loadDummyData();

        dataKolamAdapater = new DataKolamAdapater(dataKolamList);
        rvDataKolam.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDataKolam.setItemAnimator(new DefaultItemAnimator());
        rvDataKolam.setAdapter(dataKolamAdapater);
        return view;
    }

    private void prepareView() {
        rvDataKolam = (RecyclerView) view.findViewById(R.id.rv_datakolam);
    }

    private void loadDummyData() {
        dataKolam = new DataKolam(getContext(), "Kolam GR01", "999", "99", "9");
        dataKolamList.add(dataKolam);

        dataKolam = new DataKolam(getContext(), "Kolam GR02", "666", "66", "6");
        dataKolamList.add(dataKolam);
    }
}
