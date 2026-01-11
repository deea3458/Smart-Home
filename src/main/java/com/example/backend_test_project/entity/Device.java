package com.example.backend_test_project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_uid") // UID = Unique ID
    private String deviceUId;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "in_use")
    private Boolean inUse = false;  // If it has not been assigned to a household == false

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "status")
    private Boolean status;  // Because it's just on/off

    @Column(name = "last_seen")
    private LocalDateTime lastSeen = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_id")
    private HomeAccount household;

    public Device() {}

    //getters and setters
    public Long getId() { return id; };
    public Long setId(Long id) { this.id = id; return id; };

    public String getDeviceUId() { return deviceUId; };
    public void setDeviceUId(String deviceUId) { this.deviceUId = deviceUId; };

    public String getDeviceType() { return deviceType; };
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; };

    public String getApiKey() { return apiKey; };
    public void setApiKey(String apiKey) { this.apiKey = apiKey; };

    public Boolean getInUse() { return inUse; }
    public void setInUse(Boolean inUse) { this.inUse = inUse; }

    public boolean getStatus() { return status; };
    public void setStatus(Boolean status) { this.status = status; };

    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; };

    public HomeAccount getHousehold() { return household; }
    public void setHousehold(HomeAccount household) { this.household = household; }

}
