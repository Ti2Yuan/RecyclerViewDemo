package com.chen.recyclerviewdemo;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private LinearLayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;
    private ItemTouchHelper itemTouchHelper;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initData() {
        list = new ArrayList<>();
        list.add("乔丹");
        list.add("科比");
        list.add("麦迪");
        list.add("卡特");
        list.add("詹姆斯");
        list.add("库里");
        list.add("约翰逊");
        list.add("伯德");
        list.add("杜兰特");
        list.add("韦斯特布鲁克");
        list.add("保罗");
        list.add("韦德");
        list.add("安东尼");
        list.add("邓肯");
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerViewAdapter(this, list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
        recyclerView.addOnItemTouchListener(new OnRecyclerViewItemTouchListener(recyclerView) {
            @Override
            protected void onItemClick(RecyclerView.ViewHolder vh) {

            }

            @Override
            protected void onItemLongClick(RecyclerView.ViewHolder vh) {

            }
        });

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelpCallback(this,list) {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getLayoutPosition();
                if(position != 0 && position != recyclerView.getAdapter().getItemCount() - 1) {
                    adapter.notifyItemRemoved(position);
                    list.remove(position-1);
                }
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
