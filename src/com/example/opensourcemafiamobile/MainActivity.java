package com.example.opensourcemafiamobile;

import java.util.ArrayList;
import java.util.List;

import com.example.opensourcemafiamobile.Characters.AbstractPlayer;
import com.example.opensourcemafiamobile.Characters.MafiaFramer;
import com.example.opensourcemafiamobile.Characters.MafiaGodfather;
import com.example.opensourcemafiamobile.Characters.MafiaMafioso;
import com.example.opensourcemafiamobile.Characters.TownDoctor;
import com.example.opensourcemafiamobile.Characters.TownSheriff;

import android.support.v7.app.ActionBarActivity;
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
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        NightlyActions night = new NightlyActions();
        night.startGame();
        //--- text view---
       
//        final String Label = txtView.getText().toString();
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
    
    public void appendConsoleOutput(String input) {
    	consoleOutput.append("\n" + input);
    	outputText(consoleOutput.toString());
    }
    
    
    public String sendMessage (View view) {
    	Log.d("MainActivity","Send Button Clicked");
//    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String inputText = editText.getText().toString();
    	System.out.println(inputText);
    	
    	//Builds upon long stringbuilder console output and display
    	appendConsoleOutput(inputText);
    	
    	
    	return inputText;
//    	intent.putExtra(EXTRA_MESSAGE, message);
//    	startActivity(intent);
//        TextView textView = (TextView) findViewById(R.id.text_id);
//        textView.setText(inputText);
    }
//    
    public void outputText (String input) {
//    	Intent intent = new Intent(this, OutputTextActivity.class);
//    	startActivity(intent);
        TextView textView = (TextView) findViewById(R.id.text_id);
        textView.setText(input);
    	
    }
    
//    public void startMatch() {
//    	Intent intent = new Intent(this, NightlyActions.class);
//    	startActivity(intent);
//    }
    
    //Nightly Actions here
    
