package com.rfchina.community.entity;

import java.io.Serializable;
import java.util.Optional;

public class PropHouse implements Serializable {

    private Long id;

    private String room;

    private String floor;

    private String build;

    private Long communityId;

    private Integer type;

    private Long letianId;


    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getLetianId() {
        return letianId;
    }

    public void setLetianId(Long letianId) {
        this.letianId = letianId;
    }

    public String getAddr() {
        String addr = Optional.ofNullable(this.build).orElse("")
                + Optional.ofNullable(this.floor).map((value) -> "-" + value).orElse("")
                + Optional.ofNullable(this.room).map((value) -> "-" + value).orElse("");
        return addr;
    }

    @Override
    public String toString() {
        return "PropHouse{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", floor='" + floor + '\'' +
                ", build='" + build + '\'' +
                ", communityId=" + communityId +
                ", type=" + type +
                ", letianId=" + letianId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropHouse propHouse = (PropHouse) o;

        if (id != null ? !id.equals(propHouse.id) : propHouse.id != null) return false;
        if (room != null ? !room.equals(propHouse.room) : propHouse.room != null) return false;
        if (floor != null ? !floor.equals(propHouse.floor) : propHouse.floor != null) return false;
        if (build != null ? !build.equals(propHouse.build) : propHouse.build != null) return false;
        if (communityId != null ? !communityId.equals(propHouse.communityId) : propHouse.communityId != null)
            return false;
        if (type != null ? !type.equals(propHouse.type) : propHouse.type != null) return false;
        return letianId != null ? letianId.equals(propHouse.letianId) : propHouse.letianId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (build != null ? build.hashCode() : 0);
        result = 31 * result + (communityId != null ? communityId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (letianId != null ? letianId.hashCode() : 0);
        return result;
    }
}