package views;

import models.Table;
import models.TableModel;
import presenters.View;
import presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();


    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf(" успешно забронирован. Номер брони #%d\n", reservationNo);
        }
        else {
            System.out.println("Ошибка бронирования. Повторите попытку позже.");
        }
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }


    /**
     * Действия при нажатии клиентом кнопки бронирования столика
     * @param orderData дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date orderData, int tableNo, String name) {
        System.out.println("Возбуждается событие бронирования столика");
        System.out.println("Происходит уведомление наблюдателей...");
        for (ViewObserver observer: observers) {
            observer.onReservationTable(orderData, tableNo, name);
        }
    }

    /**
     * Действия при нажатии клиентом кнопки изменение бронирования столика
     * @param oldReservation номер брони, которую хотим изменить
     * @param orderData новая дата бронирования
     * @param tableNo новый номер столика
     * @param name имя клиента
     */
    public void changeReservationTable(int oldReservation, Date orderData, int tableNo, String name) {
        System.out.println("Возбуждается событие изменение бронирования столика");
        System.out.println("Происходит уведомление наблюдателей...");
        for (ViewObserver observer: observers) {
            observer.onChangeReservationTable(oldReservation, orderData, tableNo, name);
        }
    }

}
