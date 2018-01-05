package com.weibo.meishijie.mvp.view.fragment.recommend;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的推荐页内容
 *
 * @author 韦大帅
 */

public class RecommendRecommendFragment extends BaseFragment implements RecommendContract.RecommendView{

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_recommend;
    }

    public static RecommendRecommendFragment newInstance() {
        RecommendRecommendFragment fragment = new RecommendRecommendFragment();
        return fragment;
    }

    @Override
    public void showData(Data data) {

    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return RxLifecycleAndroid.bindFragment(lifecycleSubject);
    }

}