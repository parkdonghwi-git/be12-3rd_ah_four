package com.example.apireservation.reservation;


import com.example.admin.user.UserService;
import com.example.apireservation.reservation.model.Reservation;
import com.example.apireservation.reservation.model.ReservationDto;
import com.example.core.common.BaseResponse;
import com.example.hospital.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final UserService userService;
    private final HospitalService hospitalService;

    @PostMapping("/register")
    public BaseResponse<String> register(@RequestBody ReservationDto.requestDto dto) {
        try {
            reservationService.save(Reservation.builder()
                    .user(userService.findById(dto.getUser_id()))
                    .hospital(hospitalService.findById(dto.getHospital_idx()).orElse(null))
                    .name(dto.getName())
                    .build());
        } catch (Exception e) {
            return BaseResponse.error(22001,e.getMessage());
        }
        return BaseResponse.success("ok");
    }

    @GetMapping("/delete/{reservationIdx}")
    public BaseResponse<String> delete(@PathVariable Long reservationIdx) {
        try {
            reservationService.delete(reservationIdx);
        } catch (Exception e) {
            return BaseResponse.error(22002,e.getMessage());
        }
        return BaseResponse.success("ok");
    }


    @GetMapping("/get/{reservationIdx}")
    public BaseResponse<String> getReservation(@PathVariable Long reservationIdx) {
        try {
            reservationService.findByIdx(reservationIdx);
        } catch (Exception e) {
            return BaseResponse.error(22003, e.getMessage());
        }
        return BaseResponse.success("ok");
    }
}
