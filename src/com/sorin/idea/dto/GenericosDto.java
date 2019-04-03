package com.sorin.idea.dto;

import java.util.ArrayList;

import hvn.cm.modelo.dto.BaseDto;

public class GenericosDto extends BaseDto {
    private static final long serialVersionUID = 1L;
    
    private String            tmpString1;
    private String            tmpString2;
    private String            tmpString3;
    private Integer           tmpInteger1;
    private Integer           tmpInteger2;
    private ArrayList<String> tmpArray;

    public GenericosDto() {
        this.tmpInteger1 = 0;
        this.tmpInteger2 = 0;
        this.tmpString1 = "";
        this.tmpString2 = "";
        this.tmpString3 = "";
        this.tmpArray = new ArrayList<String>();
    }
    
    public GenericosDto(String tmpString1) {
        this.tmpInteger1 = 0;
        this.tmpInteger2 = 0;
        this.tmpString1 = tmpString1;
        this.tmpString2 = "";
        this.tmpString3 = "";
        this.tmpArray = new ArrayList<String>();
    }

    public String getTmpString1() {
        return tmpString1;
    }

    public void setTmpString1(String tmpString1) {
        this.tmpString1 = tmpString1;
    }
    
    public void setTmpString1(Object tmpString1) {
        this.tmpString1 = (String) tmpString1;
    }

    public String getTmpString2() {
        return tmpString2;
    }

    public void setTmpString2(String tmpString2) {
        this.tmpString2 = tmpString2;
    }

    public String getTmpString3() {
        return tmpString3;
    }

    public void setTmpString3(String tmpString3) {
        this.tmpString3 = tmpString3;
    }

    public Integer getTmpInteger1() {
        return tmpInteger1;
    }

    public void setTmpInteger1(Integer tmpInteger1) {
        this.tmpInteger1 = tmpInteger1;
    }

    public Integer getTmpInteger2() {
        return tmpInteger2;
    }

    public void setTmpInteger2(Integer tmpInteger2) {
        this.tmpInteger2 = tmpInteger2;
    }

	public ArrayList<String> getTmpArray() {
		return tmpArray;
	}

	public void setTmpArray(ArrayList<String> tmpArray) {
		this.tmpArray = tmpArray;
	}
    
    

}
