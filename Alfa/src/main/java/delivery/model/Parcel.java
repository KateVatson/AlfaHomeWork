package delivery.model;

public class Parcel {

    private String recipientName;
    private String deliveryAddress;
    protected double weight;
    String trackingNumber;

    public Parcel(String recipientName, String deliveryAddress, double weight, String trackingNumber) {
        this.recipientName = recipientName;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.trackingNumber = trackingNumber;
    }

    public Parcel() {
        this("Unknown", "Unknown", 0.0, "NO_TRACK");
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateDeliveryPrice() {
        return 100 + weight * 30;
    }

    public void printInfo() {
        System.out.println("Recipient name: " + recipientName);
        System.out.println("Delivery address: " + deliveryAddress);
        System.out.println("Weight: " + weight);
        System.out.println("Tracking number: " + trackingNumber);
    }
}