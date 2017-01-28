package com.javabrown.rktest.services;

import com.javabrown.rktest.model.ResponseI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class Service<T extends Object> {
    public ResponseEntity<T> serve(Object obj){
        T error = this.validate(obj);

        if(error != null){
            return new ResponseEntity<T>(error, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<T>(this.perform(obj), HttpStatus.OK);
    }

    abstract T validate(Object object);
    abstract T perform(Object object);
}
