package com.artmesh.sorryiamnotlocal.database.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;


@Entity(tableName = "cities", indices = {@Index(value = {"identifier"}, unique = true)})
public class City {

	public City(String name, String identifier, Border borders, Coordinate coordinates){
		this.name = name;
		this.identifier = identifier;
		this.coordinates = coordinates;
		this.borders = borders;
	}

	@PrimaryKey(autoGenerate = true)
	public long id;

	public String name;

	public String identifier;

	@Embedded
	public Border borders;

	@Embedded
	public Coordinate coordinates;

	@Ignore
	Bitmap picture;

}
