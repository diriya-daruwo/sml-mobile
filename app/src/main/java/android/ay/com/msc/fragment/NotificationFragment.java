package android.ay.com.msc.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.ay.com.msc.R;


public class NotificationFragment extends Fragment {

    private View view;

    public NotificationFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {

            view = inflater.inflate(R.layout.fragment_notification, container, false);

            return view;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }



}
