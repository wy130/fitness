package cn.njxz.fitness.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer uId;

    private String uName;

    private String uPwd;

    private String uEmail;

    private String uPhone;



    private static final long serialVersionUID = 1L;

}