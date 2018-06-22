package com.artmesh.sorryiamnotlocal.database;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;

public class SorryApp extends Application {

	public static SorryApp sSorryApp;

	private DataBase mDataBase;

	@Override
	public void onCreate() {
		super.onCreate();

		sSorryApp = this;
		mDataBase = Room.databaseBuilder
				(this,DataBase.class, "DataBase")
				.allowMainThreadQueries()
				.build();
	}

	public static SorryApp getSorryApp() {
		return sSorryApp;
	}

	public DataBase getDataBase() {
		return mDataBase;
	}
}
