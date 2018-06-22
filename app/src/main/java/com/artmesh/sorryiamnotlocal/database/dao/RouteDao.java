package com.artmesh.sorryiamnotlocal.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.artmesh.sorryiamnotlocal.database.entities.Route;

@Dao
public interface RouteDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	long insertRoute(Route route);

	@Query("select * from routes where id = :id")
	Route getRoute(long id);
}
