package br.com.test.myloginapplication.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

import br.com.test.myloginapplication.view.LoginActivity;

/**
 * 
 * @author fabiodocoutooliveira
 * 
 */

public class SessionManager {
	// Shared Preferences
	SharedPreferences pref;

	// Editor for Shared preferences
	Editor editor;

	// Context
	Context context;

	// Shared pref mode
	int PRIVATE_MODE = 0;

	// Sharedpref file name
	private static final String PREF_NAME = "br.com.test.myloginaplication";
	private static final String IS_LOGIN = "logado";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_REGISTRATION = "name";

	public SessionManager(Context context) {
		this.context = context;
		pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}

	/**
	 * Create login session
	 * */
	public void createLoginSession(String name, String password) {

		editor.putBoolean(IS_LOGIN, true);
		editor.putString(KEY_REGISTRATION, name);
		editor.putString(KEY_PASSWORD, password);
		editor.commit();
	}

	/**
	 * Check login method wil check user login status If false it will redirect
	 * user to login page Else won't do anything
	 * */
	public void checkLogin() {
		// Check login status
		if (!this.isLoggedIn()) {
			Intent i = new Intent(context, LoginActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
		}

	}

	/**
	 * Get stored session data
	 * */
	public HashMap<String, String> getUserDetails() {

		HashMap<String, String> user = new HashMap<String, String>();
		// user registration
		user.put(KEY_REGISTRATION, pref.getString(KEY_REGISTRATION, null));
		// user password id
		user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

		// return user
		return user;
	}

	/**
	 * Clear session details
	 * */
	public void logoutUser() {
		// Clearing all data from Shared Preferences
		//editor.clear();
		editor.remove(KEY_PASSWORD);
		editor.remove(KEY_REGISTRATION);
		
		editor.commit();

		// After logout redirect user to Login Activity
		Intent i = new Intent(context, LoginActivity.class);
		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		// Staring Login Activity
		context.startActivity(i);
		
	}

	/**
	 * Quick check for login
	 * **/
	// Get Login State
	public boolean isLoggedIn() {
		return pref.getBoolean(IS_LOGIN, false);
	}
	
	public void finish(){
		
		finish();
	}
}
