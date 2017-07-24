package com.tiancom.pas.site.basic.data;

import com.tiancom.pas.site.basic.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cities")
public interface CityRepository extends JpaRepository<City, String> {

    City findByProvinceCode(String provinceCode);
}
