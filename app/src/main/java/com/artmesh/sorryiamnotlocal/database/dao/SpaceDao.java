package com.artmesh.sorryiamnotlocal.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.artmesh.sorryiamnotlocal.database.entities.Space;

import java.util.List;

@Dao
public interface SpaceDao {
	@Insert
	void insertSpace(Space space);

	@Query("Select * from spaces where city_id = :cityId")
	List<Space> getAllSpacesInCity(long cityId);

	@Query("select identifier from spaces where city_id = :cityId")
	List<String> getAllIdentifier(long cityId);

	@Query("select * from spaces where id in (:spacesId)")
	List<Space> getSpaces(long[] spacesId);
}
