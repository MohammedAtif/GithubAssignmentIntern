package com.zemoso.githubtask.assignment.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MathResponse {
    private Integer valueInt;
    private Float valueFloat;

    private Long valueLong;
    private Double valueDouble;
	public Integer getValueInt() {
		return valueInt;
	}
	public void setValueInt(Integer valueInt) {
		this.valueInt = valueInt;
	}
	public Float getValueFloat() {
		return valueFloat;
	}
	public void setValueFloat(Float valueFloat) {
		this.valueFloat = valueFloat;
	}
	public Long getValueLong() {
		return valueLong;
	}
	public void setValueLong(Long valueLong) {
		this.valueLong = valueLong;
	}
	public Double getValueDouble() {
		return valueDouble;
	}
	public void setValueDouble(Double valueDouble) {
		this.valueDouble = valueDouble;
	}
	
	
}
