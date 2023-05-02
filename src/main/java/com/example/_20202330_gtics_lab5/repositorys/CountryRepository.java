package com.example._20202330_gtics_lab5.repositorys;

import com.example._20202330_gtics_lab5.entitys.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}