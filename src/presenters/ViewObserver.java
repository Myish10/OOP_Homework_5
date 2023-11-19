package presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderData, int tableNo, String name);
    void onChangeReservationTable(int oldReservation, Date orderData, int tableNo, String name);

}
