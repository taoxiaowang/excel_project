package com.common.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.blankj.utilcode.util.ProcessUtils;
import com.common.core.util.fresco.ImagePipelineConfigFactory;
import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * create by wangtao at date :2020/10/11
 * 1，app 上下文
 * 2.third sdk 初始化
 **/
public class AppContext {

    private Application application;
    private AppExecutors appExecutors;


    public void init(Application application) {
        this.application = application;
        if (ProcessUtils.isMainProcess()) {
            appExecutors.taskThread().execute(this::initUtils);
            appExecutors.taskThread().execute(this::initFresco);
            registerActivityLifecycleCallbacks();
        }
    }

    private void initFresco() {
        Fresco.initialize(
                application, ImagePipelineConfigFactory.getImagePipelineConfig(application));
    }


    private void initUtils() {
        com.blankj.utilcode.util.Utils.init(application);
    }



    private void registerActivityLifecycleCallbacks() {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityStarted(Activity activity) {


            }

            @Override
            public void onActivityResumed(Activity activity) {
                //通用的埋点时间

            }

            @Override
            public void onActivityPaused(Activity activity) {
                //通用的埋点时间

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }


    public Application getApplication() {
        return application;
    }

    public AppExecutors getAppExecutors() {
        return appExecutors;
    }

    private static AppContext instance;

    private AppContext() {
    }

    public static AppContext getInstance() {
        if (null == instance) {
            synchronized (AppContext.class) {
                if (null == instance) {
                    instance = new AppContext();
                }
            }
        }
        return instance;
    }

}
