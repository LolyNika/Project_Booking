package com.monroe.booking.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Booking {

    private int booking_id;
    private LocalDate date;
    private Room room;
    private Guest guest;

}
