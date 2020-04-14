package cn.njxz.fitness.model;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {
    private Integer rId;

    private Integer rCId;

    private Date rTime;

    private Integer rUId;

    private static final long serialVersionUID = 1L;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getrCId() {
        return rCId;
    }

    public void setrCId(Integer rCId) {
        this.rCId = rCId;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getrUId() {
        return rUId;
    }

    public void setrUId(Integer rUId) {
        this.rUId = rUId;
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
        Record other = (Record) that;
        return (this.getrId() == null ? other.getrId() == null : this.getrId().equals(other.getrId()))
            && (this.getrCId() == null ? other.getrCId() == null : this.getrCId().equals(other.getrCId()))
            && (this.getrTime() == null ? other.getrTime() == null : this.getrTime().equals(other.getrTime()))
            && (this.getrUId() == null ? other.getrUId() == null : this.getrUId().equals(other.getrUId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getrId() == null) ? 0 : getrId().hashCode());
        result = prime * result + ((getrCId() == null) ? 0 : getrCId().hashCode());
        result = prime * result + ((getrTime() == null) ? 0 : getrTime().hashCode());
        result = prime * result + ((getrUId() == null) ? 0 : getrUId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rId=").append(rId);
        sb.append(", rCId=").append(rCId);
        sb.append(", rTime=").append(rTime);
        sb.append(", rUId=").append(rUId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}