package com.example.actionbardemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivity extends Activity {
	public static final String DEFAULT_DOLLAR_EXTRA = "defaultDollar";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_navigation, menu);
        return true;
	}
	
	public void onCreateItem(MenuItem mi) {
		// Create the intent
		Intent i = new Intent(this, 
				CreationActivity.class);
		// Define the parameters (extras)
		i.putExtra(DEFAULT_DOLLAR_EXTRA, 50);
		i.putExtra("defaultNote", "Food");
		// Execute my intent
		startActivityForResult(i, 50);		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			if (requestCode == 50) {
				if (resultCode == RESULT_OK) {
					Expense expense = 
							(Expense) data.getSerializableExtra("expense");
					Toast.makeText(this, expense.notes, 
							Toast.LENGTH_SHORT).show();
				}
			}
	}
}
