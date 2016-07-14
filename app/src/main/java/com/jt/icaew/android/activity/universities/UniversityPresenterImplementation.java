package com.jt.icaew.android.activity.universities;

import android.util.Log;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.university.UniversityListResult;
import com.jt.icaew.android.network.university.UniversityManager;
import com.jt.icaew.android.network.university.UniversityResult;
import com.jt.icaew.android.utils.Constant;

import java.util.ArrayList;

/**
 * Created by LTE on 7/13/2016.
 */
public class UniversityPresenterImplementation implements UniversityPresenter {

    private UniversityView.onFinishGetCountryListener universityCountryView;
    private UniversityView.onFinishGetUniversityDetailListener universityDetailListener;
    private final String TAG = UniversityPresenterImplementation.class.getSimpleName();

    public UniversityPresenterImplementation(){

    }

    public UniversityPresenterImplementation(UniversityView.onFinishGetCountryListener universityCountryView)
    {
        this.universityCountryView = universityCountryView;
    }

    public void setOnFinishGetUniversityDetailListener(UniversityView.onFinishGetUniversityDetailListener listener)
    {
        this.universityDetailListener = listener;
    }

    @Override
    public void getUniversity() {
        UniversityManager.getUniversity(new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                UniversityResult universityResult = (UniversityResult) object;
                int code = universityResult.getCode();
                if(code== Constant.CODE_SUCCESS){
                    ArrayList<UniversityResult.Data> arrData = universityResult.getData();
                    if(arrData.size()>0){
                        universityCountryView.onFinishGetCountry(universityResult);
                    }else{
                        Log.d(TAG, universityResult.getMessage());
                    }
                }else{
                    Log.d(TAG, universityResult.getMessage());
                }
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }

    @Override
    public void getUniversityDetail(String country_id) {
        UniversityManager.getUniversityDetail(country_id, new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                UniversityListResult universityListResult = (UniversityListResult)object;
                int code = universityListResult.getCode();
                if(code== Constant.CODE_SUCCESS){
                    ArrayList<UniversityListResult.Data> arrData = universityListResult.getData();
                    if(arrData.size()>0){
                        universityDetailListener.onFinishGetUniversityDetail(universityListResult);
                    }else{
                        Log.d(TAG, universityListResult.getMessage());
                        universityDetailListener.onFailureGetUniversity(universityListResult.getMessage());
                    }
                }else{
                    universityDetailListener.onFailureGetUniversity(universityListResult.getMessage());
                    Log.d(TAG, universityListResult.getMessage());
                }

            }

            @Override
            public void onFailure(int responseCode, String message) {
                universityDetailListener.onFailureGetUniversity(message);
            }
        });
    }
}