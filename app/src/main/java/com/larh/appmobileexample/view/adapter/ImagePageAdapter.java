package com.larh.appmobileexample.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.larh.appmobileexample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagePageAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<String> mDataImages;

    @BindView(R.id.imgSlide)
    ImageView imgSlide;

    public ImagePageAdapter(Context context, List<String> mDataImages) {
        this.context = context;
        this.mDataImages = mDataImages;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_image, container, false);
        ButterKnife.bind(this, view);

        Glide.with(imgSlide.getContext()).load(mDataImages.get(position))
                //.transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.apply(RequestOptions.circleCropTransform())
                //.error(R.mipmap.user_login)
                .skipMemoryCache(false)
                .into(imgSlide);

        container.addView(view);



        return view;
    }

    @Override
    public int getCount() {
        return mDataImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
