package com.jt.icaew.android.activity.universities;

import com.jt.icaew.android.network.university.UniversityListResult;
import com.jt.icaew.android.network.university.UniversityResult;

/**
 * Created by LTE on 7/13/2016.
 */
public interface UniversityView {
    interface onFinishGetCountryListener{
        void onFinishGetCountry(UniversityResult universityResult);
    }
    interface onFinishGetUniversityDetailListener{
        void onFinishGetUniversityDetail(UniversityListResult universityListResult);
        void onFailureGetUniversity(String message);
    }


}
