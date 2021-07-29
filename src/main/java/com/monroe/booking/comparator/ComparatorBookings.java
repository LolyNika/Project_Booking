package com.monroe.booking.comparator;

import com.monroe.booking.model.Booking;
import com.monroe.booking.model.Guest;

import java.util.Comparator;

public class ComparatorBookings implements Comparator<Guest> {

    @Override
    public int compare(Guest a, Guest b) {
        return a.getNickname().toUpperCase().compareTo(b.getNickname().toUpperCase());
    }
}