//    public void nightlyActions() {
//    	
//    
//	    public static List<AbstractPlayer> townList; // The list of Town players
//	    public static List<AbstractPlayer> mafiaList; // The list of Mafia players
//	    public static List<AbstractPlayer> playerList; // The list of all players
//	    private static List<AbstractPlayer> lynchVictims; // The list of players to
//	                                                      // be lynched
//	    private static List<AbstractPlayer> hitVictims; // The list of players to be
//	                                                    // hit
//	    public static int day;
//	    private static int deadTownCount = 0;
//	    private static int deadMafiaCount = 0;
//	
//	    // Used to determine highest votes on player, reset each day
//	    private static int highestLynchCount = 0;
//	    private static int highestHitCount = 0;
//	    
//	    
//	    
//	    public static void resetHighestLynchCount() {
//	        highestLynchCount = 0;
//	    }
//	
//	    public static void resetHighestHitCount() {
//	        highestHitCount = 0;
//	    }
//	
//	    public static void resetLynchVictims() {
//	        getLynchVictims().clear();
//	    }
//	
//	    public static void resetHitVictims() {
//	        getHitVictims().clear();
//	    }
//	
//	    public static void resetFramed() {
//	        for ( AbstractPlayer player : playerList ) {
//	            player.setFramed( false );
//	        }
//	    }
//	
//	    public static void addToTownList( AbstractPlayer town ) {
//	        getTownList().add( town );
//	    }
//	
//	    public static void addToMafiaList( AbstractPlayer mafia ) {
//	        getMafiaList().add( mafia );
//	    }
//	
//	    public static List<AbstractPlayer> getTownList() {
//	        return townList;
//	    }
//	
//	    public static List<AbstractPlayer> getMafiaList() {
//	        return mafiaList;
//	    }
//	
//	    public static List<AbstractPlayer> getPlayerList() {
//	        return playerList;
//	    }
//	
//	    public static List<AbstractPlayer> getLynchVictims() {
//	        return lynchVictims;
//	    }
//	
//	    public static List<AbstractPlayer> getHitVictims() {
//	        return hitVictims;
//	    }
//	    
//	    day = 0;
//	
//	    System.out.println( "Game Started." );
//	
//	
//	    NightlyActions actions = new NightlyActions();
//	
//	//        TownCitizen citizen = new TownCitizen( "Citizen Kane" );
//	    TownDoctor doctor = new TownDoctor( "Doctor Who" );
//	    TownSheriff sheriff = new TownSheriff( "Sheriff Brady" );
//	    MafiaMafioso mafioso = new MafiaMafioso( "Mafioso Brando" );
//	    MafiaGodfather godfather = new MafiaGodfather( "Godfather Pacino" );
//	    MafiaFramer framer = new MafiaFramer( "Framer Jones" );
//	    // Added to their respective mafia and town lists by now
//	
//	    // Make combined player list
//	    playerList = new ArrayList<AbstractPlayer>();
//	    playerList.addAll( townList );
//	    playerList.addAll( mafiaList );
//	
//		    for ( day = 1; day <= 10; day++ ) {
//		        deadTownCount = 0;
//		        deadMafiaCount = 0;
//		        System.out.println( "Day " + day + ":" );
//		        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {
//		            if ( !NightlyActions.getTownList().get( i ).isDead() ) {
//		                NightlyActions.getTownList().get( i ).nightAction();
//		                NightlyActions.getTownList().get( i ).nightActionString();
//		
//		                // Vote lynch
//		                System.out.println( NightlyActions.getTownList().get( i ).getPlayerName() + ": Who do you vote to lynch?" );
//		                NightlyActions.getTownList().get( i ).voteLynch( NightlyActions.getTownList().get( i ).getName() );
//		            } else {
//		                if ( !NightlyActions.getTownList().get( i ).isWillSet() ) {
//		                    NightlyActions.getTownList().get( i ).setLastWill();
//		                    NightlyActions.getTownList().get( i ).displayLastWill();
//		                    System.out.println( NightlyActions.getTownList().get( i ).getPlayerName() + " is dead." );
//		                }
//		                deadTownCount++;
//		                if ( deadTownCount >= NightlyActions.getTownList().size() ) {
//		                    System.out.println( "Mafia wins." );
//		                    return;
//		                }
//		            }
//		
//		        }
//		
//		        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {
//		            if ( !NightlyActions.getMafiaList().get( i ).isDead() ) {
//		                NightlyActions.getMafiaList().get( i ).nightAction();
//		                NightlyActions.getMafiaList().get( i ).nightActionString();
//		
//		                // Vote hit
//		                System.out.println( NightlyActions.getMafiaList().get( i ).getPlayerName() + ": Who do you vote to hit?" );
//		                NightlyActions.getMafiaList().get( i ).voteHit( NightlyActions.getMafiaList().get( i ).getName() );
//		            } else {
//		                if ( !NightlyActions.getMafiaList().get( i ).isWillSet() ) {
//		                    NightlyActions.getMafiaList().get( i ).setLastWill();
//		                    NightlyActions.getMafiaList().get( i ).displayLastWill();
//		
//		                }
//		                deadMafiaCount++;
//		                if ( deadMafiaCount >= NightlyActions.getMafiaList().size() ) {
//		                    System.out.println( "Town wins." );
//		                    return;
//		                }
//		            }
//		
//		        }
//		
//		
//		        // Iterate through player list to determine who gets lynched,
//		        // players with equal lynch counts are killed
//		        for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
//		            if ( NightlyActions.getPlayerList().get( i ).getLynchCount() > highestLynchCount ) {
//		                highestLynchCount = NightlyActions.getPlayerList().get( i ).getLynchCount();
//		            }
//		        }
//		
//		        for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
//		            if ( ( highestLynchCount == NightlyActions.getPlayerList().get( i ).getLynchCount() )
//		                    && ( NightlyActions.getPlayerList().get( i ).getLynchCount() != 0 ) ) {
//		                lynchVictims.add( NightlyActions.getPlayerList().get( i ) );
//		            }
//		        }
//		
//		        // Lynch all the victims with the highest lynch count
//		        for ( int i = 0; i < lynchVictims.size(); i++ ) {
//		            if ( !lynchVictims.get( i ).isLynched() ) {
//		                lynchVictims.get( i ).setDead( true );
//		                lynchVictims.get( i ).setLynched( true );
//		                System.out.println( lynchVictims.get( i ).getPlayerName() + " has been lynched." );
//		            }
//		        }
//		        resetHighestLynchCount();
//		
//		        // Iterate through player list to determine who gets hit, players
//		        // with equal hit counts are killed
//		        for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
//		            if ( NightlyActions.getPlayerList().get( i ).getHitCount() > highestHitCount ) {
//		                highestHitCount = NightlyActions.getPlayerList().get( i ).getHitCount();
//		            }
//		        }
//		
//		        for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
//		            if ( ( highestHitCount == NightlyActions.getPlayerList().get( i ).getHitCount() )
//		                    && ( NightlyActions.getPlayerList().get( i ).getHitCount() != 0 ) ) {
//		                hitVictims.add( NightlyActions.getPlayerList().get( i ) );
//		            }
//		        }
//		
//		        // Hit all the victims with the highest hit count
//		        for ( int i = 0; i < hitVictims.size(); i++ ) {
//		            if ( !hitVictims.get( i ).isHit() ) {
//		                hitVictims.get( i ).setDead( true );
//		                hitVictims.get( i ).setHit( true );
//		                System.out.println( hitVictims.get( i ).getPlayerName() + " has been hit." );
//		            }
//		        }
//		        resetHighestHitCount();
//		
//		        // Reveal sheriff's investigation results
//		        if ( !sheriff.isDead() ) {
//		            sheriff.investigationResults();
//		        }
//		
//		        // Reset framed status for all players
//		        resetFramed();
//		}
//    }

    
    
    
//    public void assignText() {
////		final TextView textView = new TextView(this);
////
////	     textView.setTextSize(14);
////
////	     // Set the text view as the activity layout
////	     setContentView(textView);
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
//			 txtView.setText(inputString);
//
//			 
//		 }
//		}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//		 public void onClick(DialogInterface dialog, int whichButton) {
//			 // Do nothing
//		 }
//		}).show(); 
//    	
//    }
}
