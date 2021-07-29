package com.monroe.booking.view;

import com.monroe.booking.model.Booking;
import com.monroe.booking.model.Guest;

import java.util.Scanner;

public class View {

    public static void menu() {
        System.out.println("1) Создать таблицу Booking");
        System.out.println("2) Создать таблицу Guest");
        System.out.println("3) Создать таблицу Room");
        System.out.println("4) Добавить данные в таблицу Booking");
        System.out.println("5) Добавить данные в таблицу Guest");
        System.out.println("6) Добавить данные в таблицу Room");
        System.out.println("7) Получить данные из таблицы Booking");
        System.out.println("8) Получить данные из таблицы Guest");
        System.out.println("9) Получить данные из таблицы Room");
        System.out.println("10) Обновить данные в таблице Booking");
        System.out.println("11) Обновить данные в таблице Guest");
        System.out.println("12) Обновить данные в таблице Room");
        System.out.println("13) Удалить запись в таблице Booking ПО ID!!");
        System.out.println("14) Удалить запись в таблице Guest");
        System.out.println("15) Удалить запись в таблице Room");
        System.out.println("16) Поиск в таблице Booking по ID!!!");
    }

    public void entranceAcc() {
        System.out.println("Вход в аккаунт");
        System.out.println("1 - Создать новый аккаунт");
        System.out.println("2 - Войти в аккаунт");
    }

    public void accountLogin() {
        System.out.println("ВХОД В АККАУНТ");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String nickname = scanner.next();
        System.out.println("Введите пароль: ");
        String password = scanner.next();

        System.out.println("Введите имя: " + nickname);
        System.out.println("Введите пароль: " + password);


//        if (nickname == ){
//            System.out.println("You`re finally access");
//        } else {
//            System.out.println("Error to access");
//        }
        System.out.println("Вы успешно вошли в аккаунт");
    }

    public void createAccount(){

    }

    public void searchRoom(Integer room_id) {
        System.out.println();
    }
}
