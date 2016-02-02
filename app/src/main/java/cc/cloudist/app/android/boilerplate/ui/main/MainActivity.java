package cc.cloudist.app.android.boilerplate.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cc.cloudist.app.android.boilerplate.R;
import cc.cloudist.app.android.boilerplate.data.model.News;
import cc.cloudist.app.android.boilerplate.mvp.presenter.RequiresPresenter;
import cc.cloudist.app.android.boilerplate.ui.base.NucleusActivity;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends NucleusActivity<MainPresenter> {


    @Bind(R.id.recycler_news)
    RecyclerView mRecyclerNews;

    private NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new NewsAdapter();
        mRecyclerNews.setAdapter(mAdapter);
        mRecyclerNews.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState == null) getPresenter().request();
    }

    public void setData(List<News.StoriesEntity> data) {
        mAdapter.update(data);
    }

    public void onNetworkError(Throwable throwable) {
    }
}
