package com.benmu.framework.event.router;

import android.content.Context;

import com.benmu.framework.manager.ManagerFactory;
import com.benmu.framework.manager.impl.RouterManager;
import com.benmu.framework.model.WeexEventBean;
import com.benmu.framework.utils.JsPoster;
import com.benmu.wxbase.EventGate;
import com.taobao.weex.bridge.JSCallback;

/**
 * Created by Carry on 2017/12/21.
 */

public class EventOpenBrowser extends EventGate{

    @Override
    public void perform(Context context, WeexEventBean weexEventBean) {
        openBrowser(context, weexEventBean.getJsParams(), weexEventBean.getJscallback());
    }

    public void openBrowser(Context context, String params, JSCallback callback) {
        RouterManager managerService = ManagerFactory.getManagerService(RouterManager.class);
        boolean b = managerService.openBrowser(context, params);
        if (b) {
            JsPoster.postSuccess(null,callback);
        } else {
            JsPoster.postFailed(callback);
        }
    }
}
