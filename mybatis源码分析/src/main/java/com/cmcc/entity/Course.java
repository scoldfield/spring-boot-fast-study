package com.cmcc.entity;

public class Course {
    private int id;
    private String name; 
    private int deleteFlag;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", deleteFlag="
                + deleteFlag + "]";
    }
}
