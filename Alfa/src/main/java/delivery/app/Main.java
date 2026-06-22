package delivery.app;

import delivery.model.ExpressParcel;
import delivery.model.FragileParcel;
import delivery.model.Parcel;
import delivery.service.ParcelService;

public class Main {

    public static void main(String[] args) {

        Parcel regularParcel = new Parcel(
                "Иван",
                "Москва, ул. Ленина, 1",
                2.5,
                "TRK-001"
        );

        FragileParcel fragileParcel = new FragileParcel(
                "Мария",
                "Санкт-Петербург, Невский проспект, 10",
                1.2,
                "TRK-002",
                true
        );

        ExpressParcel expressParcel = new ExpressParcel(
                "Олег",
                "Казань, ул. Баумана, 5",
                3.0,
                "TRK-003",
                12
        );

        Parcel emptyParcel = new Parcel();

        Parcel[] parcels = {regularParcel, fragileParcel, expressParcel, emptyParcel};

        ParcelService parcelService = new ParcelService();
        parcelService.printParcelsReport(parcels);
    }
}