package delivery.service;

import delivery.model.Parcel;

public class ParcelService {

    public void printParcelsReport(Parcel[] parcels) {

        if (parcels == null) {
            System.out.println("No parcels to report");
            return;
        }

        for (Parcel parcel : parcels) {
            parcel.printInfo();
            System.out.println("Delivery price: " + parcel.calculateDeliveryPrice());
            System.out.println();
        }
    }

}