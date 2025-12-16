package LLD_Design.problems.CarRentalDesignSystem;

import java.util.Date;

public class Reservations {

    int id;

    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date bookFrom;
    Date bookTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropOffLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;
}
