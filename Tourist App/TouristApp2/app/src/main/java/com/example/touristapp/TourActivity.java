package com.example.touristapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class TourActivity extends AppCompatActivity {
    Spinner sp;
    TextView capital,totalVisitors, total;
    ImageView flag;
    SeekBar seekBar;
    Button calculate;
    ListView lv;
    String[] countryArray = {"Canada","USA","England"};
    String[] capitalArray = {"Ottawa","Washington","London"};
    Integer[] flagArray = {R.drawable.flagcanada,R.drawable.flagusa,R.drawable.flagengland};
    ArrayList<Place> placeList = new ArrayList<>();
    ArrayList<Place> tempPlaceList = new ArrayList<>();

    int currentPrice=0;
    double finalPrice=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        sp = findViewById(R.id.spinner);
        capital = findViewById(R.id.tvCapital);
        totalVisitors = findViewById(R.id.tvVisitors);
        total = findViewById(R.id.tvTotal);
        flag = findViewById(R.id.flagImage);
        seekBar = findViewById(R.id.seekBar);
        calculate = findViewById(R.id.btnCalculate);
        fillData();
        fillTemp(countryArray[0]);
        lv = findViewById(R.id.listView);
        lv.setAdapter(new placeAdapter(this,tempPlaceList));

        //Single spinner
        ArrayAdapter<String> aa = new ArrayAdapter<String>(TourActivity.this,
                android.R.layout.simple_spinner_item, countryArray);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (sp.getSelectedItem().toString()==countryArray[i])
                {
                    flag.setImageResource(flagArray[i]);
                    capital.setText(capitalArray[i]);
                    fillTemp(countryArray[i]);
                    lv.setAdapter(new placeAdapter(TourActivity.this,tempPlaceList));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                currentPrice = tempPlaceList.get(i).placePrice;





            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int visitors=Integer.parseInt(totalVisitors.getText().toString());
                if (visitors>15){
                    finalPrice = currentPrice*visitors*0.95;
                }
                else
                {
                    finalPrice = currentPrice*visitors;
                }
                total.setText(String.valueOf(finalPrice));
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                totalVisitors.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    public void fillData()
    {
        placeList.add(new Place(countryArray[0],capitalArray[0],"Niagara falls",R.drawable.niagra,100));
        placeList.add(new Place(countryArray[0],capitalArray[0],"CN Tower",R.drawable.cntower,30));
        placeList.add(new Place(countryArray[0],capitalArray[0],"The Butchart Gardens",R.drawable.butchart,30));
        placeList.add(new Place(countryArray[0],capitalArray[0],"Notre-Dame Basilica",R.drawable.notredame,50));
        placeList.add(new Place(countryArray[1],capitalArray[1],"The Statue of Liberty",R.drawable.liberty,90));
        placeList.add(new Place(countryArray[1],capitalArray[1],"The White House",R.drawable.whitehouse,60));
        placeList.add(new Place(countryArray[1],capitalArray[1],"Times Square",R.drawable.timesquare,75));
        placeList.add(new Place(countryArray[2],capitalArray[2],"Big Ben",R.drawable.bigben,30));
        placeList.add(new Place(countryArray[2],capitalArray[2],"Westminster Abbey",R.drawable.westminster,25));
        placeList.add(new Place(countryArray[2],capitalArray[2],"Hyde Park",R.drawable.hydepark,15));



    }
    public void fillTemp(String countryArray)
    {
        tempPlaceList.clear();
        for(Place bk:placeList)
            if(bk.getCountryName().equals(countryArray))
                tempPlaceList.add(bk);
    }

}