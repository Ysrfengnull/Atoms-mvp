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
package com.vea.atoms.mvp.demo.mvp.model.entity;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.vea.atoms.mvp.commonservice.IUserService;

/**
 * ================================================
 * User 实体类
 * <p>
 * Created by Vea on 04/09/2016 17:14
 * ================================================
 */
@Route(path = "/app/service/user")
public class User implements IUserService {

    private Context mContext;

    private int id;
    private String login;
    private String avatar_url;


    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getAvatarUrl() {
        if (avatar_url.isEmpty()) return avatar_url;
        return avatar_url.split("\\?")[0];
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
