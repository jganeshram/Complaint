package com.example.admin.complaint;



import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    EnableRuntimePermission();

    final TextView accountsData = (TextView) findViewById(R.id.accounts);

    String possibleEmail="";

    try{
        possibleEmail += "************* Get Registered Gmail Account *************nn";
        Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");

        for (Account account : accounts) {

            possibleEmail += " --> "+account.name+" : "+account.type+" , n";
            possibleEmail += " nn";

        }
    }
    catch(Exception e)
    {
        Log.i("Exception", "Exception:"+e) ;
    }


    try{
        possibleEmail += "**************** Get All Registered Accounts *****************nn";

        Account[] accounts = AccountManager.get(this).getAccounts();
        for (Account account : accounts) {

            possibleEmail += " --> "+account.name+" : "+account.type+" , n";
            possibleEmail += " n";

        }
    }
    catch(Exception e)
    {
        Log.i("Exception", "Exception:"+e) ;
    }

    // Show on screen
    accountsData.setText(possibleEmail);

    Log.i("Exception", "mails:"+possibleEmail) ;
}

    private void EnableRuntimePermission() {
    }

}




