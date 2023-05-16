package com.example.clonepjtairbb.stay.entity;

import com.example.clonepjtairbb.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Entity
@Getter
@NoArgsConstructor
public class StayReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Stay stay;

    private Calendar checkinDate;

    private Calendar checkoutDate;

    private Integer groupSize;

    public StayReservation(
            User user, Stay stay, Calendar checkinDate, Calendar checkoutDate, Integer groupSize
    ) {
        this.user = user;
        this.stay = stay;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.groupSize = groupSize;
    }
}
