package com.everglow.xuanhaoshenqi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by EverGlow on 2018/4/11 11:52
 */
public class WebFragment2 extends BaseWebView {
    
    public static WebFragment2 newInstance() {
        WebFragment2 fragment = new WebFragment2();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setTitle("车牌号吉凶查询");
        ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) mWebView.getLayoutParams();
        p.setMargins(0, (int) getResources().getDimension(R.dimen.m10), 0, 0);
        mWebView.requestLayout();

     
                
        goToWeb();
    }
    
    
    private void goToWeb() {
        mWebView.loadUrl(Api.UnlockFragmentUrl2);
    }

    
}
