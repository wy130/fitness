package cn.njxz.fitness.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Integer uiUId;

    private String uiBirth;

    private String uiSex;

    private String uiHeight;

    private String uiWeight;

    private String image;

    private static final long serialVersionUID = 1L;

    public Integer getUiUId() {
        return uiUId;
    }

    public void setUiUId(Integer uiUId) {
        this.uiUId = uiUId;
    }

    public String getUiBirth() {
        return uiBirth;
    }

    public void setUiBirth(String uiBirth) {
        this.uiBirth = uiBirth == null ? null : uiBirth.trim();
    }

    public String getUiSex() {
        return uiSex;
    }

    public void setUiSex(String uiSex) {
        this.uiSex = uiSex == null ? null : uiSex.trim();
    }

    public String getUiHeight() {
        return uiHeight;
    }

    public void setUiHeight(String uiHeight) {
        this.uiHeight = uiHeight == null ? null : uiHeight.trim();
    }

    public String getUiWeight() {
        return uiWeight;
    }

    public void setUiWeight(String uiWeight) {
        this.uiWeight = uiWeight == null ? null : uiWeight.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
        UserInfo other = (UserInfo) that;
        return (this.getUiUId() == null ? other.getUiUId() == null : this.getUiUId().equals(other.getUiUId()))
            && (this.getUiBirth() == null ? other.getUiBirth() == null : this.getUiBirth().equals(other.getUiBirth()))
            && (this.getUiSex() == null ? other.getUiSex() == null : this.getUiSex().equals(other.getUiSex()))
            && (this.getUiHeight() == null ? other.getUiHeight() == null : this.getUiHeight().equals(other.getUiHeight()))
            && (this.getUiWeight() == null ? other.getUiWeight() == null : this.getUiWeight().equals(other.getUiWeight()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUiUId() == null) ? 0 : getUiUId().hashCode());
        result = prime * result + ((getUiBirth() == null) ? 0 : getUiBirth().hashCode());
        result = prime * result + ((getUiSex() == null) ? 0 : getUiSex().hashCode());
        result = prime * result + ((getUiHeight() == null) ? 0 : getUiHeight().hashCode());
        result = prime * result + ((getUiWeight() == null) ? 0 : getUiWeight().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uiUId=").append(uiUId);
        sb.append(", uiBirth=").append(uiBirth);
        sb.append(", uiSex=").append(uiSex);
        sb.append(", uiHeight=").append(uiHeight);
        sb.append(", uiWeight=").append(uiWeight);
        sb.append(", image=").append(image);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}