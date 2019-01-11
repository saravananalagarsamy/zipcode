package com.wsgc.shipping.service;


import com.wsgc.shipping.model.*;
import com.wsgc.shipping.util.IntervalComparator;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;


@Service
public class ZipcodeInterval {

    ArrayList<RestrictedZipcode> result;

    public Boolean OptimizeAdd(RestrictedZipcodes zipcodeList){
        ArrayList<RestrictedZipcode> restrictedZipcodes = this.merge(zipcodeList.getShipping());
        if(restrictedZipcodes==null){
            return false;
        }
        else{
            zipcodeList.getShipping().setRestrictedZipcodes(restrictedZipcodes);
            return true;
        }
    }

    private ArrayList<RestrictedZipcode> merge(Shipping zipcodeList) {
        if(zipcodeList.getRestrictedZipcodes().size() == 0 || zipcodeList.getRestrictedZipcodes().size() == 1)
            return null;

        Collections.sort(zipcodeList.getRestrictedZipcodes(), new IntervalComparator());

        RestrictedZipcode first = zipcodeList.getRestrictedZipcodes().get(0);
        int start = Integer.valueOf(first.getFrom());
        int end = Integer.valueOf(first.getTo());

        this.result = new ArrayList<RestrictedZipcode>();

        for (int i = 1; i < zipcodeList.getRestrictedZipcodes().size(); i++) {
            RestrictedZipcode current = zipcodeList.getRestrictedZipcodes().get(i);
            if (Integer.valueOf(current.getFrom()) <= end) {
                end = Math.max(Integer.valueOf(current.getTo()), end);
            } else {
                result.add(new RestrictedZipcode(String.valueOf(start), String.valueOf(end)));
                start = Integer.valueOf(current.getFrom());
                end = Integer.valueOf(current.getTo());
            }
        }

        result.add(new RestrictedZipcode(String.valueOf(start), String.valueOf(end)));
        return result;
    }

    public void printListOfIntervals(){
        DecimalFormat df = new DecimalFormat("00000");
        for(RestrictedZipcode i : this.result)
        {
            //System.out.print("["+df.format(i.getFrom()) + " , " + df.format(i.getTo())+"]");
            System.out.println(i.getFrom()+" , "+i.getTo());
        }
        System.out.println("");
    }

}
