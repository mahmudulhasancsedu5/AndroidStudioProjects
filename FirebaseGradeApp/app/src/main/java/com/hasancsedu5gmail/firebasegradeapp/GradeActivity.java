package com.hasancsedu5gmail.firebasegradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class GradeActivity extends AppCompatActivity {

    private static final String TAG = GradeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String student_id = (String) bundle.get("student_id");

        Log.d(TAG,"In Grade Activity : "+student_id);

//        insertStudentGrade("101","cs107","A-","126");

        getStudentGrade(student_id);




    }

    private void getStudentGrade(String student_id){



        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference tableGrade = database.getReference("grades");
        Query all_grades = tableGrade.orderByChild("student_id").equalTo(student_id);
        all_grades.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String res="";

                for(DataSnapshot child: dataSnapshot.getChildren()){

                    String key = child.getKey();
                    DataSnapshot course_id = child.child("course_id");
                    DataSnapshot course_name = child.child("course_name");
                    DataSnapshot grade = child.child("grade");
                    String course_id_str = course_id.getValue().toString();
                    String course_name_str = course_name.getValue().toString();
                    String grade_str = grade.getValue().toString();

                    res+=course_id.getKey().toString()+" : "+course_id_str+"\n";
                    res+=course_name.getKey().toString()+" : "+course_name_str+"\n";
                    res+=grade.getKey().toString()+" : "+grade_str+"\n";

                }

                TextView tvGrade = (TextView)findViewById(R.id.text_greade);
                tvGrade.setText(res);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void insertStudentGrade(String course_id,String course_name,String grade,String student_id){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("grades");
        DatabaseReference newGrade = table.push();
        newGrade.child("course_id").setValue(course_id);
        newGrade.child("course_name").setValue(course_name);
        newGrade.child("grade").setValue(grade);
        newGrade.child("student_id").setValue(student_id);

    }
}

class Grade{


    public Grade(){

    }

    public Grade(String course_id,String course_name,String grade,String student_id){


    }


}
