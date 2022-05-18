package com.kimjiun.simpleroulette.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;

import com.kimjiun.simpleroulette.model.Database;
import com.kimjiun.simpleroulette.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends BaseObservable {
    private final static String TAG = "JIUN/ViewModel";
    private Database database;
    private List<Person> items = new ArrayList<>();
    private String winner;

    public ViewModel(Database database){
        Log.d(TAG, "ViewModel 생성자 실행 | DB(Model) 참조");
        this.database = database;

        this.database.setOnDatabaseListener(() -> {
            Log.d(TAG, "리스너 실행");
            winner = null;
            winner = database.getWinner();
            notifyChange();
        });
    }

    public void getUser() {
        Log.d(TAG, "db에게 user(winner)를 달라고 요청");
        database.getUser();
    }

    public String getWinner(){
        Log.d(TAG, "Winner 반환 : " + winner);
        return winner;
    }
}
