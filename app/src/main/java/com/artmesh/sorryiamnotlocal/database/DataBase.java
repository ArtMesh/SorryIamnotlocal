package com.artmesh.sorryiamnotlocal.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.artmesh.sorryiamnotlocal.database.dao.CityDao;
import com.artmesh.sorryiamnotlocal.database.dao.RouteDao;
import com.artmesh.sorryiamnotlocal.database.dao.SpaceDao;
import com.artmesh.sorryiamnotlocal.database.dao.SpacesInRouteDao;
import com.artmesh.sorryiamnotlocal.database.entities.City;
import com.artmesh.sorryiamnotlocal.database.entities.Route;
import com.artmesh.sorryiamnotlocal.database.entities.Space;
import com.artmesh.sorryiamnotlocal.database.entities.SpacesInRoute;

@Database(entities = {City.class, Route.class, Space.class, SpacesInRoute.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
	public abstract CityDao mCityDao();
	public abstract RouteDao mRouteDao();
	public abstract SpaceDao mSpaceDao();
	public abstract SpacesInRouteDao mSpacesInRouteDao();
}
