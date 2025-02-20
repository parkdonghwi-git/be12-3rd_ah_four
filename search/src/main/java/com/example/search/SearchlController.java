package com.example.search;

import com.example.hospital.model.Hospital;
import com.example.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchlController {

    private final SearchService searchService;

    // 모든 병원 조회
    @GetMapping
    public List<Hospital> getAllSearch() {
        return hospitalService.getAllSearch();
    }

    // 이름으로 병원 검색
    @GetMapping("/search")
    public List<Hospital> searchByName(@RequestParam String name) {
        return hospitalService.searchByName(name);
    }

    // 주소로 병원 검색
    @GetMapping("/search/address")
    public List<Hospital> searchByAddress(@RequestParam String address) {
        return hospitalService.searchByAddress(address);
    }