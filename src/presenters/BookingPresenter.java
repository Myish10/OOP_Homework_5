package presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver{

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTablesUI() {
        view.showTables(model.loadTables());
    }

    @Override
    public void onReservationTable(Date orderData, int tableNo, String name) {
        System.out.println("Презентер реагирует на событие");
        try {
            int reservationNo = model.reservationTable(orderData, tableNo, name);
            view.showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e) {
            view.showReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date orderData, int tableNo, String name) {
        System.out.println("Презентер реагирует на событие");
        try {
            int reservationNo1 = model.changeReservationTable(oldReservation, orderData, tableNo, name);
            view.showReservationTableResult(reservationNo1);
        }
        catch (RuntimeException e) {
            view.showReservationTableResult(-1);
        }
    }
}
