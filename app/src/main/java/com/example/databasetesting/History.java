package com.example.databasetesting;

/**
 * Created by rdiaz on 11/26/18.
 */
public class History {

	private int mId, mElementId;
	private String mElementName;
	private int mCount;

	public History(int id, int elementId, String elementName, int count) {
		mId = id;
		mElementId = elementId;
		mElementName = elementName;
		mCount = count;
	}

	public int getId() {
		return mId;
	}

	public int getElementId() {
		return mElementId;
	}

	public void setElementId(int elementId) {
		mElementId = elementId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getElementName() {
		return mElementName;
	}

	public void setElementName(String elementName) {
		mElementName = elementName;
	}

	public int getCount() {
		return mCount;
	}

	public void setCount(int count) {
		mCount = count;
	}
}
