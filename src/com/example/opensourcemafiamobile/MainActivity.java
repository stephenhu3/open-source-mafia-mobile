package com.example.opensourcemafiamobile;

import java.util.ArrayList;
import java.util.List;

import com.example.opensourcemafiamobile.Characters.AbstractPlayer;
//import com.example.opensourcemafiamobile.Characters.MafiaFramer;
//import com.example.opensourcemafiamobile.Characters.MafiaGodfather;
//import com.example.opensourcemafiamobile.Characters.MafiaMafioso;
import com.example.opensourcemafiamobile.Characters.TownDoctor;
//import com.example.opensourcemafiamobile.Characters.TownSheriff;

import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	public static StringBuilder consoleOutput = new StringBuilder("");
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    
//    NightlyActions nightly = new NightlyActions(this);
    TextView textView;

	
    public static List<AbstractPlayer> townList; // The list of Town players
    public static List<AbstractPlayer> mafiaList; // The list of Mafia players
    public static List<AbstractPlayer> playerList; // The list of all players
    private static List<AbstractPlayer> lynchVictims; // The list of players to
                                                      // be lynched
    private static List<AbstractPlayer> hitVictims; // The list of players to be
                                                    // hit
    public static int day;
    private static int deadTownCount = 0;
    private static int deadMafiaCount = 0;

    // Used to determine highest votes on player, reset each day
    private static int highestLynchCount = 0;
    private static int highestHitCount = 0;
    

    public static void resetHighestLynchCount() {
        highestLynchCount = 0;
    }

    public static void resetHighestHitCount() {
        highestHitCount = 0;
    }

    public static void resetLynchVictims() {
        getLynchVictims().clear();
    }

    public static void resetHitVictims() {
        getHitVictims().clear();
    }

    public static void resetFramed() {
        for ( AbstractPlayer player : playerList ) {
            player.setFramed( false );
        }
    }

    public static void addToTownList( AbstractPlayer town ) {
        getTownList().add( town );
    }

    public static void addToMafiaList( AbstractPlayer mafia ) {
        getMafiaList().add( mafia );
    }

    public static List<AbstractPlayer> getTownList() {
        return townList;
    }

    public static List<AbstractPlayer> getMafiaList() {
        return mafiaList;
    }

    public static List<AbstractPlayer> getPlayerList() {
        return playerList;
    }

    public static List<AbstractPlayer> getLynchVictims() {
        return lynchVictims;
    }

    public static List<AbstractPlayer> getHitVictims() {
        return hitVictims;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView) findViewById(R.id.text_id);
    	textView.setMovementMethod(new ScrollingMovementMethod());
    	
    	 townList = new ArrayList<AbstractPlayer>();
         mafiaList = new ArrayList<AbstractPlayer>();
         lynchVictims = new ArrayList<AbstractPlayer>();
         hitVictims = new ArrayList<AbstractPlayer>();

        startGame();

    }
        
    public void startGame() {
        day = 0;
        
        
        // read up on best design pattern for android app
        outputText("Game Started.");
        TownDoctor doctor = new TownDoctor( "Doctor Who", this );
        
        doctor.setLastWill();
//        doctor.displayLastWill();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public String sendMessage(View view) {
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String inputText = editText.getText().toString();
    	
    	outputText(inputText);
    	
    	return inputText;

    }
//    
    public void outputText(String input) {
    	
        textView.append(input + '\n');
    	
        
    }
}