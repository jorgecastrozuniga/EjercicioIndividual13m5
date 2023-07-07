package com.example.ejercicioindividual13m5;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ejercicioindividual13m5.databinding.FragmentWebBinding;


public class Web extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private FragmentWebBinding webBinding;
    private WebView webView;
    private String urlrecibida;


    public Web() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() !=null){
            urlrecibida= getArguments().getString(ARG_PARAM1);


        }


    }

    public static Web newInstance(String url){
        Web fragment= new Web();
        Bundle args= new Bundle();
        args.putString(ARG_PARAM1,url);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        webBinding = FragmentWebBinding.inflate(inflater, container, false);

        //
        webView=webBinding.wv1;
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String url= urlrecibida;
        webView.loadUrl(url);



        return webBinding.getRoot();

    }

}