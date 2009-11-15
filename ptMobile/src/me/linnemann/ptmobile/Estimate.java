package me.linnemann.ptmobile;

import me.linnemann.ptmobile.cursor.StoriesCursor;
import me.linnemann.ptmobile.pivotaltracker.PivotalTracker;
import me.linnemann.ptmobile.pivotaltracker.Story;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Estimate extends Activity {

	private static final String TAG="Estimate";
	private String project_id;
	private String story_id;

	private Button b0,b1,b2,b3,b4,b5;

	private StoriesCursor c;
	private PivotalTracker tracker;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estimate);

		b0 = (Button) this.findViewById(R.id.ButtonEstimate0);
		b1 = (Button) this.findViewById(R.id.ButtonEstimate1);
		b2 = (Button) this.findViewById(R.id.ButtonEstimate2);
		b3 = (Button) this.findViewById(R.id.ButtonEstimate3);
		b4 = (Button) this.findViewById(R.id.ButtonEstimate4);
		b5 = (Button) this.findViewById(R.id.ButtonEstimate5);

		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			Log.i(Stories.class.toString(),"Project ID from Extras: "+extras.getString("project_id"));
			setTitle("Estimate");
			project_id=extras.getString("project_id");
			story_id=extras.getString("story_id");

			tracker = new PivotalTracker(this);
			c = tracker.getStory(story_id);
		}

		setUpFibonacci();
		// TODO setUpLinear/powerof2
		Log.i(TAG,"onCreate finished");
	}

	private void setUpFibonacci() {
		b0.setText("0 points");
		b0.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(0);
			}  
		});
		
		b1.setText("1 point");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(1);
			}  
		});
		
		b2.setText("2 points");
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(2);
			}  
		});
		
		b3.setText("3 points");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(3);
			}  
		});
		
		b4.setText("5 points");
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(5);
			}  
		});
		
		b5.setText("8 points");
		b5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(8);
			}  
		});
		
		b0.setVisibility(View.VISIBLE);
		b1.setVisibility(View.VISIBLE);
		b2.setVisibility(View.VISIBLE);
		b3.setVisibility(View.VISIBLE);
		b4.setVisibility(View.VISIBLE);
		b5.setVisibility(View.VISIBLE);
	}

	private void setUpLinear() {
		b0.setText("0 points");
		b0.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(0);
			}  
		});
		
		b1.setText("1 point");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(1);
			}  
		});
		
		b2.setText("2 points");
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(2);
			}  
		});
		
		b3.setText("3 points");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(3);
			}  
		});
		
		b4.setVisibility(View.INVISIBLE);
		b5.setVisibility(View.INVISIBLE);
	}
	
	private void setUpPowerOf2() {
		b0.setText("0 points");
		b0.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(0);
			}  
		});
		
		b1.setText("1 point");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(1);
			}  
		});
		
		b2.setText("2 points");
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(2);
			}  
		});
		
		b3.setText("4 points");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(4);
			}  
		});
		
		b4.setText("8 points");
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {  
				setEstimate(8);
			}  
		});
		
		b5.setVisibility(View.INVISIBLE);
	}
	
	private void setEstimate(Integer estimate) {
		Log.i(TAG,"setting estimate: "+estimate);
		Story s = c.getStory();
		s.setEstimate(estimate);
		tracker.commitChanges(s);
	}
}