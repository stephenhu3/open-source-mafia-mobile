//package com.example.opensourcemafiamobile;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ScrollView;
//import android.widget.TextView;
//
//public class ConsoleFragment extends Fragment {
//	int mDisplayedText = -1;
//	TextView mText;
//	public static StringBuilder consoleOutput = new StringBuilder("");
////
////	public void setText(int id) {
////		mDisplayedText = id;
////		if (mText != null && id >= 0) {
////			mText.setText(Shakespeare.DIALOGUE[id]);
////		}
////
////	}
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		if (savedInstanceState != null) {
//			mDisplayedText = savedInstanceState.getInt("text", -1);
//		}
//	}
//
//	@Override
//	public void onSaveInstanceState(Bundle outState) {
//		super.onSaveInstanceState(outState);
//		outState.putInt("text", mDisplayedText);
//	}
//
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//		ScrollView scroller = new ScrollView(getActivity());
//		mText = new TextView(getActivity());
//		scroller.addView(mText);
//		setText(mDisplayedText);
//		return scroller;
//	}
//
//	public void appendConsoleOutput(String input) {
//		consoleOutput.append("\n" + input);
//		outputText(consoleOutput.toString());
//	}
//
//	public String sendMessage(View view) {
//		Log.d("MainActivity", "Send Button Clicked");
//		// Intent intent = new Intent(this, DisplayMessageActivity.class);
//		EditText editText = (EditText) findViewById(R.id.edit_message);
//		String inputText = editText.getText().toString();
//		main.outputText(inputText);
//
//		// Builds upon long stringbuilder console output and display
//		appendConsoleOutput(inputText);
//
//		return inputText;
//		// intent.putExtra(EXTRA_MESSAGE, message);
//		// startActivity(intent);
//		// TextView textView = (TextView) findViewById(R.id.text_id);
//		// textView.setText(inputText);
//	}
//
//	//
//	public void outputText(String input) {
//		// Intent intent = new Intent(this, OutputTextActivity.class);
//		// startActivity(intent);
//		TextView textView = (TextView) findViewById(R.id.text_id);
//		textView.setText(input);
//
//	}
//
//}
