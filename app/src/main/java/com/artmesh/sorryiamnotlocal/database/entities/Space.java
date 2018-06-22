package com.artmesh.sorryiamnotlocal.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

@Entity(tableName = "spaces",
		indices = @Index(value = {"identifier"}, unique = true),
		foreignKeys = @ForeignKey(	entity = City.class,
									parentColumns = "id",
									childColumns = "city_id"))

public class Space {

	public Space(Coordinate coordinates, String identifier, String name){
		this.coordinates = coordinates;
		this.identifier = identifier;
		this.name = name;
	}

	@PrimaryKey(autoGenerate = true)
	public long id;


	public String identifier;

	@Embedded
	public Coordinate coordinates;


	public String name;

	@ColumnInfo(name = "city_id")
	public long cityId;


}
