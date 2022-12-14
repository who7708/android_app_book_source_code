/*
Copyright 2015 chanven

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.chanven.lib.cptr.loadmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;

import com.chanven.lib.cptr.loadmore.ILoadViewMoreFactory.FootViewAdder;
import com.chanven.lib.cptr.loadmore.ILoadViewMoreFactory.ILoadMoreView;

public class GridViewHandler implements ViewHandler {
    @Override
    public boolean handleSetAdapter(View contentView, ILoadMoreView loadMoreView, OnClickListener onClickLoadMoreListener) {
        final GridViewWithHeaderAndFooter gridView = (GridViewWithHeaderAndFooter) contentView;
        ListAdapter adapter = gridView.getAdapter();
        boolean hasInit = false;
        if (loadMoreView != null) {
            final Context context = gridView.getContext().getApplicationContext();
            loadMoreView.init(new FootViewAdder() {

                @Override
                public View addFootView(int layoutId) {
                    View view = LayoutInflater.from(context).inflate(layoutId, gridView, false);
                    return addFootView(view);
                }

                @Override
                public View addFootView(View view) {
                    gridView.addFooterView(view);
                    return view;
                }
            });
            hasInit = true;
            if (null != adapter) {
                gridView.setAdapter(adapter);
            }
        }
        return hasInit;
    }

    @Override
    public void setOnScrollBottomListener(View contentView, OnScrollBottomListener onScrollBottomListener) {
        GridViewWithHeaderAndFooter gridView = (GridViewWithHeaderAndFooter) contentView;
        gridView.setOnScrollListener(new GridViewOnScrollListener(onScrollBottomListener));
        gridView.setOnItemSelectedListener(new GridViewOnItemSelectedListener(onScrollBottomListener));
    }

    /**
     * ??????????????? ??????????????????????????????????????????????????????
     */
    private class GridViewOnItemSelectedListener implements OnItemSelectedListener {
        private OnScrollBottomListener onScrollBottomListener;

        public GridViewOnItemSelectedListener(OnScrollBottomListener onScrollBottomListener) {
            super();
            this.onScrollBottomListener = onScrollBottomListener;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (adapterView.getLastVisiblePosition() + 1 == adapterView.getCount()) {// ???????????????????????????
                if (onScrollBottomListener != null) {
                    onScrollBottomListener.onScorllBootom();
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    ;

    /**
     * ???????????????????????????????????????
     */
    private static class GridViewOnScrollListener implements OnScrollListener {
        private OnScrollBottomListener onScrollBottomListener;

        public GridViewOnScrollListener(OnScrollBottomListener onScrollBottomListener) {
            super();
            this.onScrollBottomListener = onScrollBottomListener;
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == OnScrollListener.SCROLL_STATE_IDLE && view.getLastVisiblePosition() + 1 == view.getCount()) {// ???????????????????????????
                if (onScrollBottomListener != null) {
                    onScrollBottomListener.onScorllBootom();
                }
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }
}
