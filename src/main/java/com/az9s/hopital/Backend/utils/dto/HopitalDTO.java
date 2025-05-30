package com.az9s.hopital.Backend.utils.dto;

import com.az9s.hopital.Backend.utils.option.HopitalTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HopitalDTO {
    private String uniqueId;
    private String name;
    private String code;
    private String address;
    private String email;
    private HopitalTypeEnum type;
    private String taxCode;
    private String website;
    private String openWork;
    private String closeWork;
    private String logo;
    private String contract;
    private String representName;
    private String representJob;
    
    public void setType(int value) {
        this.type = value == 0 ? HopitalTypeEnum.NHA_NUOC :
                    value == 1 ? HopitalTypeEnum.TU_NHAN :
                    value == 2 ? HopitalTypeEnum.CONG_LAP :
                    value == 3 ? HopitalTypeEnum.QUOC_TE :
                    HopitalTypeEnum.PHONG_KHAM;
    }
}
