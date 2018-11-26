package com.example.databasetesting;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdiaz on 11/26/18.
 */
public class Config {

	public static final String DATABASE_NAME = "sample.db";

	public static final String TABLE_USER = "user";
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_USER_ID = "user_id";

	public static final String TABLE_HISTORY = "history";
	public static final String COLUMN_HISTORY_ID = "history_id";
	public static final String COLUMN_ELEMENT_NAME = "element_name";
	public static final String COLUMN_ELEMENT_ID = "element_id";
	public static final String COLUMN_COUNT = "count";

	public static int getPoints(Context context) {
		List<History> histories = new DatabaseQuery(context).getHistories();
		int points = 0;
		for (History history : histories) {
			points += (history.getCount() * getPointsBy(history.getElementId()));
		}
		return points;
	}

	public static int getPointsBy(int elementId) {
		for (Element element : getElements()) {
			if (elementId == element.getId()) {
				return element.getPoints();
			}
		}
		return 0;
	}

	public static List<Element> getElements() {
		List<Element> elements = new ArrayList<>();
		elements.add(new Element(1, "Mother board", 10));
		elements.add(new Element(2, "Keyboard", 5));
		return elements;
	}
}
