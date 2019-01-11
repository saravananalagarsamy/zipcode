package com.wsgc.shipping.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.cache.annotation.Cacheable;

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


}
