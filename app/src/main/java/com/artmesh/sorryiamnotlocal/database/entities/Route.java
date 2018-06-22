package com.artmesh.sorryiamnotlocal.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "routes",
		foreignKeys = @ForeignKey(	entity = City.class,
									parentColumns = "id",
									childColumns = "city_id"))

public class Route {

	@Ignore
	public Route (String name, long cityId){
		this.name = name;
		this.cityId = cityId;
	}

	public Route (long cityId){
		this.name = "New Route";
		this.cityId = cityId;
	}

	@PrimaryKey(autoGenerate = true)
	public long id;

	public String name;

	@ColumnInfo(name = "city_id")
	public long cityId;

}
