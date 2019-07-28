/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.entity.Payment
 * @version V1.0
 */
package com.ibm.mosesboot.entity;

import lombok.Data;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Data
public class Payment {
    private Integer year;
    private Double salary;
    private Double number;
    private Double percentage;
    private Double amount;
    private Double incrementAmount;
    private Double deductionAmount;
}
