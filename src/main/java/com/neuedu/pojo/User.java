package com.neuedu.pojo;

public class User {
    private int id;
    private String userName;
    private String password;
    private String realName;
    private String useType;
    private String docTitleID;
    private String isScheduling;
    private String deptID;
    private String registLeID;
    private String delMark;

    public User() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getUseType() {
        return useType;
    }
    public void setUseType(String useType) {
        this.useType = useType;
    }
    public String getDocTitleID() {
        return docTitleID;
    }
    public void setDocTitleID(String docTitleID) {
        this.docTitleID = docTitleID;
    }
    public String getIsScheduling() {
        return isScheduling;
    }
    public void setIsScheduling(String isScheduling) {
        this.isScheduling = isScheduling;
    }
    public String getDeptID() {
        return deptID;
    }
    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }
    public String getRegistLeID() {
        return registLeID;
    }
    public void setRegistLeID(String registLeID) {
        this.registLeID = registLeID;
    }
    public String getDelMark() {
        return delMark;
    }
    public void setDelMark(String delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", useType='" + useType + '\'' +
                ", docTitleID='" + docTitleID + '\'' +
                ", isScheduling='" + isScheduling + '\'' +
                ", deptID='" + deptID + '\'' +
                ", registLeID='" + registLeID + '\'' +
                ", delMark='" + delMark + '\'' +
                '}';
    }

}

