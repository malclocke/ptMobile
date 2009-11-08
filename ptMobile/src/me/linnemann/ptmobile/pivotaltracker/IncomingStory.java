package me.linnemann.ptmobile.pivotaltracker;

import java.util.HashMap;
import java.util.Map;

import me.linnemann.ptmobile.pivotaltracker.fields.StoryData;

import android.content.ContentValues;

/**
 * Story Value
 * 
 * @author niels
 *
 */
public class IncomingStory implements IncomingData {

	private Map<StoryData,String> stringData;
	private DBAdapter db;	
	
	public IncomingStory(DBAdapter db, String project_id, String iteration_number) {
		this.db = db;
		
		stringData = new HashMap<StoryData,String>(); // prepare map
		addDataForKey(StoryData.PROJECT_ID, project_id);
		addDataForKey(StoryData.ITERATION_NUMBER, iteration_number);
	}
	
	public void addDataForKey(Object key, String value) {
		
		if (!stringData.containsKey(key)) {
			stringData.put((StoryData) key, value); // add
		} else {
			String tmp = stringData.get(key);
			stringData.put((StoryData) key, tmp+value);
		}
	}
	
	/**
	 * Get data in a db friendly way
	 * 
	 * @return
	 */
	private ContentValues getDataAsContentValues() {
		ContentValues v = new ContentValues();
		
		for (StoryData f : stringData.keySet()) {
			// --- note: db field name is lowercase!
			v.put(f.getDBFieldName(), stringData.get(f));
		}
		
	    return v;
	}

	/* (non-Javadoc)
	 * @see me.linnemann.ptmobile.pivotaltracker.IncomingData#save()
	 */
	public void save() {
		this.db.insertStory(getDataAsContentValues());
	}
}
