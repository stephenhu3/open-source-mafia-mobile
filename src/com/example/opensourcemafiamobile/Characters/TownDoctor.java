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

    // Heals
    @SuppressWarnings("resource")
    @Override
    public void nightAction() {

        String candidateName;
        Scanner in = new Scanner( System.in );
        main.outputText( getPlayerName() + ": Enter name of player to heal." );
        candidateName = in.nextLine();

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getTownList().get( i ).setHealed( true );
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getMafiaList().get( i ).setHealed( true );
            }
        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
