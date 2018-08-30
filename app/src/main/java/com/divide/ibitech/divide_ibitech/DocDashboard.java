package com.divide.ibitech.divide_ibitech;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class DocDashboard extends AppCompatActivity {

    TextView tv_DocName;
    ImageView imgProfilePic;
    CardView cv_Appointments;

    private Bitmap bitmap;
    String getId;

    private static final String TAG = DocDashboard.class.getSimpleName(); //getting the info

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_dashboard);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        tv_DocName = findViewById(R.id.tvDocName);
        cv_Appointments = findViewById(R.id.cvAppointments);

        HashMap<String,String> doc = sessionManager.getDocDetails();
        String sName = doc.get(sessionManager.NAME);
        String sSurname = doc.get(sessionManager.SURNAME);

        tv_DocName.setText("Dr " + sName + " " + sSurname);

       cv_Appointments.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(DocDashboard.this, ViewAppointments.class));
           }
       });

    }
}
