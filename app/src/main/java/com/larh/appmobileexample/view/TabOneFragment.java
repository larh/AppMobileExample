package com.larh.appmobileexample.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larh.appmobileexample.R;
import com.larh.appmobileexample.view.listener.OnFragmentInteractionListener;

public class TabOneFragment extends Fragment {

    public TabOneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_one, container, false);
    }

}
