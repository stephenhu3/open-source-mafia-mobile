package com.example.opensourcemafiamobile.Characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.opensourcemafiamobile.*;

/**
 * Abstract Player class. Each player inherits from this superclass. Town and
 * Mafia.
 */
public abstract class AbstractPlayer extends ActionBarActivity {
		
	
	private MainActivity main;

    // Public getter
    public AbstractPlayer(MainActivity main) {
        this.main = main;
    }
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	// private static List<AbstractPlayer> townList; // The list of Town players
	// private static List<AbstractPlayer> mafiaList; // The list of Mafia
	// players

	private int voteLynchCount;
	private int voteHitCount;
	private int actionAmmo;

	private String role;
	private String affiliation;
	private String playerName;
	private String lastWill;

	private boolean isWillSet;
	private boolean isLynched;
	private boolean isHit;
	private boolean isDead;
	private boolean isDoused;
	private boolean isHealed;
	private boolean isBulletproof;
	private boolean isFramed;

	public AbstractPlayer() {

	}

	// Get player's selection
	public String getName() {
	//TODO: get user's input
		//placeholder:
		return "placeholder";
//		return main.sendMessage((TextView) findViewById(R.id.text_id));
//		Scanner in = new Scanner(System.in);
//		return in.nextLine();
	}

	/**
	 * Set last will (Town and Mafia)
	 * 
	 * @MODIFIES: Set's player's last will (displayed on death)
	 */
	public void setLastWill() {
		//Scanner in = new Scanner(System.in);
		main.outputText(getPlayerName() + ": Enter your last will.");
//		TODO: prompt user for input, current function sendMessage requires field to be prefilled, need to prompt instead
//		setWill(main.sendMessage((TextView) findViewById(R.id.text_id)));
	}
	
	public void setWill(String will) {
		this.lastWill = will;
	}

	public void displayLastWill() {
		main.outputText(playerName + "'s last will: " + lastWill);
		setWillSet(true);
	}

	/**
	 * Vote to lynch (Town and Mafia) SUGGESTION: Create choice UI so that
	 * candidateName !=Null
	 * 
	 * @REQUIRES: candidateName !=Null
	 * @PARAM: candidate name of person to be lynched
	 * @MODIFIES: add to candidate's vote counter.
	 */
	public void voteLynch(String candidateName) {

		for (int i = 0; i < MainActivity.getPlayerList().size(); i++) {

			if (candidateName.equals((MainActivity.getPlayerList().get(i))
					.getPlayerName())) {
				MainActivity.getPlayerList().get(i).addToLynchVote();
			}
		}
	}

	/*
	 * Vote to kill (Mafia only)
	 * 
	 * @REQUIRES: candidate is name of person to be killed
	 * 
	 * @PARAM: candidate name of person to be killed
	 * 
	 * @MODIFIES: add to candidate's vote Mafia counter.
	 */
	public void voteHit(String candidateName) {

		for (int i = 0; i < MainActivity.getPlayerList().size(); i++) {

			if (candidateName.equals((MainActivity.getPlayerList().get(i))
					.getPlayerName())) {
				MainActivity.getPlayerList().get(i).addToHitVote();
			}
		}
	}

	public void addToTownList(AbstractPlayer player) {
		MainActivity.getTownList().add(player);
	}

	public void addToMafiaList(AbstractPlayer player) {
		MainActivity.getMafiaList().add(player);
	}

	/*
	 * public static List<AbstractPlayer> getTownList() { return townList; }
	 * 
	 * public static List<AbstractPlayer> getMafiaList() { return mafiaList; }
	 */

	public void addToLynchVote() {
		this.voteLynchCount = this.voteLynchCount + 1;
	}

	public void addToHitVote() {
		this.voteHitCount = this.voteHitCount + 1;
	}

	public int getLynchCount() {
		return this.voteLynchCount;
	}

	public int getHitCount() {
		return this.voteHitCount;
	}

	public void resetLynchCount() {
		this.voteLynchCount = 0;
	}

	public void resetHitCount() {
		this.voteHitCount = 0;
	}

	public void setActionAmmo(int ammo) {
		this.actionAmmo = ammo;
	}

	public int getActionAmmo() {
		return actionAmmo;
	}

	public String getAffiliation() {
		if (this.isFramed()) {
			return "Mafia";
		} else {
			return affiliation;
		}
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isLynched() {
		return isLynched;
	}

	public void setLynched(boolean isLynched) {
		this.isLynched = isLynched;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public boolean isWillSet() {
		return isWillSet;
	}

	public void setWillSet(boolean isWillSet) {
		this.isWillSet = isWillSet;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean isDoused() {
		return isDoused;
	}

	public void setDoused(boolean isDoused) {
		this.isDoused = isDoused;
	}

	public boolean isHealed() {
		return isHealed;
	}

	public void setHealed(boolean isHealed) {
		this.isHealed = isHealed;
	}

	public boolean isBulletproof() {
		return isBulletproof;
	}

	public void setBulletproof(boolean isBulletproof) {
		this.isBulletproof = isBulletproof;
	}

	public boolean isFramed() {
		return isFramed;
	}

	public void setFramed(boolean isFramed) {
		this.isFramed = isFramed;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public abstract void nightAction();

	public abstract String nightActionString();

}
