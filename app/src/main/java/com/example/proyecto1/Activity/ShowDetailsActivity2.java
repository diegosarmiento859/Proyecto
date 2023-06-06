package com.example.proyecto1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyecto1.Domain.FoodDomain;
import com.example.proyecto1.Helper.ManagementCart;
import com.example.proyecto1.R;

import java.util.jar.Attributes;

public class ShowDetailsActivity2 extends AppCompatActivity {
private TextView AggAlCarritoBTN;
private TextView TitleTxt,feeTxt,DescripsionTxt,NumOrdenTxt;
private ImageView plusBtn,MinusBtn,picFood;
private FoodDomain object;
int NumOrden = 1;
private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details2);

        managementCart = new ManagementCart(this);
        initView();
        getBlunde();
    }

    private void getBlunde() {
        object= (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        TitleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        DescripsionTxt.setText(object.getDescription());
        NumOrdenTxt.setText(String.valueOf(NumOrden));


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumOrden=NumOrden+1;
                NumOrdenTxt.setText(String.valueOf(NumOrden));
            }
        });

        MinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NumOrden > 1) {
                    NumOrden=NumOrden-1;
                }
                NumOrdenTxt.setText(String.valueOf(NumOrden));
            }
        });

        AggAlCarritoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(NumOrden);
                managementCart.insertFood(object);
            }
        });


    }

    private void initView() {
        AggAlCarritoBTN=findViewById(R.id.AggAlCarritoBTN);
        TitleTxt=findViewById(R.id.TitleTxt);
        feeTxt=findViewById(R.id.PriceTxt);
        DescripsionTxt=findViewById(R.id.DescripsionTxt);
        NumOrdenTxt=findViewById(R.id.NumOrdenTxt);
        plusBtn=findViewById(R.id.plusBtn);
        MinusBtn=findViewById(R.id.MinusBtn);
        picFood=findViewById(R.id.picfood);
    }
}