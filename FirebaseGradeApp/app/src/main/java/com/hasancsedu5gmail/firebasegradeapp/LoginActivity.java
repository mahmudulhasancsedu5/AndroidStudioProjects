package com.hasancsedu5gmail.firebasegradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG =LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void insertDataFirebase(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference table = database.getReference("students");

        DatabaseReference row = database.getReference("students/156");
        Student student = new Student("abcd@gmail.com","126","hasan","126");
        row.setValue(student);


    }


    public void onClickLogin(View view) {

        EditText etName = (EditText)findViewById(R.id.text_name);
        EditText etPassword = (EditText)findViewById(R.id.text_password);
        String name = etName.getText().toString();
        final String password = etPassword.getText().toString();

        //look up persons password from firebase
        DatabaseReference fb = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference hasan = fb.child("students/124");
        DatabaseReference students = fb.child("students");

        Query hasanQuery = students.orderByChild("name").equalTo(name);

        hasanQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //data arrived
                // key = 124 value={"id": 123,"email":"","name": ,"password": }

//                Student hasan = dataSnapshot.getValue(Student.class);
//                String correctPassword = hasan.getPassword();
//
//                if(password.equals(correctPassword)){
//
//                    Log.d(TAG,"Password match log in successfull");
//
//                }
//                else{
//                    Log.d(TAG,"Incorrect Password");
//
//                }

                String student_id="";
                String pass="";
                boolean isCorrect = false;
                for(DataSnapshot child : dataSnapshot.getChildren())
                {
                    String key = child.getKey().toString();
                    DatabaseReference st = child.getRef();
                    Student student = child.getValue(Student.class);
                    Log.d(TAG,child.getValue().toString());

                    String checkPassword = "";
                    checkPassword = student.getPassword();



                    if(password.equals(checkPassword)){

                        student_id=key;
                        pass = checkPassword;
                        isCorrect = true;
                        break;

                    }

                }

                if(isCorrect == true){

                    Log.d(TAG,"Password is Correct");
                    Intent gradeIntent = new Intent(LoginActivity.this,GradeActivity.class);
                    gradeIntent.putExtra("student_id",student_id);
                    startActivity(gradeIntent);
                }else{
                    Log.d(TAG,"Password is wrong :" +pass);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });








    }
}

class Student{

    private String email;
    private String id;
    private String name;
    private String password;

    public Student(){

    }

    public Student(String email,String id,String name,String password){

        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;

    }
    public String getEmail(){
        return email;

    }
    public String getID(){
        return id;

    }
    public String getName(){
        return name;

    }
    public String getPassword(){
        return password;
    }


}




