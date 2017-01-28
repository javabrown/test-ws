package com.javabrown.rktest;

import com.javabrown.rktest.model.ResponseI;
import com.javabrown.rktest.services.CreateAdService;
import com.javabrown.rktest.services.FindAdService;
import com.javabrown.rktest.services.ListAllAdsService;
import com.javabrown.rktest.services.Service;
import com.javabrown.rktest.model.AdCampaign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EndPoint implements EndPointI {
    @Override
    public ResponseEntity<ResponseI> findAd(@PathVariable String partnerId){
        Service service = new FindAdService();
        return service.serve(partnerId);
    }

    @Override
    public ResponseEntity<ResponseI> createAd(@RequestBody AdCampaign ad){
        Service service = new CreateAdService();
        return service.serve(ad);
    }

    @Override
    public ResponseEntity<ResponseI[]> listAll() {
        //ResponseI[] ads = DataCache.getInstance().listAllCampaigns();
        //System.out.println(ads.length);
        //return new ResponseEntity<ResponseI[]>(ads, HttpStatus.OK);
        Service service = new ListAllAdsService();
        return service.serve(null);

    }
}
