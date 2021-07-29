package com.monroe.booking.dao;

import java.sql.SQLException;

public interface IGuestDao {
    public void getGuest () throws SQLException;
    public void createGuest () throws SQLException;
    public void deleteGuest () throws SQLException;
    public void updateGuest () throws SQLException;
}
