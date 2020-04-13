package cn.njxz.fitness.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Admin implements Serializable {
    private Integer aId;

    private String aName;

    private String aPwd;

    private String aPhone;

    private String aType;

    private String aStatus;

    private static final long serialVersionUID = 1L;

}