package com.wsgc.shipping.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.cache.annotation.Cacheable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "shipping"
})
public class RestrictedZipcodes implements Serializable
{

    @JsonProperty("shipping")
    private Shipping shipping;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2480506141766686222L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RestrictedZipcodes() {
    }

    /**
     *
     * @param shipping
     */
    public RestrictedZipcodes(Shipping shipping) {
        super();
        this.shipping = shipping;
    }

    @JsonProperty("shipping")
    @Cacheable("Shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("shipping", shipping).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(shipping).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RestrictedZipcodes) == false) {
            return false;
        }
        RestrictedZipcodes actual = ((RestrictedZipcodes) other);

        if (actual.getShipping().getRestrictedZipcode().size() == this.getShipping().getRestrictedZipcode().size()) {
            ListIterator<RestrictedZipcode> expRestrictedZipcodeItr = this.getShipping().getRestrictedZipcode().listIterator();
            for(ListIterator<RestrictedZipcode> actRestrictedZipcodeItr = actual.getShipping().getRestrictedZipcode().listIterator();actRestrictedZipcodeItr.hasNext();) {
                RestrictedZipcode ezipcode = actRestrictedZipcodeItr.next();
                RestrictedZipcode azipcode = expRestrictedZipcodeItr.next();
                if(ezipcode.getTo().equals(azipcode.getTo()) && ezipcode.getFrom().equals(azipcode.getFrom())){
                    continue;
                }
                else
                {
                    return false;
                }
            }

        }
        return true;
    }

}
