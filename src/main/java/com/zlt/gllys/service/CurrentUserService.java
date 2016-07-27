package com.zlt.gllys.service;

import com.zlt.gllys.model.CurrentUser;

/**
 * Created by zhangletian on 16/7/27.
 */
public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
