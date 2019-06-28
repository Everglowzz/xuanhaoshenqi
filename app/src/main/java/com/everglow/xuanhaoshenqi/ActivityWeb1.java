package com.everglow.xuanhaoshenqi;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class ActivityWeb1 extends BaseWebActivity {

    private String Url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = getIntent().getStringExtra("title");
        Url = getIntent().getStringExtra("url");
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }

    }

    @Override
    public void requestWeb() {
        if (Url != null) {
            mWebView.loadUrl(Url);
        }


    }
}
