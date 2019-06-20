package com.rfchina.community.persistence.model;

import java.io.Serializable;
import java.util.Date;

public class RepairRemark implements Serializable {
    private Long id;

    private Long repairRecordId;

    private Integer score;

    private String scoreContent;

    private String scoreMedia;

    private Date scoreTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRepairRecordId() {
        return repairRecordId;
    }

    public void setRepairRecordId(Long repairRecordId) {
        this.repairRecordId = repairRecordId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreContent() {
        return scoreContent;
    }

    public void setScoreContent(String scoreContent) {
        this.scoreContent = scoreContent;
    }

    public String getScoreMedia() {
        return scoreMedia;
    }

    public void setScoreMedia(String scoreMedia) {
        this.scoreMedia = scoreMedia;
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", repairRecordId=").append(repairRecordId);
        sb.append(", score=").append(score);
        sb.append(", scoreContent=").append(scoreContent);
        sb.append(", scoreMedia=").append(scoreMedia);
        sb.append(", scoreTime=").append(scoreTime);
        sb.append("]");
        return sb.toString();
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
        RepairRemark other = (RepairRemark) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRepairRecordId() == null ? other.getRepairRecordId() == null : this.getRepairRecordId().equals(other.getRepairRecordId()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getScoreContent() == null ? other.getScoreContent() == null : this.getScoreContent().equals(other.getScoreContent()))
            && (this.getScoreMedia() == null ? other.getScoreMedia() == null : this.getScoreMedia().equals(other.getScoreMedia()))
            && (this.getScoreTime() == null ? other.getScoreTime() == null : this.getScoreTime().equals(other.getScoreTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRepairRecordId() == null) ? 0 : getRepairRecordId().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getScoreContent() == null) ? 0 : getScoreContent().hashCode());
        result = prime * result + ((getScoreMedia() == null) ? 0 : getScoreMedia().hashCode());
        result = prime * result + ((getScoreTime() == null) ? 0 : getScoreTime().hashCode());
        return result;
    }
}