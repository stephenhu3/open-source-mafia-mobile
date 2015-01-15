package com.example.opensourcemafiamobile.Characters;

import java.util.Scanner;
import com.example.opensourcemafiamobile.*;

public class MafiaMafioso extends AbstractPlayer {
	
	private MainActivity main;

    // Public getter
    public MafiaMafioso(MainActivity main) {
        this.main = main;
    }

    public MafiaMafioso(String playerName) {
        this.setAffiliation( "Mafia" );
        this.setRole( "Mafioso" );
        this.setDead( false );
        this.setDoused( false );
        this.setFramed (false );
        this.setPlayerName( playerName );

        addToMafiaList( this );
    }
    
    public MafiaMafioso(String playerName, MainActivity main) {
    	this.main = main;
        this.setAffiliation( "Mafia" );
        this.setRole( "Mafioso" );
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
//        Scanner in = new Scanner( System.in );


        main.outputText( getPlayerName() + ": Enter name of player to kill." );
//        candidateName = in.nextLine();
//        
//        for ( int i = 0; i < MainActivity.getTownList().size(); i++ ) {
//
//            if ( candidateName.equals( ( MainActivity.getTownList().get( i ) ).getPlayerName() ) ) {
//                if ( ! ( MainActivity.getTownList().get( i ).isBulletproof() ) && ! ( MainActivity.getTownList().get( i ).isHealed() ) ) {
//                    MainActivity.getTownList().get( i ).setDead( true );
//                }
//            }
//        }
//
//        for ( int i = 0; i < MainActivity.getMafiaList().size(); i++ ) {
//
//            if ( candidateName.equals( ( MainActivity.getMafiaList().get( i ) ).getPlayerName() ) ) {
//                if ( ! ( MainActivity.getMafiaList().get( i ).isBulletproof() ) && ! ( MainActivity.getMafiaList().get( i ).isHealed() ) ) {
//                    MainActivity.getMafiaList().get( i ).setDead( true );
//                }
//            }
//        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
