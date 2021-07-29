package com.monroe.booking.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Room {

    private int room_id;
    private String type;
    private int is_blocked;

}
