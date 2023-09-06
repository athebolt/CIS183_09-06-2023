package com.example.textboxesarrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_j_addRestaurant;
    Button btn_j_pickRestaurant;
    EditText et_j_newRestaurant;
    TextView txt_j_restaurant;
    TextView txt_j_errorNoRestaurant;
    int count = 0;
    int randomPos;
    private String[] restaurants = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_addRestaurant     = findViewById(R.id.btn_v_add);
        btn_j_pickRestaurant    = findViewById(R.id.btn_v_find);
        et_j_newRestaurant      = findViewById(R.id.et_v_newRestaurant);
        txt_j_restaurant        = findViewById(R.id.txt_v_resturant);
        txt_j_errorNoRestaurant = findViewById(R.id.txt_v_errorNoRestaurant);

        //testing to make sure I can edit the text view
        txt_j_restaurant.setText("Hello");

        addRestaurantButtonEvent();
        pickRestaurantButtonEvent();
    }

    public void addRestaurantButtonEvent()
    {
        btn_j_addRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Add","Add button pressed");
                //Check to see if the array is full
                if(checkArrayFull())
                {
                    //do something so that the user cannot add more restaurants
                    txt_j_errorNoRestaurant.setText("List is full. Click find restaurant.");
                    txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                }
                else
                {
                    //Log.d("Here",et_j_newRestaurant.getText().toString());
                    //If not full, add restaurant to array
                    //Get the value from the edit text and convert to string
                    //strings are compared in java using .equals
                    if(!et_j_newRestaurant.getText().toString().equals(""))
                    {
                        //add to array
                        restaurants[count] = et_j_newRestaurant.getText().toString();
                        //increment count
                        count++;
                        //clear textbox
                        et_j_newRestaurant.setText("");
                        //make error message not visible
                        txt_j_errorNoRestaurant.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        //error: enter a restaurant
                        //make error visible
                        txt_j_errorNoRestaurant.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }

    public void pickRestaurantButtonEvent()
    {
        btn_j_pickRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Pick","Pick button pressed");
                //displayRestaurants();
                randomPos = (int) (Math.random() * count);
                //Log.d("random: ",randomPos + "");
                txt_j_restaurant.setText(restaurants[randomPos]);
            }
        });
    }

    public boolean checkArrayFull()
    {
        if(count < 6)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void displayRestaurants()
    {
        for(int i = 0; i < restaurants.length; i++)
        {
            //only display if there is something stored in the array at position i
            if(restaurants[i] != null)
            {
                Log.d("Restaurant: ", restaurants[i]);
            }
        }
    }
}