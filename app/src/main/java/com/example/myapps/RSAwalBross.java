package com.example.myapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross  extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super .onCreate(icicle);
        String[] ListAct = new String[] {"Call Center", "SMS Center", "Driving Direction","Website", "Info di Google", "Exit"};
        this .setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListAct));

    }

    protected void onListItemClick (ListView l, View v, int position, long id){
        super .onListItemClick(l, v, position, id);
        Object o = this .getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortelepon = "tel:081216788030";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortelepon));

            } else if (pilihan.equals("SMS Center"))
            {
                String smsText = "Eka Suryani Indra Septiawati H/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081216788030"));
                a.putExtra("sms_body", smsText);

            } else if (pilihan.equals("Driving Direction"))
            {
                String lokasirs = "google.navigation:q=0.463823,101.390353";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Website"))
            {
                String website = "http://www.awal-bross.net";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            } else if (pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bross");
            }

            startActivity(a);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}


