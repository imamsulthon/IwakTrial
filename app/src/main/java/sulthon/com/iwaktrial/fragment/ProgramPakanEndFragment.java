package sulthon.com.iwaktrial.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import sulthon.com.iwaktrial.R;
import sulthon.com.iwaktrial.activity.HomeActivity;
import sulthon.com.iwaktrial.font.LatoFont;

/**
 * Created by Sulthon on 3/7/2017.
 */

public class ProgramPakanEndFragment extends Fragment {

    private View view;
    private TextView tvLabel;
    private Button btnKembali;

    public ProgramPakanEndFragment() {

    }

    public static ProgramPakanEndFragment newInstance(){
        ProgramPakanEndFragment fragment = new ProgramPakanEndFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_program_pakan_end,container,false);

        prepareView();

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(HomeActivity.Key_CHANGE_FRAGMENT,0);
                EventBus.getDefault().post(bundle);
            }
        });

        return view;
    }

    private void prepareView() {

        Typeface tfLatoBold = Typeface.createFromAsset(getActivity().getAssets(),
                LatoFont.LATO_BOLD);
        Typeface tfLatoMedium = Typeface.createFromAsset(getActivity().getAssets(),
                LatoFont.LATO_MEDIUM);

        tvLabel = (TextView) view.findViewById(R.id.tv_programpakan2_label);
        btnKembali = (Button) view.findViewById(R.id.btn_programpakan2_kembali);

        tvLabel.setTypeface(tfLatoMedium);
        btnKembali.setTypeface(tfLatoBold);

    }
}
