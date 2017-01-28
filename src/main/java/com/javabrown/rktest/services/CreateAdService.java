package com.javabrown.rktest.services;


import com.javabrown.rktest.model.AdCampaign;
import com.javabrown.rktest.model.Message;
import com.javabrown.rktest.model.ResponseI;
import com.javabrown.rktest.utils.ConstantsI;
import com.javabrown.rktest.utils.DataCache;

import java.sql.Timestamp;

public class CreateAdService extends Service {
    @Override
    public ResponseI validate(Object obj) {
        ResponseI error = null;

        if(obj != null || obj instanceof AdCampaign){
            AdCampaign ad = (AdCampaign) obj;

            if(ad == null){
                error = new Message(String.format("%s. %s" ,
                        ConstantsI.INVALID_CREATE_AD_REQUEST, ConstantsI.VALID_CREATE_AD_SAMPLE));
            }
            else if(ad != null && ad.isInvalid()){
                error = new Message(String.format("%s. %s" ,
                        ad.getInvalidMessage(), ConstantsI.VALID_CREATE_AD_SAMPLE));
            }
            else if(DataCache.getInstance().isAdCampaignExists(ad.getPartnerId())){
                error = new Message(String.format("Ad Campaign Already Registered PartnerId: %s" ,
                        ad.getPartnerId()));
            }
        }

        return error;
    }

    @Override
    public ResponseI perform(Object obj) {
        AdCampaign ad = (AdCampaign) obj;
        ad.setTimestamp(new Timestamp(System.currentTimeMillis()));

        DataCache.getInstance().saveAdCampaign(ad);
        ResponseI message = new Message("SUCCESS");
        System.out.println(ad);

        return message;
    }
}
