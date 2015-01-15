package com.example.opensourcemafiamobile;

import java.util.ArrayList;
import java.util.List;

import com.example.opensourcemafiamobile.Characters.*;

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
    
//    MainActivity nightly = new MainActivity(this);
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
        
        
        // Decide on best design pattern to port from desktop to suit android app
        outputText("Game Started.");
        TownDoctor doctor = new TownDoctor( "Doctor Who", this );
        TownSheriff sheriff = new TownSheriff( "Sheriff Brady", this );
	    MafiaMafioso mafioso = new MafiaMafioso( "Mafioso Brando", this );
	    MafiaGodfather godfather = new MafiaGodfather( "Godfather Pacino", this );
	    MafiaFramer framer = new MafiaFramer( "Framer Jones", this );
	    //Added to their respective mafia and town lists by now

	    // Make combined player list
	    playerList = new ArrayList<AbstractPlayer>();
	    playerList.addAll( townList );
	    playerList.addAll( mafiaList );
	    
	    for ( day = 1; day <= 10; day++ ) {
        deadTownCount = 0;
        deadMafiaCount = 0;
        outputText( "Day " + day + ":" );
        for ( int i = 0; i < getTownList().size(); i++ ) {
            if ( !getTownList().get( i ).isDead() ) {
                getTownList().get( i ).nightAction();
                getTownList().get( i ).nightActionString();

                // Vote lynch
                outputText( getTownList().get( i ).getPlayerName() + ": Who do you vote to lynch?" );
                getTownList().get( i ).voteLynch( getTownList().get( i ).getName() );
            } else {
                if ( !getTownList().get( i ).isWillSet() ) {
                    getTownList().get( i ).setLastWill();
                    getTownList().get( i ).displayLastWill();
                    outputText( getTownList().get( i ).getPlayerName() + " is dead." );
                }
                deadTownCount++;
                if ( deadTownCount >= getTownList().size() ) {
                	outputText( "Mafia wins." );
                    return;
                }
            }

        }

        for ( int i = 0; i < getMafiaList().size(); i++ ) {
            if ( !getMafiaList().get( i ).isDead() ) {
                getMafiaList().get( i ).nightAction();
                getMafiaList().get( i ).nightActionString();

                // Vote hit
                outputText( getMafiaList().get( i ).getPlayerName() + ": Who do you vote to hit?" );
                getMafiaList().get( i ).voteHit( getMafiaList().get( i ).getName() );
            } else {
                if ( !getMafiaList().get( i ).isWillSet() ) {
                    getMafiaList().get( i ).setLastWill();
                    getMafiaList().get( i ).displayLastWill();

                }
                deadMafiaCount++;
                if ( deadMafiaCount >= getMafiaList().size() ) {
                    outputText( "Town wins." );
                    return;
                }
            }

        }
//
//
//        // Iterate through player list to determine who gets lynched,
//        // players with equal lynch counts are killed
//        for ( int i = 0; i < getPlayerList().size(); i++ ) {
//            if ( getPlayerList().get( i ).getLynchCount() > highestLynchCount ) {
//                highestLynchCount = getPlayerList().get( i ).getLynchCount();
//            }
//        }
//
//        for ( int i = 0; i < getPlayerList().size(); i++ ) {
//            if ( ( highestLynchCount == getPlayerList().get( i ).getLynchCount() )
//                    && ( getPlayerList().get( i ).getLynchCount() != 0 ) ) {
//                lynchVictims.add( getPlayerList().get( i ) );
//            }
//        }
//
//        // Lynch all the victims with the highest lynch count
//        for ( int i = 0; i < lynchVictims.size(); i++ ) {
//            if ( !lynchVictims.get( i ).isLynched() ) {
//                lynchVictims.get( i ).setDead( true );
//                lynchVictims.get( i ).setLynched( true );
//                outputText( lynchVictims.get( i ).getPlayerName() + " has been lynched." );
//            }
//        }
//        resetHighestLynchCount();
//
//        // Iterate through player list to determine who gets hit, players
//        // with equal hit counts are killed
//        for ( int i = 0; i < getPlayerList().size(); i++ ) {
//            if ( getPlayerList().get( i ).getHitCount() > highestHitCount ) {
//                highestHitCount = getPlayerList().get( i ).getHitCount();
//            }
//        }
//
//        for ( int i = 0; i < getPlayerList().size(); i++ ) {
//            if ( ( highestHitCount == getPlayerList().get( i ).getHitCount() )
//                    && ( getPlayerList().get( i ).getHitCount() != 0 ) ) {
//                hitVictims.add( getPlayerList().get( i ) );
//            }
//        }
//
//        // Hit all the victims with the highest hit count
//        for ( int i = 0; i < hitVictims.size(); i++ ) {
//            if ( !hitVictims.get( i ).isHit() ) {
//                hitVictims.get( i ).setDead( true );
//                hitVictims.get( i ).setHit( true );
//                outputText( hitVictims.get( i ).getPlayerName() + " has been hit." );
//            }
//        }
//        resetHighestHitCount();
//
//        // Reveal sheriff's investigation results
//        if ( !sheriff.isDead() ) {
//            sheriff.investigationResults();
//        }
//
//        // Reset framed status for all players
//        resetFramed();
   }
        
        
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