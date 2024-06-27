/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itgarden.reportDTO;

import java.util.*;

/**
 *
 * @author Admin
 */
public class PromotionReportDTO {

    public String gid;

    public String name;

    public String id;

    public Date lastPromotionDate;

    public String yearAgo;

    public PromotionReportDTO() {
    }

    public PromotionReportDTO(String gid, String name, String id, Date lastPromotionDate, String yearAgo) {
        this.gid = gid;
        this.name = name;
        this.id = id;
        this.lastPromotionDate = lastPromotionDate;
        this.yearAgo = yearAgo;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLastPromotionDate() {
        return lastPromotionDate;
    }

    public void setLastPromotionDate(Date lastPromotionDate) {
        this.lastPromotionDate = lastPromotionDate;
    }

    public String getYearAgo() {
        return yearAgo;
    }

    public void setYearAgo(String yearAgo) {
        this.yearAgo = yearAgo;
    }

   

}
