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
public class SalaryVo {
    private Double salary;
    private Integer incrementFrequently;
    private Double increment;
    private Integer deductionFrequently;
    private Double deduction;
    private Integer prediction;
}
