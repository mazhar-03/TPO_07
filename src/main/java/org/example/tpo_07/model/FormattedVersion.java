package org.example.tpo_07.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FormattedVersion implements Serializable {
    private String id;
    private String originalVersion;
    private String formattedVersion;
    private LocalDateTime creationTime;
    private int expireInSeconds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalVersion() {
        return originalVersion;
    }

    public void setOriginalVersion(String originalVersion) {
        this.originalVersion = originalVersion;
    }

    public String getFormattedVersion() {
        return formattedVersion;
    }

    public void setFormattedVersion(String formattedVersion) {
        this.formattedVersion = formattedVersion;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public int getExpireInSeconds() {
        return expireInSeconds;
    }

    public void setExpireInSeconds(int expireInSeconds) {
        this.expireInSeconds = expireInSeconds;
    }
}
