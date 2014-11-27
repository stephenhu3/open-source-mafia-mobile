//package com.example.opensourcemafiamobile;
//
//import android.support.v7.app.ActionBarActivity;
//import android.text.method.ScrollingMovementMethod;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class OutputTextActivity extends ActionBarActivity {
//	
//
//
//
//
//	protected void onCreate(Bundle savedInstanceState) {
//		
//		super.onCreate(savedInstanceState);
//	    
////		 final TextView textView = (TextView) findViewById(R.id.text_id);
//		 final TextView textView = new TextView(this);
////		 textView.setMovementMethod(new ScrollingMovementMethod());
//	     textView.setTextSize(14);
//
//	     // Set the text view as the activity layout
//	     setContentView(textView);
//
//		
//		final EditText inputText = new EditText(this);
//
//		
//		new AlertDialog.Builder(this)
//		.setTitle("Input Selection")
//		.setMessage("Type in your selection.")
//		.setView(inputText)
//		.setPositiveButton("Commit Action", new DialogInterface.OnClickListener() {
//		 public void onClick(DialogInterface dialog, int whichButton) {
//		     
//			 String inputString;
//			 inputString = inputText.getText().toString();
//			 textView.setText(inputString);
//
//			 
//		 }
//		}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//		 public void onClick(DialogInterface dialog, int whichButton) {
//			 // Do nothing
//		 }
//		}).show(); 
//		}
//	
////	public String getString() {
////		return inputString;
////	}
//
//}