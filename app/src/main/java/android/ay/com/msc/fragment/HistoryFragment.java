package android.ay.com.msc.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.ay.com.msc.R;

public class HistoryFragment extends Fragment {

    private View view;

    public HistoryFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {

            view = inflater.inflate(R.layout.fragment_history, container, false);


            return view;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }



}
