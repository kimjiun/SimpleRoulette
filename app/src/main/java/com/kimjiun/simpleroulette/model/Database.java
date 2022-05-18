package com.kimjiun.simpleroulette.model;

import android.util.Log;

import java.util.ArrayList;

public class Database {
    private final static String TAG = "JIUN/Database";
    private static Database instance;
    private ArrayList<Person> personList = new ArrayList<>();
    private String winner;
    private DatabaseListener databaseListener;

    private Database(){
        Log.d(TAG, "Model인 Database 생성");
        personList.add(new Person(0, "최OO"));
        personList.add(new Person(1, "김OO"));
        personList.add(new Person(2, "고OO"));
        personList.add(new Person(3, "문OO"));
        personList.add(new Person(4, "윤OO"));
    }

    public static Database getInstance() {
        Log.d(TAG, "Model에 접근 할 수 있도록 DB 인스턴스 값 요청");
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void getUser() {
        Log.d(TAG, "당첨자 획득");
        winner = personList.get((int)(Math.random()*5)).getName();
        notifyChange();
    }

    private void notifyChange() {
        if (databaseListener != null) {
            Log.d(TAG, "Model | Data 변경 되어 notify 하라고 알림");
            databaseListener.onChanged();
        }
    }

    public void setOnDatabaseListener(DatabaseListener databaseListener) {
        Log.d(TAG, "DatabaseListener 구현 객체 참조 변수 세팅 (arg1 : "+ databaseListener.getClass().getSimpleName() + ")");
        this.databaseListener = databaseListener;
    }

    public String getWinner(){
        return winner;
    }

    public interface DatabaseListener {
        void onChanged();
    }
}
