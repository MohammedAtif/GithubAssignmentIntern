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
	public void setValueInt(Integer calculateInt) {
		this.valueInt = calculateInt;
	}
	public Float getValueFloat() {
		return valueFloat;
	}
	public void setValueFloat(Float calculateFloat) {
		this.valueFloat = calculateFloat;
	}
	public Long getValueLong() {
		return valueLong;
	}
	public void setValueLong(Long calculateLong) {
		this.valueLong = calculateLong;
	}
	public Double getValueDouble() {
		return valueDouble;
	}
	public void setValueDouble(Double calculateDouble) {
		this.valueDouble = calculateDouble;
	}
    
}
