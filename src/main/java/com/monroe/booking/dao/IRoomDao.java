package com.monroe.booking.dao;

import java.sql.SQLException;

public interface IRoomDao {
    public void getRoom () throws SQLException;
    public void createRoom() throws SQLException;
    public void deleteRoom () throws SQLException;
    public void updateRoom () throws SQLException;
}
