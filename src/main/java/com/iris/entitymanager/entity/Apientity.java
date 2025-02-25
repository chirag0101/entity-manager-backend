package com.iris.entitymanager.entity;

import com.iris.entitymanager.dto.ApiResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_API")
public class Apientity {
    @Id
    @Column(name = "API_NAME")
    private String apiName;

    @Column(name = "API_URL")
    private String apiUrl;

    public Apientity(){}

    public Apientity(String apiName, String apiUrl) {
        this.apiName = apiName;
        this.apiUrl = apiUrl;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
