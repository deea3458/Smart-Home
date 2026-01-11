package com.example.backend_test_project.dto.request;

public class DeviceHelloRequest {

    private String deviceUId;
    private String deviceType;
    private String apiKey;


    public String getDeviceUId() {
        return deviceUId;
    }
    public void setDeviceUId(String deviceUId) {
        this.deviceUId = deviceUId;
    }


    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }


    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
