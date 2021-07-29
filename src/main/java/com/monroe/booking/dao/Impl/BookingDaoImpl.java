package com.monroe.booking.dao.Impl;

import com.monroe.booking.dao.IBookingDao;
import com.monroe.booking.model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.monroe.booking.dao.Impl.ConnectionPool.printSQLException;

public class BookingDaoImpl implements IBookingDao {

    private static final String createTableBOOKING = "CREATE TABLE `booking`.`booking` (\n" +
            "  `id_booking` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `datetime` VARCHAR(25) NOT NULL,\n" +
            "  PRIMARY KEY (`id_booking`));";

    private static final String insert_Booking = "INSERT INTO `booking`.`booking` " +
            "(`id_booking`, `datetime`) VALUES " +
            "(?, NOW());\n";
    private static final String update_Booking = "UPDATE booking.booking SET date = ? WHERE id_booking = ?;";

    private static final String getFULL_booking = "SELECT * FROM booking.booking INNER JOIN booking.guest INNER JOIN booking.room " +
            "ON booking.id_booking = guest.id_guest " +
            "WHERE  booking.id_booking = guest.id_guest " +
            "AND booking.id_booking = room.id_room;";

    private static final String search = "SELECT * FROM booking.booking WHERE id_booking = ";

    private static final String delete = "DELETE FROM booking.booking WHERE id_booking = ";

    Scanner scanner = new Scanner(System.in);
    java.util.Date today = new java.util.Date();
    long t = today.getTime();

    @Override
    public List<Booking> getBooking() {
//        List<Booking> bookings1 = new ArrayList<Booking>();
//        for (Booking booking1 : bookings) {
//            System.out.println(" Id booking:" + booking1.getBooking_id() + "; Id комнаты: " + booking1.getRoom().getRoom_id() + "; Комната заблокирована(1-да, 0-нет): " + booking1.getRoom().getIs_blocked()
//                    + "; Тип комнаты: " + booking1.getRoom().getType() + "; Id гостя: " + booking1.getGuest().getGuest_id() + "; Email гостя: " + booking1.getGuest().getMail() + "; Имя гостя: " + booking1.getGuest().getNickname());
//
//        }
//        return bookings1;
        List<Booking> bookings = null;
        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(getFULL_booking);) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_b = rs.getInt("id_booking");
                String datetime = rs.getString("datetime");
                int id_g = rs.getInt("id_booking");
                String nickname = rs.getString("nickname");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int id_room = rs.getInt("id_room");
                String type = rs.getString("type");
                int is_blocked = rs.getInt("is_blocked");

                System.out.println(id_b + "," + datetime + "," + id_g + "," + nickname + "," + password + "," + email + "," + id_room + "," + type + "," + is_blocked);
            }
            System.out.println("Successfully Join tables");
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bookings;
    }

    @Override
    public void createBooking() {

        System.out.println(createTableBOOKING);

        try (Connection connection = ConnectionPool.createNewDBconnection();

             Statement statement = connection.createStatement();) {

            statement.execute(createTableBOOKING);
            System.out.println("Successfully added table Booking");
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    @Override
    public void deleteBooking() {
        System.out.println("Введите id который нужно удалить");
        int number = scanner.nextInt();

        String delete_from_Booking = delete + number;

        System.out.println(delete_from_Booking);

        try (Connection connection = ConnectionPool.createNewDBconnection();

             Statement statement = connection.createStatement();) {

            int result = statement.executeUpdate(delete_from_Booking);
            System.out.println("Number of records affected :: " + result);
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    @Override
    public void updateBooking() {

//        System.out.println("Введите свой id");
//        int upd_id_b = scanner.nextInt();
//        System.out.println("Введите новую дату");
//        String upd_date = scanner.next();
//
//        try (Connection connection = ConnectionPool.createNewDBconnection();
//
//             PreparedStatement preparedStatement = connection.prepareStatement(update_Booking)) {
//            preparedStatement.setString(1, upd_date);
//            preparedStatement.setInt(2, upd_id_b);
//
//            System.out.println(preparedStatement);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//
//            printSQLException(e);
//        }
    }

    public void insert_Booking() {

        System.out.println("Введите id");
        int ins_id_b = scanner.nextInt();
//        System.out.println("Введите дату");
//        String ins_date = scanner.next();
//        long t = today.getTime();
        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(insert_Booking)) {
            preparedStatement.setInt(1, ins_id_b);
//            preparedStatement.setDate(2, new java.sql.Date(t));

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void search_Booking() {
        int number_id;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите id для поиска записи");
        number_id = scanner1.nextInt();
        String search_Booking = search + number_id;


        System.out.println(search_Booking);

        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(search_Booking);) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_booking");
                String datetime = rs.getString("datetime");

                System.out.println(id + "," + datetime);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
