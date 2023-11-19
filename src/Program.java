import models.Table;
import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.updateTablesUI();
        System.out.println("-".repeat(10));
        bookingView.reservationTable(new Date(), 4, "Надежда");
        System.out.println("-".repeat(10));
        bookingView.reservationTable(new Date(), 1, "Станислав");
        System.out.println("-".repeat(10));
        bookingView.reservationTable(new Date(), 2, "Олег");
        System.out.println("-".repeat(10));

        bookingView.changeReservationTable(1002, new Date(), 5, "Станислав");


    }

}
