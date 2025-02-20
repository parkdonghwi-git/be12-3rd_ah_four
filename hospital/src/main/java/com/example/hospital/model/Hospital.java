package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idx자동으로 증가
    private Long idx;
    @Column(nullable = false, length = 100)
    private String name;  // 병원 이름
    @Column(nullable = false, length = 255)
    private String address;  // 주소
    @Column(nullable = false, length = 100)
    private String type;  // 진료 과목


}
