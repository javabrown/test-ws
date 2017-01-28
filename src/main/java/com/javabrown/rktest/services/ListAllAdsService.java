package com.javabrown.rktest.services;


import com.javabrown.rktest.model.ResponseI;
import com.javabrown.rktest.utils.DataCache;

public class ListAllAdsService extends Service {
    @Override
    public ResponseI validate(Object obj) {
        return null;
    }

    @Override
    public ResponseI[] perform(Object obj) {
        ResponseI[] ads = DataCache.getInstance().listAllCampaigns();
        return ads;
    }
}
