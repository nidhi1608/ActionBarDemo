package com.example.actionbardemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CreationActivity extends Activity {
	private EditText etExpense;
	private EditText etNote;
	private EditText etWho;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creation);
		// Extract the extras from the bundle
		int defaultDollarValue = getIntent().
				getIntExtra(NavigationActivity.DEFAULT_DOLLAR_EXTRA, 0);
		String defaultNote = getIntent().getStringExtra("defaultNote");
		// Find the edit text fields
		etExpense = (EditText) findViewById(R.id.etExpense);
		etNote = (EditText) findViewById(R.id.etNote);
		etWho = (EditText) findViewById(R.id.etWho);
		// Populate the default values
		etExpense.setText(String.valueOf(defaultDollarValue));
		etNote.setText(defaultNote);
	}
	
	public void onSubmit(MenuItem mi) {
		// Submit back the new item to parent activity
		// Constructed model
		Expense expense = new Expense();
		expense.dollarValue = 
				Float.valueOf(etExpense.getText().toString());
		expense.notes = etNote.getText().toString();
		expense.who = etWho.getText().toString();
		// Set the result
		Intent i = new Intent();
		i.putExtra("expense", expense);
		setResult(RESULT_OK, i);
		// Dismiss the activity
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_creation, menu);
        return true;
	}
}
