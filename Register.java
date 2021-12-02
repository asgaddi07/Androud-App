package com.example.foodapponline;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends AppCompatActivity {

    public static final String TAG = "Tag";
    EditText mName,mPassword,mEmail,mPhone;
    Button mSignUp;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

mName=findViewById(R.id.SignUpName);
mEmail=findViewById(R.id.SignUpEmail);
mPassword=findViewById(R.id.SignUpPassword);
mPhone=findViewById(R.id.SignUpPhone);
mSignUp=findViewById(R.id.SignUpButtom);

mAuth=FirebaseAuth.getInstance();
fStore=FirebaseFirestore.getInstance();

        if (mAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }

        mSignUp.setOnClickListener(view -> {
            String email=mEmail.getText().toString().trim();
            String password=mPassword.getText().toString().trim();
            String fullName=mName.getText().toString();
            String phone=mPhone.getText().toString();

            if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is required");
                return;
            }
            if (TextUtils.isEmpty(password)){
                mPassword.setError("Password is required");
                return;
            }
            if (password.length()<6){
                mPassword.setError("Password must be >= 6 characters.");
                return;
            }

            //register the user in firebase
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(Register.this, "USER REGISTERED", Toast.LENGTH_SHORT).show();
                    userId=mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference=fStore.collection("users").document(userId);
                    Map<String,Object> user=new HashMap<>();
                    user.put("fName",fullName);
                    user.put("email",email);
                    user.put("phone",phone);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.d(TAG,"onSuccess: user Profile is created for"+userId);
                        }
                    });
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
                else{
                    Toast.makeText(Register.this, "Error !"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });

        TextView already = findViewById(R.id.already);
        already.setOnClickListener(view -> {
            Intent intent = new Intent(Register.this,LogIn.class);
            startActivity(intent);
        });
    }}
