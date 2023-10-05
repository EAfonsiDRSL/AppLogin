package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String userCorrect = "eliot";
    private String passwordCorrect = "1234";
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userEdit = findViewById(R.id.user_edit);
        EditText passwordEdit = findViewById(R.id.password_edit);
        TextView result = findViewById(R.id.error);
        Button button = findViewById(R.id.button);
        ImageView imageView = findViewById(R.id.image);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick (View view){

                String user = userEdit.getText().toString();
                String password = passwordEdit.getText().toString();


                if (user.isEmpty() || password.isEmpty()){

                    imageView.setImageResource(R.drawable.piccolo);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageResource(R.drawable.goku);
                        }
                    },2000);

                    String result_text = "Error!!!, falta un campo a rellenar";
                    result.setText(result_text);

                }else {
                    result.setText("");

                        if (!user.equals(userCorrect) || !password.equals(passwordCorrect)) {


                            result.setText("Usuario o contraseña incorrectos");
                            imageView.setImageResource(R.drawable.yamcha);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.goku);
                                }
                            },2000);


                        } else {

                            imageView.setImageResource(R.drawable.saiyan);

                            button.setText("Login...");
                            button.setBackgroundColor(Color.rgb(70, 182, 19));


                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    button.setBackgroundColor(Color.CYAN);
                                    button.setText("Loged");
                                }
                            },3000);
                        }

                    }
                }


        });


    }
}