package com.everglow.xuanhaoshenqi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by EverGlow on 2019/5/24 14:56
 */
public class MyFragement1 extends Fragment {
    private static final String TAG = "MyFragement1";

    private TextView mTv1;
    private TextView mTv2;
    private RecyclerView mRecycler;
    private CommonAdapter mAdapter;
    private ArrayList<PlateNumberEntity> mList;

    public static MyFragement1 newInstance() {
        return new MyFragement1();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        mTv1 = rootView.findViewById(R.id.tv1);
        mTv2 = rootView.findViewById(R.id.tv2);
        rootView.findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), JiqiaoActivity.class));
            }
        });
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWhich < 0) {
                    Toast.makeText(getContext(), "请选择要查询的省份", Toast.LENGTH_SHORT).show();
                    return;
                }

                getData(shortprovinces[mWhich]);
            }
        });
        mTv2 = rootView.findViewById(R.id.tv2);
        mRecycler = rootView.findViewById(R.id.recycler);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new CommonAdapter();

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(manager);
        mRecycler.setAdapter(mAdapter);
    }

    private void getData(String flag) {

        String url = "http://api.online-service.vip/carnum/" + flag + "/1";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();
                Log.d(TAG, "onResponse: " + json);
                try {

                    JSONArray JSArray = new JSONArray(json);
                    if (JSArray == null || JSArray.length() == 0) {
                        return;
                    }
                    mList = new ArrayList<>();
                    for (int i = 0; i < JSArray.length(); i++) {
                        JSONObject ob = (JSONObject) JSArray.get(i);
                        mList.add(new PlateNumberEntity(ob.optString("area"), ob.optString("numpre")));
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.refresh(mList);
                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected List<PlateNumberEntity> mTList = new ArrayList<>();

        public void refresh(List<PlateNumberEntity> dataList) {
            if (dataList == null) return;
            this.mTList.clear();
            this.mTList.addAll(dataList);

            notifyDataSetChanged();
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            PlateNumberEntity orderInfo = mTList.get(position);
            viewHolder.mTvCity.setText(orderInfo.area);
            viewHolder.mQianzhui.setText(orderInfo.numpre);
        }

        @Override
        public int getItemCount() {
            return mTList.size();
        }


        class ViewHolder extends RecyclerView.ViewHolder {


            public TextView mTvCity;
            public TextView mQianzhui;

            ViewHolder(View view) {
                super(view);
                mTvCity = (TextView) view.findViewById(R.id.tv_city);
                mQianzhui = (TextView) view.findViewById(R.id.tv_qianzhui);
            }
        }
    }

    public void showDialog() {
        final AlertDialog alertDialog = new AlertDialog
                .Builder(getContext())
                .setItems(provinces, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mWhich = which;
                        mTv1.setText(provinces[which]);
                    }
                }).create();
        alertDialog.show();

    }

    int mWhich = -1;

    String[] provinces = {"北京市", "上海市", "天津市", "重庆市", "云南省", "内蒙古自治区", "吉林省", "四川省", "宁夏回族自治区", "安徽省", "山东省", "山西省", "广东省", "广西壮族自治区", "新疆维吾尔自治区", "江苏省", "江西省", "河北省", "河南省", "浙江省", "海南省", "湖北省", "湖南省", "甘肃省", "福建省", "西藏自治区", "贵州省", "辽宁省", "陕西省", "青海省", "黑龙江省",};
    String[] shortprovinces = {"京", "沪", "津", "渝", "云", "蒙", "吉", "川", "宁", "皖", "鲁", "晋", "粤", "桂", "新", "苏", "赣", "冀", "豫", "浙", "琼", "鄂", "湘", "甘", "闽", "藏", "贵", "辽", "陕", "青", "黑"};
}
