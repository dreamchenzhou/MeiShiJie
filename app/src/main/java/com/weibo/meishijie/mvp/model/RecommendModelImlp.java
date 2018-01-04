package com.weibo.meishijie.mvp.model;

import com.weibo.meishijie.app.MeishijieApplication;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.api.MeiShiJieApiService;
import com.weibo.meishijie.mvp.model.api.MeiShiJieCacheApiService;
import com.weibo.meishijie.mvp.model.entities.recommend.HomeRecommend;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendModelImlp implements RecommendContract.RecommendModel {

    @Inject
    MeiShiJieApiService meiShiJieApiService;
    @Inject
    MeiShiJieCacheApiService meiShiJieCacheApiService;

    public RecommendModelImlp() {
        MeishijieApplication.getContext().getAppComponent().inject(this);
    }

    @Override
    public void load(RecommendContract.LoadListener loadListener, boolean refresh) {
        Observable<Reply<HomeRecommend>> result = meiShiJieCacheApiService.requestHomeRecommendData(
                meiShiJieApiService.requestHomeRecommendData(),
                new EvictProvider(true));
        loadListener.loadHomeRecommendData(result);
    }
}
