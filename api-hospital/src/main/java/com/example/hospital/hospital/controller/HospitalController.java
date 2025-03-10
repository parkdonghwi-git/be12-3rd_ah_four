package com.example.hospital.hospital.controller;

import com.example.core.common.BaseResponse;
import com.example.hospital.hospital.model.Hospital;
import com.example.hospital.hospital.model.HospitalDetailDto;
import com.example.hospital.hospital.model.HospitalDto;
import com.example.hospital.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/list")
    public ResponseEntity<List<HospitalDto.HospitalResponse>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.findAll();

        // Hospital 엔터티를 HospitalResponse DTO로 변환
        List<HospitalDto.HospitalResponse> response = hospitals.stream()
                .map(HospitalDto.HospitalResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{idx}")
//    public ResponseEntity findHospitalById(@PathVariable Long idx) {
//        Optional<Hospital> hospital = hospitalService.findById(idx);
//
//        return ResponseEntity.ok(hospital.get());
//    }

    @PostMapping("/name")
    public ResponseEntity<List<HospitalDto.HospitalResponse>> findHospitalByName(@RequestBody HospitalDto.HospitalRequest dto) {
        List<Hospital> hospitals = hospitalService.findByName(dto.getName());

        List<HospitalDto.HospitalResponse> response = hospitals.stream()
                .map(HospitalDto.HospitalResponse::from)
                .collect(Collectors.toList());

        System.out.println("Response: " + response);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public BaseResponse<HospitalDto.HospitalResponse> register(@RequestBody HospitalDto.HospitalRequest dto) {
        HospitalDto.HospitalResponse hospitalResponse = hospitalService.save(dto);
        return BaseResponse.success(hospitalResponse);
    }
    @GetMapping("/test")
    public BaseResponse<String> test() {
        return BaseResponse.success("ok");
    }

    @GetMapping("/{hospital_idx}")
    public ResponseEntity<HospitalDetailDto.HospitalDetailResponse> findHospitalByIdx(@PathVariable("hospital_idx") Long hospitalIdx) {

        HospitalDetailDto.HospitalDetailResponse hospitalDetail = hospitalService.findHospitalByIdx(hospitalIdx);

        return ResponseEntity.ok(hospitalDetail);
    }

}


