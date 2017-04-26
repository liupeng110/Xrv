package com.d.xrecyclerviewf.activity;

import android.app.Activity;
import android.os.Bundle;

import com.d.xrecyclerviewf.Factory;
import com.d.xrecyclerviewf.R;
import com.d.xrecyclerviewf.adapter.SimRvAdapter;
import com.d.xrecyclerviewf.model.Bean;
import com.d.xrv.LRecyclerView;

import java.util.ArrayList;

/**
 * simple type
 * Created by D on 2017/4/26.
 */
public class SimLRvActivity extends Activity {
    private ArrayList<Bean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_lrv);
        datas = Factory.createDatas();
        init();
    }

    private void init() {
        //step1:获取引用
        LRecyclerView recyclerView = (LRecyclerView) this.findViewById(R.id.lrv_list);
        //step2:new Adapter
        SimRvAdapter adapter = new SimRvAdapter(this, datas, R.layout.item_0);
        //step3:setAdapter
        recyclerView.setAdapter(adapter);
    }
}
