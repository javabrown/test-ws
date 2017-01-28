package com.javabrown.rktest.services;


import com.javabrown.rktest.model.AdCampaign;
import com.javabrown.rktest.model.Message;
import com.javabrown.rktest.model.ResponseI;
import com.javabrown.rktest.utils.DataCache;

public class FindAdService extends Service {
    @Override
    public ResponseI validate(Object obj) {
        ResponseI error = null;

        if(obj != null || obj instanceof String){
            String partnerId = (String ) obj;

            if(partnerId == null){
                error = new Message(String.format("Invalid Partner Id: %s", partnerId));
            }
        }

        return error;
    }

    @Override
    public ResponseI perform(Object obj) {
        String partnerId = (String ) obj;

        AdCampaign ad = DataCache.getInstance().getAdCampaign(partnerId);
        return ad;
    }
}
