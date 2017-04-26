package com.d.xrecyclerviewf.activity;

import android.app.Activity;
import android.os.Bundle;

import com.d.xrecyclerviewf.Factory;
import com.d.xrecyclerviewf.R;
import com.d.xrecyclerviewf.adapter.MultiRvAdapter;
import com.d.xrecyclerviewf.model.Bean;
import com.d.xrv.LRecyclerView;
import com.d.xrv.adapter.MultiItemTypeSupport;

import java.util.ArrayList;

/**
 * multi type
 * Created by Shenyulei on 2017/2/26.
 */
public class MultiLRvActivity extends Activity {
    private ArrayList<Bean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_lrv);
        datas = Factory.createDatas();
        init();
    }

    private void init() {
        //step1:获取引用
        LRecyclerView recyclerView = (LRecyclerView) this.findViewById(R.id.lrv_list);
        //step2:new Adapter
        MultiRvAdapter adapter = new MultiRvAdapter(this, datas, new MultiItemTypeSupport<Bean>() {
            @Override
            public int getLayoutId(int viewType) {
                //step2-2:根据type返回layout布局
                switch (viewType) {
                    case 0:
                        return R.layout.item_0;
                    case 1:
                        return R.layout.item_1;
                    case 2:
                        return R.layout.item_2;
                    case 3:
                        return R.layout.item_3;
                    default:
                        return R.layout.item_0;
                }
            }

            @Override
            public int getItemViewType(int position, Bean bean) {
                //step2-1:获取type类型
                return bean.type;
            }
        });
        //step3:setAdapter
        recyclerView.setAdapter(adapter);
    }
}
