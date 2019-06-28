package com.everglow.xuanhaoshenqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by EverGlow on 2019/5/24 14:56
 */
public class ChaxunFragement extends Fragment implements View.OnClickListener {


    public static ChaxunFragement newInstance() {
        return new ChaxunFragement();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chaxun_fragment, container, false);
        rootView.findViewById(R.id.rl1).setOnClickListener(this);
        rootView.findViewById(R.id.rl2).setOnClickListener(this);
        rootView.findViewById(R.id.rl3).setOnClickListener(this);
        rootView.findViewById(R.id.rl4).setOnClickListener(this);
        rootView.findViewById(R.id.rl5).setOnClickListener(this);
        rootView.findViewById(R.id.rl6).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), ActivityWeb1.class);
        switch (view.getId()) {

            case R.id.rl1:
                intent.putExtra("title","交管所查询");
                intent.putExtra("url",Api.UnlockFragmentUrl5);
                break;
            case R.id.rl2:
                intent.putExtra("title","车管所查询");
                intent.putExtra("url",Api.UnlockFragmentUrl8);
                break;
            case R.id.rl3:
                intent.putExtra("title","驾校查询");
                intent.putExtra("url",Api.UnlockFragmentUrl4);
                break;
            case R.id.rl4:
                intent.putExtra("title","车标查询");
                intent.putExtra("url",Api.UnlockFragmentUrl6);
                break;
            case R.id.rl5:
                intent.putExtra("title","交通标志查询");
                intent.putExtra("url",Api.UnlockFragmentUrl7);
                break;
            case R.id.rl6:
                intent.putExtra("title","出租车叫车查询");
                intent.putExtra("url",Api.UnlockFragmentUrl9);
                break;
        }
        startActivity(intent);
    }
}
