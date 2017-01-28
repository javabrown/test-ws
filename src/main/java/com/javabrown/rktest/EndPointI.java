package com.javabrown.rktest;

import com.javabrown.rktest.model.AdCampaign;
import com.javabrown.rktest.model.ResponseI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface EndPointI {
    @RequestMapping(value="/ad/{partnerId}", method = RequestMethod.GET, consumes="application/json", produces = "application/json")
    ResponseEntity<ResponseI> findAd(@PathVariable String partnerId);

    @RequestMapping(value="/ad", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    ResponseEntity<ResponseI> createAd(@RequestBody AdCampaign ad);

    @RequestMapping(value="/ad", method = RequestMethod.GET, consumes="application/json", produces = "application/json")
    ResponseEntity<ResponseI[]> listAll();
}
