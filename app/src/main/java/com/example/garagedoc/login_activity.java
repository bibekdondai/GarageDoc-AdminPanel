package com.example.garagedoc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class login_activity extends Activity {

	private ImageView ellipse_1;
	private TextView garage_doc_ek1;
	private ImageView black_and_white_modern_typographic_simple_virus_apparel_logo__1__1;
	private View rectangle_1_ek1;
	private EditText username;
	private View rectangle_2;
	private EditText password;
	private Button submit;

	private FirebaseAuth mAuth;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		// Initialize Firebase Auth
		mAuth = FirebaseAuth.getInstance();

		// Find views by ID
		ellipse_1 = findViewById(R.id.ellipse_1);
		garage_doc_ek1 = findViewById(R.id.garage_doc_ek1);
		black_and_white_modern_typographic_simple_virus_apparel_logo__1__1 = findViewById(R.id.black_and_white_modern_typographic_simple_virus_apparel_logo__1__1);
		rectangle_1_ek1 = findViewById(R.id.rectangle_1_ek1);
		username = findViewById(R.id.username);
		rectangle_2 = findViewById(R.id.rectangle_2);
		password = findViewById(R.id.password);
		submit = findViewById(R.id.submit);

		// Set click listener on the submit button
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String email = username.getText().toString();
				String pass = password.getText().toString();

				if (!email.isEmpty() && !pass.isEmpty()) {
					if (isNetworkAvailable()) {
						loginUser(email, pass);
					} else {
						Toast.makeText(login_activity.this, "No internet connection.", Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(login_activity.this, "Please enter both username and password.", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void loginUser(String email, String password) {
		mAuth.signInWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, task -> {
					if (task.isSuccessful()) {
						// Sign in success
						FirebaseUser user = mAuth.getCurrentUser();
						Toast.makeText(login_activity.this, "Login successful!", Toast.LENGTH_SHORT).show();
						// Start the dashboard_activity
						Intent intent = new Intent(login_activity.this, dashboard_activity.class);
						startActivity(intent);
					} else {
						try {
							throw task.getException();
						} catch (FirebaseAuthInvalidUserException e) {
							Toast.makeText(login_activity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
						} catch (FirebaseAuthInvalidCredentialsException e) {
							Toast.makeText(login_activity.this, "Invalid password", Toast.LENGTH_SHORT).show();
						} catch (FirebaseTooManyRequestsException e) {
							Toast.makeText(login_activity.this, "Too many failed attempts. Try again later.", Toast.LENGTH_LONG).show();
						} catch (Exception e) {
							Toast.makeText(login_activity.this, "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
						}
					}
				});
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
