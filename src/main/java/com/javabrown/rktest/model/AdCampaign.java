package com.javabrown.rktest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javabrown.rktest.utils.ConstantsI;
import com.javabrown.rktest.utils.StringUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class AdCampaign implements ResponseI {
    private String _partnerId;
    private Integer _duration;
    private String _adContent;
    private Timestamp _timestamp;

    @JsonProperty("partner_id")
    public String getPartnerId() {
        return _partnerId;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return _duration;
    }

    @JsonProperty("ad_content")
    public String getAdContent() {
        return _adContent;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return _timestamp.toString();
    }

    @JsonProperty("ad_status")
    public String getStatus() {
        String status = ConstantsI.ACTIVE;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(_timestamp.getTime());
        cal.add(Calendar.SECOND, _duration);

        if(cal.getTime().before(new Date())){
            status = ConstantsI.EXPIRED;
        }

        return status;
    }

    public void setPartnerId(String partnerId) {
        _partnerId = partnerId;
    }

    public void setDuration(Integer duration) {
        _duration = duration;
    }

    public void setAdContent(String adContent) {
        _adContent = adContent;
    }

    public void setTimestamp(Timestamp timestamp) {_timestamp = timestamp;}

    @JsonIgnore
    public boolean isInvalid(){
        return StringUtils.isEmpty(_partnerId, _adContent) || _duration <= 0;
    }

    @JsonIgnore
    public String getInvalidMessage(){
        StringBuilder template = new StringBuilder("Ad Field Missing: ");

        if(StringUtils.isEmpty(_partnerId) ){
            template.append("partner_id | ");
        }

        if(StringUtils.isEmpty(_adContent) ){
            template.append("ad_content | ");
        }

        if(_duration <= 0 ){
            template.append("duration (must be > 0)");
        }

        return template.toString();
    }

    @Override
    public String toString() {
        return "AdCampaign{" +
                "partnerId='" + _partnerId + '\'' +
                ", duration=" + _duration +
                ", adContent='" + _adContent + '\'' +
                '}';
    }
}
