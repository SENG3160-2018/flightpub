package com.flightpub.base.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Airlines
 *
 * Entity object mapped to Airlines DB table
 */
@Entity
@Table(name = "Reviews")
public class Review {
    private int id;
    private String uiNavigation;
    private int rating;
    private String siteNavigation;
    private String recommendation;
    private Date created;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ui_navigation")
    public String getUiNavigation() {
        return uiNavigation;
    }
    public void setUiNavigation(String uiNavigation) {
        this.uiNavigation = uiNavigation;
    }

    @Basic
    @Column(name = "website_rating")
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "site_navigation")
    public String getSiteNavigation() {
        return siteNavigation;
    }
    public void setSiteNavigation(String siteNavigation) {
        this.siteNavigation = siteNavigation;
    }

    @Basic
    @Column(name = "recommendation")
    public String getRecommendation() {
        return recommendation;
    }
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Basic
    @Column(name = "created_at")
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
}
