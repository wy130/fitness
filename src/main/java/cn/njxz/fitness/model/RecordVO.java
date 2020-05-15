package cn.njxz.fitness.model;

import lombok.Data;

/**
 * @author yue.wu
 * @Description
 * @date 2020/5/15 14:58
 */
@Data
public class RecordVO {
    private Integer rId;
    private Integer cId;

    private String cName;

    private String cLength;
    private String image;
}
