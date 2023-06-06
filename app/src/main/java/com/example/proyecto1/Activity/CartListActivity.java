package com.example.proyecto1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.proyecto1.Adaptor.CartListAdapter;
import com.example.proyecto1.Helper.ManagementCart;
import com.example.proyecto1.Interface.ChangeNumberItemsListener;
import com.example.proyecto1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView TotalFeeTxt,TotalDelivery,TotalTxt,emptyTxt;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart=new ManagementCart(this);
        
        initView();
        initList();
        calcularCart();
        BottomNavigation();
    }
    private void BottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.CartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
    }

    private void initView() {
        recyclerViewList=findViewById(R.id.recyclerView);
        TotalFeeTxt=findViewById(R.id.TotalFeeTxt);
        TotalDelivery=findViewById(R.id.TotalDelivery);
        TotalTxt=findViewById(R.id.TotalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView2);
        recyclerViewList=findViewById(R.id.cartView);
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managementCart.getListCart(),this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calcularCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }
    private void calcularCart(){
        double delivery= 5.000;
        double total = Math.round(managementCart.getTotalFee()+delivery);
        double itemTotal=Math.round((managementCart.getTotalFee()*100)/100);

        TotalFeeTxt.setText("$"+itemTotal);
        TotalDelivery.setText("$"+delivery);
        TotalTxt.setText("$"+total);
    }
}