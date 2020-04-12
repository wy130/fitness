package cn.njxz.fitness.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Admin implements Serializable {
    private Integer aId;

    private String aName;

    private String aPwd;

    private String aSex;

    private Integer aAge;

    private String aPhone;

    private String aEmail;

    private String aType;

    private Date regdate;

    private String aStatus;

    private static final long serialVersionUID = 1L;

}