package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int index=0;
    EditText name;
    CheckBox checkBox,checkBox2;
    String total="Total:";
    TextView quantityTextView,money;
    Button quanity_decrment,quanity_increment,order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        checkBox2=(CheckBox)findViewById(R.id.checkbox2);
        quanity_increment = (Button) findViewById(R.id.quanitity_increment);
        quanity_decrment = (Button) findViewById(R.id.decrease);
        order=(Button)findViewById(R.id.submit_order);
        money=(TextView)findViewById(R.id.Price);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);


        quanity_increment.setOnClickListener(this);
        quanity_decrment.setOnClickListener(this);
        quantityTextView.setOnClickListener(this);
        money.setOnClickListener(this);
        order.setOnClickListener(this);



    }


    /**
     * This method displays the given quantity value on the screen.
     */


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quanitity_increment:
                if(index==100){
                    Toast.makeText(this,"Order cannot exceed 100",Toast.LENGTH_SHORT).show();
                    return;}
                else{
                index++;
                quantityTextView.setText(""+index);}
                break;
            case R.id.decrease:
                if(index==1){
                    Toast.makeText(this,"Order Cannot be less than 0",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                index--;
                quantityTextView.setText(""+index);}
                break;
            case R.id.quantity_text_view:
                quantityTextView.setText(""+index);
                quantityTextView.setText(String.valueOf(index));
                break;
            case R.id.submit_order:
                boolean hasWhippedCream = checkBox.isChecked();
                boolean ischocolateAdded =checkBox.isChecked();
                String name1=name.getText().toString();
                if (hasWhippedCream) {
                    int total=index*(5+1);
                    money.setText("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded +"\n" + total + "\n Thank You");
                    String Summary=("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n total"+index*5 + "\n Thank You").toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Just Order For ankush");
                    intent.putExtra(Intent.EXTRA_TEXT,Summary);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                if (ischocolateAdded){
                    int total=index*(5+2);
                    money.setText("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n" + total + "\n Thank You");
                    String Summary=("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n total"+index*5 + "\n Thank You").toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Just Order For ankush");
                    intent.putExtra(Intent.EXTRA_TEXT,Summary);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }}
                if(ischocolateAdded&&hasWhippedCream){
                    int total =index*(5+3);
                    money.setText("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n" + total + "\n Thank You");
                    String Summary=("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n total"+index*5 + "\n Thank You").toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Just Order For ankush");
                    intent.putExtra(Intent.EXTRA_TEXT,Summary);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                else {
                money.setText("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n total"+index*5 + "\n Thank You");
                String Summary=("Name : " + name1 + "\nAdd whipping cream :" + hasWhippedCream + "\nAdd Chocolate : "+ischocolateAdded + "\n total"+index*5 + "\n Thank You").toString();

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Just Order For ankush");
                    intent.putExtra(Intent.EXTRA_TEXT,Summary);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }



                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}

