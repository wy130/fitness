package cn.njxz.fitness.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Employee implements Serializable {
    private Integer eId;

    private String eName;

    private String ePwd;

    private String sal;

    private String describe;

    private static final long serialVersionUID = 1L;


}