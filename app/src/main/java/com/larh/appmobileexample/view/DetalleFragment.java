package com.larh.appmobileexample.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.larh.appmobileexample.R;
import com.larh.appmobileexample.view.adapter.ImagePageAdapter;
import com.larh.appmobileexample.view.listener.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.layoutDots)
    LinearLayout layoutDots;
    private TextView[] dots;

    List<String> imagenes;

    private OnFragmentInteractionListener mListener;

    public DetalleFragment() {
        // Required empty public constructor
    }

    public static DetalleFragment newInstance(String param1, String param2) {
        DetalleFragment fragment = new DetalleFragment();
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
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        ButterKnife.bind(this,view);

        imagenes = new ArrayList<>();
        imagenes.add("https://diccionarioactual.com/wp-content/uploads/2016/05/Tux-768x788.png");
        imagenes.add("https://www.gnu.org/graphics/babies/GnuTux.jpg");

        iniciarSlider(view, imagenes);

        setHasOptionsMenu(true);

        return view;
    }

    private void iniciarSlider(View view, List<String> imagenes){
        ImagePageAdapter imagePageAdapter = new ImagePageAdapter(view.getContext(), imagenes);
        viewPager.setAdapter(imagePageAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        viewPager.setOffscreenPageLimit(imagenes.size());
        addBottomDots(0);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[imagenes.size()];

        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#9675;"));
            dots[i].setTextSize(15);
            dots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            layoutDots.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[currentPage].setText(Html.fromHtml("&#9679;"));
            dots[currentPage].setTextSize(15);
            dots[currentPage].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

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

    @Override
    public void onResume() {
        super.onResume();
        mListener.onFragmentInteraction(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_custom, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

}
