package com.example.backend_test_project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "home_account")
public class HomeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_name")
    private String homeName;

    @Column(name = "creation_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @OneToMany(mappedBy = "household")
    private List<Device> devices = new ArrayList<>();

    @OneToMany(mappedBy = "household")
    private List<User> users = new ArrayList<>();

    public HomeAccount() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHomeName() { return homeName; }
    public void setHomeName(String homeName) { this.homeName = homeName; }

    public LocalDateTime getCreateDate() { return createDate; }
    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }

    public int getNumberOfUsers() {
        return users.size();
    }

    public List<Device> getDevices() { return devices; }
    public void setDevices(List<Device> devices) { this.devices = devices; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; } //Though may not be necessary
}
