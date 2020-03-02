package com.example.converter_app;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;

    private EditText editTextDecimal;
    private EditText editTextBinary;
    private EditText editTextOctal;
    private EditText editTextHexa;
    private Button btnClear;
    private String value;
    private View.OnFocusChangeListener onFocusChangeListener;
    private TextWatcher textWatcher;
    private int focusedviewId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setuptoolbar();

    }


    private void setuptoolbar() {


        toolbar=(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);


        editTextDecimal=(EditText)findViewById(R.id.etdec);
        editTextBinary=(EditText)findViewById(R.id.etbin);
        editTextOctal=(EditText)findViewById(R.id.etoct);
        editTextHexa=(EditText)findViewById(R.id.ethex);
        btnClear=(Button)findViewById(R.id.button);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfields();
            }
        });

        textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                value=((EditText)findViewById(focusedviewId)).getText().toString().trim();
                if(value.length()>0){
                    ConvertNumber();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    focusedviewId=v.getId();
                    ((EditText)findViewById(focusedviewId)).addTextChangedListener(textWatcher);
                }
                else{
                    ((EditText)findViewById(focusedviewId)).removeTextChangedListener(textWatcher);
                }
            }
        };
           editTextDecimal.setOnFocusChangeListener(onFocusChangeListener);
           editTextBinary.setOnFocusChangeListener(onFocusChangeListener);
           editTextOctal.setOnFocusChangeListener(onFocusChangeListener);
           editTextHexa.setOnFocusChangeListener(onFocusChangeListener);
    }


    private void clearfields() {
        editTextDecimal.setText("");
        editTextBinary.setText("");
        editTextOctal.setText("");
        editTextHexa.setText("");
    }

    public void ConvertNumber(){
        try {
            long num = 0;
            switch (focusedviewId) {
                case R.id.etdec:
                    num = Long.parseLong(value);
                    editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
                    editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
                    editTextHexa.setText(String.valueOf(Long.toHexString(num).toUpperCase()));
                    break;
                case R.id.etbin:
                    num = Long.parseLong(value, 2);
                    editTextDecimal.setText(String.valueOf(num));
                    editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
                    editTextHexa.setText(String.valueOf(Long.toHexString(num).toUpperCase()));

                    break;
                case R.id.etoct:
                    num = Long.parseLong(value, 8);
                    editTextDecimal.setText(String.valueOf(num));
                    editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
                    editTextHexa.setText(String.valueOf(Long.toHexString(num).toUpperCase()));
                    break;
                case R.id.ethex:
                    num = Long.parseLong(value, 16);
                    editTextDecimal.setText(String.valueOf(num));
                    editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
                    editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
                    break;

            }
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
