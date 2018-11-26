package com.example.databasetesting;

/**
 * Created by rdiaz on 11/26/18.
 */
public class Element {

	private int mId;
	private String mName;
	private int mPoints;

	public Element(int id, String name, int points) {
		mId = id;
		mName = name;
		mPoints = points;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public int getPoints() {
		return mPoints;
	}

	public void setPoints(int points) {
		mPoints = points;
	}
}
