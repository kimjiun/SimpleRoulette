package com.kimjiun.simpleroulette.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.kimjiun.simpleroulette.R;
import com.kimjiun.simpleroulette.databinding.ActivityMainBinding;
import com.kimjiun.simpleroulette.model.Database;
import com.kimjiun.simpleroulette.viewmodel.ViewModel;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "JIUN/MainActivity";
    ActivityMainBinding binding;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModel(Database.getInstance());
        binding.setViewModel(viewModel);

        binding.okBtnview.setOnClickListener(v -> {
            Log.d(TAG, "BUTTON CLICK");
            viewModel.getUser();
        });
    }
}
