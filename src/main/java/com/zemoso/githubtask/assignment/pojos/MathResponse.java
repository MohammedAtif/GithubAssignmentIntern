package com.zemoso.githubtask.assignment.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MathResponse {
    private int valueInt;
    private Float valueFloat;
    private Long valueLong;
    private Double valueDouble;
    public void setValueDouble(double value){
        this.valueDouble=value;
    }
    public double getValueDouble(){
        return valueDouble;
    }

    public Long getValueLong() {
        return valueLong;
    }

    public void setValueLong(Long valueLong) {
        this.valueLong = valueLong;
    }

    public Float getValueFloat() {
        return valueFloat;
    }

    public void setValueFloat(Float valueFloat) {
        this.valueFloat = valueFloat;
    }

    public void setValueInt(int value){
        this.valueInt=value;
    }

    public int getValueInt(){
        return valueInt;
    }

}
