package com.wsgc.shipping.util;

import com.wsgc.shipping.model.RestrictedZipcode;

import java.util.Comparator;

public class IntervalComparator implements Comparator<RestrictedZipcode> {

    public int compare(RestrictedZipcode iOne, RestrictedZipcode iTwo)
    {
        return Integer.valueOf(iOne.getFrom()) - Integer.valueOf(iTwo.getTo());
    }

}
