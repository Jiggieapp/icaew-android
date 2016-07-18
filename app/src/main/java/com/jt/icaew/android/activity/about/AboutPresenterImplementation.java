package com.jt.icaew.android.activity.about;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.about.AboutManager;
import com.jt.icaew.android.network.about.AboutResult;
import com.jt.icaew.android.utils.Utils;

/**
 * Created by Wandy on 7/12/2016.
 */
public class AboutPresenterImplementation implements AboutPresenter {

    private AboutView aboutView;

    public AboutPresenterImplementation(AboutView aboutView)
    {
        this.aboutView = aboutView;
    }

    @Override
    public void getAbout() {
        Utils.d("about", "getAbout");
        AboutManager.getAbout(new OnResponseListener()
        {
            @Override
            public void onSuccess(Object object) {
                final AboutResult aboutResult = (AboutResult) object;
                aboutView.onFinishGetAbout(aboutResult);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
