package com.example.opensourcemafiamobile.Characters;

import java.util.Scanner;

import com.example.opensourcemafiamobile.*;

public class TownDoctor extends AbstractPlayer {
	
	private MainActivity main;

    // Public getter
    public TownDoctor(MainActivity main) {
        this.main = main;
    }

    public TownDoctor(String playerName) {
        this.setAffiliation( "Town" );
        this.setRole( "Doctor" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setFramed (false );
        this.setPlayerName( playerName );

        addToTownList( this );
    }
    
    public TownDoctor(String playerName, MainActivity main) {
    	this.main = main;
    	
        this.setAffiliation( "Town" );
        this.setRole( "Doctor" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setFramed (false );
        this.setPlayerName( playerName );

        addToTownList( this );
        
    }
    
    @Override
    public void setLastWill() {
//		Scanner in = new Scanner(System.in);
		main.outputText(getPlayerName() + ": Enter your last will.");
//		TODO: find out how to prompt for user input
//		lastWill = main.sendMessage((TextView) findViewById(R.id.text_id));
	}

    // Heals
    @SuppressWarnings("resource")
    @Override
    public void nightAction() {

        String candidateName;
        Scanner in = new Scanner( System.in );
        main.outputText( getPlayerName() + ": Enter name of player to heal." );
        candidateName = in.nextLine();

        for ( int i = 0; i < MainActivity.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( MainActivity.getTownList().get( i ) ).getPlayerName() ) ) {
                MainActivity.getTownList().get( i ).setHealed( true );
            }
        }

        for ( int i = 0; i < MainActivity.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( MainActivity.getMafiaList().get( i ) ).getPlayerName() ) ) {
                MainActivity.getMafiaList().get( i ).setHealed( true );
            }
        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
