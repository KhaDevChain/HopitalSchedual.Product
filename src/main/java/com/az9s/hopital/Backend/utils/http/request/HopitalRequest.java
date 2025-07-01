package com.az9s.hopital.Backend.utils.http.request;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.az9s.hopital.Backend.utils.option.HopitalTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HopitalRequest {
    private String uniqueId;
    private String name;
    private String code;
    private String address;
    private String email;
    private String type;
    private String taxCode;
    private String website;
    private String openWork;
    private String closeWork;
    private String logo;
    private String contract;
    private Integer contractSize;
    private String representName;
    private String representPhone;
    private String representJob;
    private String activated;

    public HopitalTypeEnum getTypeEnum() {
        return type != null ? 
                HopitalTypeEnum.valueOf(type) : null;
    }

    public ActivateEnum getActivatedEnum() {
        return activated != null ? 
                ActivateEnum.valueOf(activated) : null;
    }
}
