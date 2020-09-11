package com.example.leaderboard.Submission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leaderboard.Submission.Service.ApiClient;
import com.example.leaderboard.Submission.Service.Submit;
import com.example.leaderboard.Submission.Service.UserRequest;
import com.example.leaderboard.Submission.Service.UserResponse;
import com.example.leaderboard.ui.main.MainActivity;
import com.example.leaderboard.R;
import com.google.android.material.textfield.TextInputEditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class ProjectSubmission extends AppCompatActivity {

    Dialog AreYouSureDialog;
    Button confirm;
    ImageView close_popup;
    TextView tvText;

    private ImageView back;
//
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create());
    public static Retrofit retrofit = builder.build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_submission);

        back = (ImageView) findViewById(R.id.imageView3);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainActivity();
            }
        });




       final EditText editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        final EditText editTextSecondName =  (EditText) findViewById(R.id.editTextSecondName);
        final EditText editTextEmailAddress = (EditText)  findViewById(R.id.editTextEmailAddress);
        final EditText editTextLink =  (EditText) findViewById(R.id.editTextLink);
        findViewById(R.id.bt_InfoSubmit).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeSendFeedbackForm(
                        editTextEmailAddress.getText().toString(),
                        editTextLink.getText().toString(),
                        editTextFirstName.getText().toString(),
                        editTextSecondName.getText().toString()
                );
            }

            private void executeSendFeedbackForm(String Email, String Link, String FirstName, String SecondName) {
                Submit submit = retrofit.create(Submit.class);

                Call<ResponseBody> call = submit.SubmitInfo(
                         Email,
                       Link,
                         FirstName,
                       SecondName
                );
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(ProjectSubmission.this, "Saved successfully", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(ProjectSubmission.this, "Request Failed", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(ProjectSubmission.this, "Request Failed"+ t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        }));


    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}