package com.monroe.booking.controller;

import com.monroe.booking.dao.Impl.BookingDaoImpl;
import com.monroe.booking.dao.Impl.GuestDaoImpl;
import com.monroe.booking.dao.Impl.RoomDaoImpl;

import java.util.Scanner;

public class ControllerSwitch {
    public static int entry;
    public void switch_menu(){
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        GuestDaoImpl guestDao = new GuestDaoImpl();
        RoomDaoImpl roomDao = new RoomDaoImpl();
        Scanner scanner = new Scanner(System.in);
        entry = scanner.nextInt();
        switch (entry) {
            case 1:
                bookingDao.createBooking();
                break;
            case 2:
                guestDao.createGuest();
                break;
            case 3:
                roomDao.createRoom();
                break;
            case 4:
                bookingDao.insert_Booking();
                break;
            case 5:
                guestDao.insert_Guest();
                break;
            case 6:
                roomDao.insert_Room();
                break;
            case 7:
                bookingDao.getBooking();
                break;
            case 8:
                guestDao.getGuest();
                break;
            case 9:
                roomDao.getRoom();
                break;
            case 10:
                bookingDao.updateBooking();
                break;
            case 11:
                guestDao.updateGuest();
                break;
            case 12:
                roomDao.updateRoom();
                break;
            case 13:
                bookingDao.deleteBooking();
                break;
            case 14:
                guestDao.deleteGuest();
                break;
            case 15:
                roomDao.deleteRoom();
                break;
            case 16:
                bookingDao.search_Booking();
                break;
        }
    }
}
