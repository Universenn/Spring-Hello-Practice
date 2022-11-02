package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.parser.ReadLineContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospital")
@Slf4j
public class HospitalController {
    private final HospitalDao hospitalDao;
    private final ReadLineContext<Hospital> hospitalReadLineContext;

    public HospitalController(HospitalDao hospitalDao, ReadLineContext<Hospital> hospitalReadLineContext) {
        this.hospitalDao = hospitalDao;
        this.hospitalReadLineContext = hospitalReadLineContext;
    }

    @PostMapping("/all")
    public String insertAll() throws IOException {
        List<Hospital> hospitalList = hospitalReadLineContext.readByLine("./hospital_data.csv");
        for(Hospital hospital : hospitalList) {
            hospitalDao.add(hospital);
        }

        return "데이터 insert 성공";
    }


    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable Integer id){
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);

        if (!opt.isEmpty()) {
            return ResponseEntity.ok().body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }

    }

    @DeleteMapping("/deleteAll")
    public void delete(){
        hospitalDao.deleteAll();
    }

}