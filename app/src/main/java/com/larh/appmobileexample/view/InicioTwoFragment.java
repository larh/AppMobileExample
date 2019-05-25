package com.larh.appmobileexample.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larh.appmobileexample.R;
import com.larh.appmobileexample.view.adapter.TabPagerAdapter;
import com.larh.appmobileexample.view.listener.OnFragmentInteractionListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InicioTwoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private OnFragmentInteractionListener mListener;

    public InicioTwoFragment() {
        // Required empty public constructor
    }

    public static InicioTwoFragment newInstance(String param1, String param2) {
        InicioTwoFragment fragment = new InicioTwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio_two, container, false);
        ButterKnife.bind(this,view);

        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager() {
        TabPagerAdapter adapter = new TabPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TabOneFragment(), "ONE");
        adapter.addFragment(new TabTwoFragment(), "TWO");
        adapter.addFragment(new TabTwoFragment(), "TRES");
        viewPager.setAdapter(adapter);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
