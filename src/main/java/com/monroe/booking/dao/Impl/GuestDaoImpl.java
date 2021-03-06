package com.monroe.booking.dao.Impl;

import com.monroe.booking.dao.IGuestDao;
import com.monroe.booking.model.Booking;
import com.monroe.booking.model.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.monroe.booking.dao.Impl.ConnectionPool.printSQLException;

public class GuestDaoImpl implements IGuestDao {

    private static final String createTableGUEST = "CREATE TABLE `booking`.`guest` (\n" +
            "  `id_guest` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `nickname` VARCHAR(25) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id_guest`));";

    private static final String select_Guest = "SELECT * FROM booking.guest;";

    private static final String insert_Guest = "INSERT INTO `booking`.`guest`" +
            "(`id_guest`, `nickname`, `password`, `email`) VALUES " +
            "(?, ?, ?, ?);";

    private static final String update_Guest = "UPDATE booking.guest SET nickname = ?, password = ?, email = ? WHERE id_guest = ?";

    private static final String delete_from_Guest = "DELETE FROM booking.guest WHERE id_guest = ";

    Scanner scanner = new Scanner(System.in);

    @Override
    public void getGuest() {
        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(select_Guest);) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_guest");
                String nickname = rs.getString("nickname");
                String password = rs.getString("password");
                String email = rs.getString("email");

                System.out.println(id + "," + nickname + "," + password + "," + email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void createGuest() {
        System.out.println(createTableGUEST);

        try (Connection connection = ConnectionPool.createNewDBconnection();

             Statement statement = connection.createStatement();) {

            statement.execute(createTableGUEST);
            System.out.println("Successfully added table Guest");
        } catch (SQLException e) {

            printSQLException(e);
        }

    }

    @Override
    public void deleteGuest() {

        System.out.println("?????????????? ???????? id");
        int upd_id_g = scanner.nextInt();

        String delete_Guest = delete_from_Guest + upd_id_g;
        try (Connection connection = ConnectionPool.createNewDBconnection();

             Statement statement = connection.createStatement();) {

            int result = statement.executeUpdate(delete_Guest);
            System.out.println("Number of records affected :: " + result);
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    @Override
    public void updateGuest() {
        System.out.println("?????????????? ???????? id");
        int upd_id_g = scanner.nextInt();
        System.out.println("?????????????? ???????? nickname");
        String upd_nick_g = scanner.next();
        System.out.println("?????????????? ???????? password");
        String upd_pass_g = scanner.next();
        System.out.println("?????????????? ???????? email");
        String upd_email_g = scanner.next();


        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(update_Guest)) {
            preparedStatement.setString(1, upd_nick_g);
            preparedStatement.setString(2, upd_pass_g);
            preparedStatement.setString(3, upd_email_g);
            preparedStatement.setInt(4, upd_id_g);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    public void insert_Guest(){
        System.out.println("?????????????? ???????? id");
        int ins_id_g = scanner.nextInt();
        System.out.println("?????????????? ???????? nickname");
        String ins_nick_g = scanner.next();
        System.out.println("?????????????? ???????? password");
        String ins_pass_g = scanner.next();
        System.out.println("?????????????? ???????? email");
        String ins_email_g = scanner.next();

        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(insert_Guest)) {
            preparedStatement.setInt(1, ins_id_g);
            preparedStatement.setString(2, ins_nick_g);
            preparedStatement.setString(3, ins_pass_g);
            preparedStatement.setString(4, ins_email_g);
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}




//    Booking booking = new Booking ();
//    Guest searchGuest = new Guest ();
//
//    public void searchAccount (){
//        System.out.println("???????? ?? ??????????????");
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("?????????????? ??????: ");
//        String nickname = scanner.next();
//        System.out.println("?????????????? ????????????: ");
//        String password = scanner.next();
//
//        booking.searchGuests(nickname, password);
//        //for (int i = 0; i < booking.getGuests().size(); i++) {
////        if(nickname.equals(searchGuest.getNickname()) && password.equals(searchGuest.getPassword())) {
////                System.out.println("???????????????????? ??????????????");
////        } else {
////            System.out.println("???????????????????? ???? ??????????????");
////        }
//    //}
//    }
//
//    @Override
//    public void getGuest() {
//        //System.out.println(guest.toString());
//
//        System.out.println(booking.getGuests().toString());
//////        Booking getGuestsView = new Booking();
////        //getGuestsView.getGuests();
////
////        System.out.println("???????????????????? ?? ????????????????:");
////        for (int i = 0; i < book.getGuests().size(); i++) {
////            System.out.println(book.getGuests().get(i));
////        }
//    }
//
//    @Override
//    public void createGuest() {
//
//        System.out.println("?????????????????????? ????????????????");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("?????????????? ??????:");
//        String nickname = scanner.next();
//        System.out.println("?????????????? ????????????:");
//        String password = scanner.next();
//        System.out.println("?????????????? ??????????:");
//        String mail = scanner.next();
//        Guest guest = new Guest(nickname, password, mail);
////        ArrayList<Guest> guestsLogin = new ArrayList<>();
////        guestsLogin.add(guest);
//
////        guest.setMail(mail);
////        guest.setNickname(nickname);
////        guest.setPassword(mail);
//
//        booking.addGuest(nickname, password, mail);
//        System.out.println("???? ?????????????? ???????????????????????????????????? ???? ?????????? CyberBOOLING");
//
////        ArrayList<Guest> inta = booking.addGuest(nickname, password, mail);
////        booking.setGuests(guestsLogin);
//        System.out.println("???????????????????? ?? ????????????????:");
//        for (int i = 0; i < booking.getGuests().size(); i++) {
//            System.out.println(booking.getGuests().get(i));
//        }
//    }
