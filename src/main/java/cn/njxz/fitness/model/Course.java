package cn.njxz.fitness.model;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer cId;

    private String cName;

    private String cLength;

    private Integer cClId;

    private Integer cCoId;

    private Integer cCtId;

    private String description;

    private String image;

    private Integer cEpId;

    private Integer cStatus;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcLength() {
        return cLength;
    }

    public void setcLength(String cLength) {
        this.cLength = cLength == null ? null : cLength.trim();
    }

    public Integer getcClId() {
        return cClId;
    }

    public void setcClId(Integer cClId) {
        this.cClId = cClId;
    }

    public Integer getcCoId() {
        return cCoId;
    }

    public void setcCoId(Integer cCoId) {
        this.cCoId = cCoId;
    }

    public Integer getcCtId() {
        return cCtId;
    }

    public void setcCtId(Integer cCtId) {
        this.cCtId = cCtId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getcEpId() {
        return cEpId;
    }

    public void setcEpId(Integer cEpId) {
        this.cEpId = cEpId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.getcLength() == null ? other.getcLength() == null : this.getcLength().equals(other.getcLength()))
            && (this.getcClId() == null ? other.getcClId() == null : this.getcClId().equals(other.getcClId()))
            && (this.getcCoId() == null ? other.getcCoId() == null : this.getcCoId().equals(other.getcCoId()))
            && (this.getcCtId() == null ? other.getcCtId() == null : this.getcCtId().equals(other.getcCtId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getcEpId() == null ? other.getcEpId() == null : this.getcEpId().equals(other.getcEpId()))
            && (this.getcStatus() == null ? other.getcStatus() == null : this.getcStatus().equals(other.getcStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((getcLength() == null) ? 0 : getcLength().hashCode());
        result = prime * result + ((getcClId() == null) ? 0 : getcClId().hashCode());
        result = prime * result + ((getcCoId() == null) ? 0 : getcCoId().hashCode());
        result = prime * result + ((getcCtId() == null) ? 0 : getcCtId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getcEpId() == null) ? 0 : getcEpId().hashCode());
        result = prime * result + ((getcStatus() == null) ? 0 : getcStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", cName=").append(cName);
        sb.append(", cLength=").append(cLength);
        sb.append(", cClId=").append(cClId);
        sb.append(", cCoId=").append(cCoId);
        sb.append(", cCtId=").append(cCtId);
        sb.append(", description=").append(description);
        sb.append(", image=").append(image);
        sb.append(", cEpId=").append(cEpId);
        sb.append(", cStatus=").append(cStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}