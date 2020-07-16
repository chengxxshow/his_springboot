package com.neuedu.pojo;

public class Department {
    private Integer id;

    private String deptcode;

    private String deptname;

    private Integer deptcategoryid;

    private Integer depttype;

    private Integer delmark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getDeptcategoryid() {
        return deptcategoryid;
    }

    public void setDeptcategoryid(Integer deptcategoryid) {
        this.deptcategoryid = deptcategoryid;
    }

    public Integer getDepttype() {
        return depttype;
    }

    public void setDepttype(Integer depttype) {
        this.depttype = depttype;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}