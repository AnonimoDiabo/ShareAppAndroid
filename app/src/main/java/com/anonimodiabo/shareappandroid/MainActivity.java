package com.anonimodiabo.shareappandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.menu_share){
            ApplicationInfo applicationInfo=getApplicationContext().getApplicationInfo();
            String apkPath=applicationInfo.sourceDir;
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkPath)));
            startActivity(Intent.createChooser(intent,"ShareVia"));

//            try {
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
//                String shareMessage = "\nAndroid App link\n\n";
//                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
//                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
//                startActivity(Intent.createChooser(shareIntent, "choose one"));
//            } catch (Exception e) {
//                //e.toString();
//            }

//            Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
//            shareIntent.setType("text/plain");
//            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject here");
//            String app_url = " https://play.google.com/store/apps/details?id=com.anonimodiabo.shareappandroid";
//            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
//            startActivity(Intent.createChooser(shareIntent, "Share via"));
        }
        return true;
    }
}
