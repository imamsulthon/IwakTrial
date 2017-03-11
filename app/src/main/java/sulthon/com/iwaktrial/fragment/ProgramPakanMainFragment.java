package sulthon.com.iwaktrial.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import sulthon.com.iwaktrial.R;
import sulthon.com.iwaktrial.activity.HomeActivity;
import sulthon.com.iwaktrial.font.LatoFont;

/**
 * Created by Sulthon on 3/7/2017.
 */

public class ProgramPakanMainFragment extends Fragment {

    private View view;
    private TextView tvLabel, tvSatuanBerat, tvSatuanJml;
    private EditText etBerat, etJml;
    private Button btnProses;
    private Spinner pilihKolam;

    public static ProgramPakanMainFragment newInstance() {
        ProgramPakanMainFragment fragment = new ProgramPakanMainFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_program_pakan,container,false);

        prepareView();

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //change fragment
                Bundle bundle = new Bundle();
                bundle.putInt(HomeActivity.Key_CHANGE_FRAGMENT, 4);     //key 4 is ProgramPakanEndFragment
                EventBus.getDefault().post(bundle);
            }
        });
        return view;
    }

    private void prepareView() {

        Typeface tfLatoBold = Typeface.createFromAsset(getActivity().getAssets(),
                LatoFont.LATO_BOLD);
        Typeface tfLatoRegular = Typeface.createFromAsset(getActivity().getAssets(),
                LatoFont.LATO_REGULAR);
        Typeface tfLatoLight = Typeface.createFromAsset(getActivity().getAssets(),
                LatoFont.LATO_LIGHT);

        tvLabel = (TextView) view.findViewById(R.id.tv_label);
        tvSatuanBerat = (TextView) view.findViewById(R.id.tv_satuan_berat);
        tvSatuanJml = (TextView) view.findViewById(R.id.tv_satuan_jumlah);
        etBerat = (EditText) view.findViewById(R.id.et_programpakan_input_beratSampling);
        etJml = (EditText) view.findViewById(R.id.et_programpakan_input_jumlahIkan);
        btnProses = (Button) view.findViewById(R.id.btn_programpakan_proses);
        pilihKolam = (Spinner) view.findViewById(R.id.spn_pilih_kolam);

        tvLabel.setTypeface(tfLatoRegular);
        tvSatuanJml.setTypeface(tfLatoRegular);
        tvSatuanBerat.setTypeface(tfLatoRegular);
        etBerat.setTypeface(tfLatoLight);
        etJml.setTypeface(tfLatoLight);
        btnProses.setTypeface(tfLatoBold);
    }
}
