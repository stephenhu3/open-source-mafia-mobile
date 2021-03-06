//package com.example.opensourcemafiamobile;
//
//import java.util.List;
//import java.util.ArrayList;
//import com.example.opensourcemafiamobile.Characters.*;
//import android.support.v7.app.ActionBarActivity;
//import android.text.method.ScrollingMovementMethod;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class NightlyActions extends ActionBarActivity {
//	
//	private MainActivity main;
//
//    // Public getter
//    public NightlyActions(MainActivity main) {
//        this.main = main;
//    }
//	
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		
//        townList = new ArrayList<AbstractPlayer>();
//        mafiaList = new ArrayList<AbstractPlayer>();
//        lynchVictims = new ArrayList<AbstractPlayer>();
//        hitVictims = new ArrayList<AbstractPlayer>();
//        
//        startGame();
//	}
//
//
//    public NightlyActions() {
//        townList = new ArrayList<AbstractPlayer>();
//        mafiaList = new ArrayList<AbstractPlayer>();
//        lynchVictims = new ArrayList<AbstractPlayer>();
//        hitVictims = new ArrayList<AbstractPlayer>();
//    }
//
//
//    
//    public void startGame() {
//        day = 0;
//        
//        
//        // read up on best design pattern for android app
//        main.outputText("Game Started.");
//        TownDoctor doctor = new TownDoctor( "Doctor Who" );
//        
//        doctor.setLastWill();
//        doctor.displayLastWill();
//
////        TownCitizen citizen = new TownCitizen( "Citizen Kane" );
//
//        
////        TownSheriff sheriff = new TownSheriff( "Sheriff Brady" );
////        MafiaMafioso mafioso = new MafiaMafioso( "Mafioso Brando" );
////        MafiaGodfather godfather = new MafiaGodfather( "Godfather Pacino" );
////        MafiaFramer framer = new MafiaFramer( "Framer Jones" );
//        // Added to their respective mafia and town lists by now
////
////        // Make combined player list
////        playerList = new ArrayList<AbstractPlayer>();
////        playerList.addAll( townList );
////        playerList.addAll( mafiaList );
////
////        for ( day = 1; day <= 10; day++ ) {
////            deadTownCount = 0;
////            deadMafiaCount = 0;
////            main.outputText( "Day " + day + ":" );
////            for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {
////                if ( !NightlyActions.getTownList().get( i ).isDead() ) {
////                    NightlyActions.getTownList().get( i ).nightAction();
////                    NightlyActions.getTownList().get( i ).nightActionString();
////
////                    // Vote lynch
////                    main.outputText( NightlyActions.getTownList().get( i ).getPlayerName() + ": Who do you vote to lynch?" );
////                    NightlyActions.getTownList().get( i ).voteLynch( NightlyActions.getTownList().get( i ).getName() );
////                } else {
////                    if ( !NightlyActions.getTownList().get( i ).isWillSet() ) {
////                        NightlyActions.getTownList().get( i ).setLastWill();
////                        NightlyActions.getTownList().get( i ).displayLastWill();
////                        main.outputText( NightlyActions.getTownList().get( i ).getPlayerName() + " is dead." );
////                    }
////                    deadTownCount++;
////                    if ( deadTownCount >= NightlyActions.getTownList().size() ) {
////                    	main.outputText( "Mafia wins." );
////                        return;
////                    }
////                }
////
////            }
////
////            for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {
////                if ( !NightlyActions.getMafiaList().get( i ).isDead() ) {
////                    NightlyActions.getMafiaList().get( i ).nightAction();
////                    NightlyActions.getMafiaList().get( i ).nightActionString();
////
////                    // Vote hit
////                    main.outputText( NightlyActions.getMafiaList().get( i ).getPlayerName() + ": Who do you vote to hit?" );
////                    NightlyActions.getMafiaList().get( i ).voteHit( NightlyActions.getMafiaList().get( i ).getName() );
////                } else {
////                    if ( !NightlyActions.getMafiaList().get( i ).isWillSet() ) {
////                        NightlyActions.getMafiaList().get( i ).setLastWill();
////                        NightlyActions.getMafiaList().get( i ).displayLastWill();
////
////                    }
////                    deadMafiaCount++;
////                    if ( deadMafiaCount >= NightlyActions.getMafiaList().size() ) {
////                        main.outputText( "Town wins." );
////                        return;
////                    }
////                }
////
////            }
////
////
////            // Iterate through player list to determine who gets lynched,
////            // players with equal lynch counts are killed
////            for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
////                if ( NightlyActions.getPlayerList().get( i ).getLynchCount() > highestLynchCount ) {
////                    highestLynchCount = NightlyActions.getPlayerList().get( i ).getLynchCount();
////                }
////            }
////
////            for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
////                if ( ( highestLynchCount == NightlyActions.getPlayerList().get( i ).getLynchCount() )
////                        && ( NightlyActions.getPlayerList().get( i ).getLynchCount() != 0 ) ) {
////                    lynchVictims.add( NightlyActions.getPlayerList().get( i ) );
////                }
////            }
////
////            // Lynch all the victims with the highest lynch count
////            for ( int i = 0; i < lynchVictims.size(); i++ ) {
////                if ( !lynchVictims.get( i ).isLynched() ) {
////                    lynchVictims.get( i ).setDead( true );
////                    lynchVictims.get( i ).setLynched( true );
////                    main.outputText( lynchVictims.get( i ).getPlayerName() + " has been lynched." );
////                }
////            }
////            resetHighestLynchCount();
////
////            // Iterate through player list to determine who gets hit, players
////            // with equal hit counts are killed
////            for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
////                if ( NightlyActions.getPlayerList().get( i ).getHitCount() > highestHitCount ) {
////                    highestHitCount = NightlyActions.getPlayerList().get( i ).getHitCount();
////                }
////            }
////
////            for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {
////                if ( ( highestHitCount == NightlyActions.getPlayerList().get( i ).getHitCount() )
////                        && ( NightlyActions.getPlayerList().get( i ).getHitCount() != 0 ) ) {
////                    hitVictims.add( NightlyActions.getPlayerList().get( i ) );
////                }
////            }
////
////            // Hit all the victims with the highest hit count
////            for ( int i = 0; i < hitVictims.size(); i++ ) {
////                if ( !hitVictims.get( i ).isHit() ) {
////                    hitVictims.get( i ).setDead( true );
////                    hitVictims.get( i ).setHit( true );
////                    main.outputText( hitVictims.get( i ).getPlayerName() + " has been hit." );
////                }
////            }
////            resetHighestHitCount();
////
////            // Reveal sheriff's investigation results
////            if ( !sheriff.isDead() ) {
////                sheriff.investigationResults();
////            }
////
////            // Reset framed status for all players
////            resetFramed();
////       }
//    }
//}
