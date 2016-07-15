package com.jt.icaew.android.activity.events;

import com.jt.icaew.android.network.event.EventListResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventView {
    interface OnFinishGetEventListListener
    {
        void onFinishGetEventListListener(EventListResult eventListResult);
    }
}
