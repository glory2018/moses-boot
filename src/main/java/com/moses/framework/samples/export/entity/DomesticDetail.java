package com.moses.framework.samples.export.entity;

public class DomesticDetail {
    private Integer id;
    private Integer domesticId;
    private String riskName;
    private String confmAmount;
    private String dD;
    private String confmPrem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDomesticId() {
        return domesticId;
    }

    public void setDomesticId(Integer domesticId) {
        this.domesticId = domesticId;
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

    public String getdD() {
        return dD;
    }

    public void setdD(String dD) {
        this.dD = dD == null ? null : dD.trim();
    }

    public String getConfmPrem() {
        return confmPrem;
    }

    public void setConfmPrem(String confmPrem) {
        this.confmPrem = confmPrem == null ? null : confmPrem.trim();
    }
}