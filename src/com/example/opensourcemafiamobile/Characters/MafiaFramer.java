package com.example.opensourcemafiamobile.Characters;

import java.util.Scanner;

import com.example.opensourcemafiamobile.*;

public class MafiaFramer extends AbstractPlayer {
	
	private MainActivity main;

    // Public getter
    public MafiaFramer(MainActivity main) {
        this.main = main;
    }

    public MafiaFramer(String playerName) {
        this.setAffiliation( "Mafia" );
        this.setRole( "Framer" );
        this.setDead( false );
        this.setDoused( false );
        this.setFramed (false );
        this.setPlayerName( playerName );

        addToMafiaList( this );
    }

    // Kill
    @SuppressWarnings("resource")
    @Override
    public void nightAction() {

        String candidateName;
        Scanner in = new Scanner( System.in );

        main.outputText( getPlayerName() + ": Enter name of player to frame." );
        candidateName = in.nextLine();

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getTownList().get( i ).setFramed( true );
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                    NightlyActions.getMafiaList().get( i ).setFramed( true );
            }
        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
