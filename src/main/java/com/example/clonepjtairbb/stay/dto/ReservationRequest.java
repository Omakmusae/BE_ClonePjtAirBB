package com.example.clonepjtairbb.stay.dto;


import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.entity.StayReservation;
import com.example.clonepjtairbb.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class ReservationRequest {
    private DateDto checkinDate;
    private DateDto checkoutDate;
    private Integer groupSize;

    public StayReservation toStayReservationEntity(User user, Stay stay) {
        return new StayReservation(
                user, stay, checkinDate.toCalendar(), checkoutDate.toCalendar(), groupSize
        );
    }
}
