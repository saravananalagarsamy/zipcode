package com.wsgc.shipping.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wsgc.shipping.model.Errors;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "restricted_zipcodes"
})
public class Shipping implements Serializable
{

    @JsonProperty("restricted_zipcodes")
    private List<RestrictedZipcode> restrictedZipcodes = null;

    private Errors errors;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1232330777623477370L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Shipping() {
    }

    /**
     *
     * @param restrictedZipcodes
     */
    public Shipping(List<RestrictedZipcode> restrictedZipcodes) {
        super();
        this.restrictedZipcodes = restrictedZipcodes;
    }

    @JsonProperty("restricted_zipcodes")
    public List<RestrictedZipcode> getRestrictedZipcodes() {
        return restrictedZipcodes;
    }

    @JsonProperty("restricted_zipcodes")
    public void setRestrictedZipcodes(List<RestrictedZipcode> restrictedZipcodes) {
        this.restrictedZipcodes = restrictedZipcodes;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
