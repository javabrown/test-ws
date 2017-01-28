package com.javabrown.rktest.utils;

import com.javabrown.rktest.model.AdCampaign;
import java.util.HashMap;
import java.util.Map;

public class DataCache {
        private static DataCache _instance;
        private Map<String, AdCampaign> _adCampaignMap;

        private DataCache(){
            _adCampaignMap = new HashMap<String, AdCampaign>();
        }

        public static synchronized DataCache getInstance(){
            if(_instance == null){
                _instance = new DataCache();
            }
            return _instance;
        }

        public void saveAdCampaign(AdCampaign ad){
            _adCampaignMap.put(ad.getPartnerId(), ad);
        }

        public AdCampaign[] listAllCampaigns(){
            return _adCampaignMap.values().toArray(new AdCampaign[0]);
        }

        public AdCampaign getAdCampaign(String partnerId){
            return _adCampaignMap.get(partnerId);
        }

        public boolean isAdCampaignExists(String partnerId){
            return _adCampaignMap.get(partnerId) != null;
        }
}
