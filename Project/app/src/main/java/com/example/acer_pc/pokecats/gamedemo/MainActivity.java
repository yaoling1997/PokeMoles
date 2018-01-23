package com.example.acer_pc.pokecats.gamedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by acer-pc on 2018/1/22.
 */
public class MainActivity extends Activity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        prefs=getSharedPreferences(Macro.PREFS_FILE,MODE_PRIVATE);
        Intent intent= new Intent(this,MusicService.class);
        intent.putExtra(Macro.BG_MUSIC,prefs.getString(Macro.BG_MUSIC,Macro.CLOSE));//open or close
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent= new Intent(this,MusicService.class);
        stopService(intent);
    }
    public void onClick(View view){
        if (view.getId()==R.id.btnStart){
            Intent intent= new Intent();
            intent.setAction(Macro.ACTION_START_ACTIVITY);
            startActivity(intent);
        }else if (view.getId()==R.id.btnSetting){
            Intent intent= new Intent();
            intent.setAction(Macro.ACTION_SETTING_ACTIVITY);
            startActivity(intent);
        }else if (view.getId()==R.id.btnExit){
            this.finish();
        }
    }
}
