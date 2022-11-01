package com.example.hello.dao;

import com.example.hello.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HospitalDao {

    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // List<Hospital> -- 11만건 hospital
    public void add(Hospital hospital) {
        String sql = "INSERT INTO `likelion-db`.`nation_wide_hospital` (`id`, `open_service_name`, `open_local_government_code`, `management_number`, `license_date`, `business_status`, `business_status_code`, `phone`, `full_address`, `road_name_address`, `hospital_name`, `business_type_name`, `healthcare_provider_count`, `patient_room_number`, `total_number_of_beds`, `total_area`) " +
                "VALUES (?,?,?," +
                "?,?,?," +
                "?,?,?," +
                "?,?,?," +
                "?,?,?," +
                "?);";
//                "VALUES ('2', '의원', '3620002'," +
//                " 'PHMA119993620028841100024', '19990612', '1'," +
//                " '13', '062-525-2875', '광주광역시 북구 풍향동 565번지 4호 3층'," +
//                " '광주광역시 북구 동문대로 24, 3층 (풍향동)', '효치과의원', '치과의원'," +
//                " '1', '0', '0'," +
//                " '52.29');";
        this.jdbcTemplate.update(sql,
                hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(),hospital.getFullAddress(),
                hospital.getRoadNameAddress(),hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(),hospital.getPatientRoomCount(),hospital.getTotalNumberOfBeds(),
                hospital.getTotalAreaSize()
                );

    }
}
