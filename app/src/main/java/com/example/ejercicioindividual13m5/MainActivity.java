package com.example.ejercicioindividual13m5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import com.example.ejercicioindividual13m5.databinding.ActivityMainBinding;
import com.example.ejercicioindividual13m5.databinding.FragmentWebBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarFragmento();
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finishAffinity();
            }
        });
    }

    private void mostrarFragmento(){
        Web web= Web.newInstance(binding.textField.getEditText().getText().toString());
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.replace(binding.contenedoractivity.getId(),web);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
