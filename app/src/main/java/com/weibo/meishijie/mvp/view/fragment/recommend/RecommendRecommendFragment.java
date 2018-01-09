package com.weibo.meishijie.mvp.view.fragment.recommend;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.weibo.meishijie.R;
import com.weibo.meishijie.mvp.base.BaseFragment;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的推荐页内容
 *
 * @author 韦大帅
 */

public class RecommendRecommendFragment extends BaseFragment implements RecommendContract.LoadDataListener, SwipeRefreshLayout.OnRefreshListener {

    private RecommendContract.RefreshListener refreshListener;
    private RecyclerView rv_recommendRecommend;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void findView() {
        swipeRefreshLayout = find(R.id.swipeRefresh_recommendrecommend);
        rv_recommendRecommend = find(R.id.rv_recommendRecommend);
    }

    @Override
    protected void listener() {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void loadData(Data data) {


    }

    @Override
    public void onRefresh() {
        refreshListener.refresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_recommend;
    }

    public static RecommendRecommendFragment newInstance() {
        RecommendRecommendFragment fragment = new RecommendRecommendFragment();
        return fragment;
    }

    public void setRefreshListener(RecommendContract.RefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }

}
