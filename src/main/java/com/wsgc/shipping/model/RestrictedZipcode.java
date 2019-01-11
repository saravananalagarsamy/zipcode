package com.wsgc.shipping.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "from",
        "to"
})
public class RestrictedZipcode implements Serializable
{

    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 859074223897084962L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RestrictedZipcode() {
    }

    /**
     *
     * @param to
     * @param from
     */
    public RestrictedZipcode(String from, String to) {
        super();
        if(from.length()<5){
            this.from = String.format("%0"+(5-from.length())+"d%s", 0, from);
        }else{this.from = from;}

        if(to.length()<5){
            this.to=String.format("%0"+(5-to.length())+"d%s", 0, to);
        }else{this.to = to;}
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
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

//    public int getStart() {
//        return Integer.valueOf(from);
//    }
//
//    public int getEnd() {
//        return Integer.valueOf(to);
//    }

}