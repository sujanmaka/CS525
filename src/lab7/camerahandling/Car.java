package lab7.camerahandling;

public class Car {
    private String licensePlate;
    private int speed;
    private String cameraId;

    public Car(String licensePlate, int speed, String cameraId) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        this.cameraId = cameraId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpeed() {
        return speed;
    }

    public String getCameraId() {
        return cameraId;
    }
}
