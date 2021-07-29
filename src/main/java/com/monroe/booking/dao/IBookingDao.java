package com.monroe.booking.dao;

import com.monroe.booking.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface IBookingDao {
    public List<Booking> getBooking () throws SQLException;
    public void createBooking() throws SQLException;
    public void deleteBooking () throws SQLException;
    public void updateBooking () throws SQLException;

}
