package com.artmesh.sorryiamnotlocal.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.artmesh.sorryiamnotlocal.database.entities.City;
import com.artmesh.sorryiamnotlocal.database.entities.Route;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CityDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	long insertCity(City city);

	@Query("SELECT * FROM cities where id = :id")
	City getCity(long id);

	@Query("Select * from cities where identifier = :identy")
	City getCity(String identy);

	@Query("select identifier from cities")
	List<String> getAllCitiesIndentifier();

	@Query("select * from cities")
	List<City> getAllCities();

	@Query("SELECT * FROM cities limit 1")
	City loadFirstCity();

	@Query("select * from routes where city_id = :cityId")
	List<Route> getAllRoutesInCity(long cityId);


}
