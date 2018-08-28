/*
 * Copyright 2017 Vea
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vea.atoms.mvp.gank.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vea.atoms.mvp.base.BaseActivity;
import com.vea.atoms.mvp.base.ViewPagerAdapterFragment;
import com.vea.atoms.mvp.commonsdk.core.RouterHub;
import com.vea.atoms.mvp.commonsdk.view.spread.BaseViewHelper;
import com.vea.atoms.mvp.gank.R;
import com.vea.atoms.mvp.gank.R2;
import com.vea.atoms.mvp.gank.mvp.ui.fragment.GirlFragment;

import butterknife.BindView;

@Route(path = RouterHub.GANK_MAIN_ACTIVITY)
public class GankMainActivity extends BaseActivity {

    private ViewPagerAdapterFragment mAdapter;
    private BaseViewHelper mHelper;
    @BindView(R2.id.tab)
    TabLayout tablayout;
    @BindView(R2.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.gank_activity_main;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mAdapter = new ViewPagerAdapterFragment(getSupportFragmentManager(), this);
        mAdapter.addTab("福利", "tag", GirlFragment.class, null);
        viewpager.setAdapter(mAdapter);
        tablayout.setupWithViewPager(viewpager);

    }


}
