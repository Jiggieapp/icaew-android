package com.jt.icaew.android.activity.events.detail;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.utils.Constant;
import com.jt.icaew.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.lbl_title_program)
    TextView lblTitleProgram;

    @BindView(R.id.lbl_description_program)
    TextView lblDescriptionProgram;

    @BindView(R.id.lbl_initial_program)
    TextView lblInitialProgram;

    @BindView(R.id.lbl_event_summary)
    TextView lblEventSummary;

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        final Bundle bundle = getBundle();
        if(bundle != null)
        {
            setSupportActionBar(toolbar);
            final String title = bundle.getString(Constant.PARAM_EVENT_TITLE);
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            final String date = Utils.getDate(bundle.getString(Constant.PARAM_EVENT_START_DATE));
            final String summary = bundle.getString(Constant.PARAM_EVENT_SUMMARY);


            lblInitialProgram.setText(date.replace(" ", "\n"));
            lblTitleProgram.setText(title);
            lblDescriptionProgram.setText(summary);
            AsyncTask<String, Void, String> handler = new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    final String desc = bundle.getString(Constant.PARAM_EVENT_DESCRIPTION);
                    return desc;
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    lblEventSummary.setText(s);
                }
            }.execute("");
        }
    }
}
