package com.example.hospital.model;

import com.example.hospital.hospital.model.Hospital;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HospitalDto {
    private Long idx;
    private String name;
    private String address;
    private String type;

    // Entity → DTO 변환
    public static HospitalDto fromEntity(Hospital hospital) {
        return HospitalDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .address(hospital.getAddress())
                .type(hospital.getDepartment())
                .build();
    }
}