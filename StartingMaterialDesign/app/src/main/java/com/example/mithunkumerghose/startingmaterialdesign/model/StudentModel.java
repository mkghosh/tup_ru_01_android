package com.example.mithunkumerghose.startingmaterialdesign.model;

/**
 * @author Mithun Kumer Ghose.
 */

public class StudentModel {
    private String stName;
    private String stId;
    private String batchCode;

    public StudentModel(String stName, String stId, String batchCode) {
        this.stName = stName;
        this.stId = stId;
        this.batchCode = batchCode;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getStName() {
        return stName;
    }

    public String getStId() {
        return stId;
    }

    public String getBatchCode() {
        return batchCode;
    }
}
