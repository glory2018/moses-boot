package com.ibm.mosesboot.documents.entity;

public class PlanTender {
    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 年
     */
    private String dateYear;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 汇报/请示
     */
    private String projectType;
    /**
     * 采购共享服务中心
     */
    private String projectSign;
    /**
     * XXXX年XX月XX日
     */
    private String dateDayCN;
    /**
     * 部/单位
     */
    private String dept;
    /**
     * 采购内容
     */
    private String procurementContents;
    /**
     * 采购规模
     */
    private String procurementScale;
    /**
     * 预估采购金额
     */
    private String procurementAmount;
    /**
     * 是否首次采购
     */
    private String firstPurchase;
    /**
     * 公开招标/邀请招标；资格预审/资格后审
     */
    private String procurementMode;
    /**
     * 合格制/有限数量制，资格预审项目须填写
     */
    private String pretrialMethod;
    /**
     * 评标方法
     */
    private String evaluationMethod;
    /**
     * 标段划分
     */
    private String bidDivision;
    /**
     * 评标权重分配
     */
    private String evaluationWeight;
    /**
     * 邀请供应商数量
     */
    private String suppliersNumber;
    /**
     * 建议中标供应商数量
     */
    private String winningNumber;
    /**
     * 招标代理机构
     */
    private String biddingAgency;
    /**
     * 技术服务单位
     */
    private String serviceUnit;
    /**
     * 签约完成时间
     * XXXX年XX月
     */
    private String completionTime;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDateYear() {
        return dateYear;
    }

    public void setDateYear(String dateYear) {
        this.dateYear = dateYear;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectSign() {
        return projectSign;
    }

    public void setProjectSign(String projectSign) {
        this.projectSign = projectSign;
    }

    public String getDateDayCN() {
        return dateDayCN;
    }

    public void setDateDayCN(String dateDayCN) {
        this.dateDayCN = dateDayCN;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProcurementContents() {
        return procurementContents;
    }

    public void setProcurementContents(String procurementContents) {
        this.procurementContents = procurementContents;
    }

    public String getProcurementScale() {
        return procurementScale;
    }

    public void setProcurementScale(String procurementScale) {
        this.procurementScale = procurementScale;
    }

    public String getProcurementAmount() {
        return procurementAmount;
    }

    public void setProcurementAmount(String procurementAmount) {
        this.procurementAmount = procurementAmount;
    }

    public String getFirstPurchase() {
        return firstPurchase;
    }

    public void setFirstPurchase(String firstPurchase) {
        this.firstPurchase = firstPurchase;
    }

    public String getProcurementMode() {
        return procurementMode;
    }

    public void setProcurementMode(String procurementMode) {
        this.procurementMode = procurementMode;
    }

    public String getPretrialMethod() {
        return pretrialMethod;
    }

    public void setPretrialMethod(String pretrialMethod) {
        this.pretrialMethod = pretrialMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    public void setEvaluationMethod(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getBidDivision() {
        return bidDivision;
    }

    public void setBidDivision(String bidDivision) {
        this.bidDivision = bidDivision;
    }

    public String getEvaluationWeight() {
        return evaluationWeight;
    }

    public void setEvaluationWeight(String evaluationWeight) {
        this.evaluationWeight = evaluationWeight;
    }

    public String getSuppliersNumber() {
        return suppliersNumber;
    }

    public void setSuppliersNumber(String suppliersNumber) {
        this.suppliersNumber = suppliersNumber;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(String winningNumber) {
        this.winningNumber = winningNumber;
    }

    public String getBiddingAgency() {
        return biddingAgency;
    }

    public void setBiddingAgency(String biddingAgency) {
        this.biddingAgency = biddingAgency;
    }

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }
}
