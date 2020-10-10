package com.moses.framework.samples.export.entity;

public class AbroadDetail {
    private Integer id;
    private Integer insuranceId;
    private String riskName;
    private String confmAmount;
    private String deductible;
    private String confmPrem;
    private String shareCNPC;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName == null ? null : riskName.trim();
    }

    public String getConfmAmount() {
        return confmAmount;
    }

    public void setConfmAmount(String confmAmount) {
        this.confmAmount = confmAmount == null ? null : confmAmount.trim();
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible == null ? null : deductible.trim();
    }

    public String getConfmPrem() {
        return confmPrem;
    }

    public void setConfmPrem(String confmPrem) {
        this.confmPrem = confmPrem == null ? null : confmPrem.trim();
    }

    public String getShareCNPC() {
        return shareCNPC;
    }

    public void setShareCNPC(String shareCNPC) {
        this.shareCNPC = shareCNPC;
    }
}