package com.example.dell.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText editEmail,editUsername,editPassword;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editEmail=(EditText)findViewById(R.id.editEmail);
        editUsername=(EditText)findViewById(R.id.editUsername);
        editPassword=(EditText)findViewById(R.id.editPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

    }

    public void signupButtonClicked(View view) {
        final String username_content,password_content,email_content;

        username_content=editUsername.getText().toString().trim();
        password_content=editPassword.getText().toString().trim();
        email_content=editEmail.getText().toString().trim();

        if(!TextUtils.isEmpty(username_content)&& !TextUtils.isEmpty(email_content) && !TextUtils.isEmpty(password_content)){
            firebaseAuth.createUserWithEmailAndPassword(email_content,password_content).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    String user_id=firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db=databaseReference.child(user_id);
                    current_user_db.child("Name").setValue(username_content);
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
            });
        }
    }

    public void loginButtonClicked(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

    }
}
