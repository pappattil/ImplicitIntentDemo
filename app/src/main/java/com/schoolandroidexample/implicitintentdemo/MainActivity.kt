package com.schoolandroidexample.implicitintentdemo

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.schoolandroidexample.implicitintentdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun intentSearch(v: View) {
        val intentPackage = Intent(Intent.ACTION_WEB_SEARCH)
        intentPackage.putExtra(SearchManager.QUERY,"Balaton")
        startActivity(intentPackage)
    }

    fun intentDial(v:View){
        val intentPackage = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+36203385608"))
        startActivity(intentPackage)
    }

    fun intentSend(v:View){
        val intentPackage = Intent(Intent.ACTION_SEND)
        intentPackage.type = "text/plain"
        //intentPackage.`package` = "com.facebook.attila.papp0055"
        intentPackage.putExtra(Intent.EXTRA_TEXT, "Jee Tanfolyam!")
        startActivity(intentPackage)
    }

    fun intentWaze(v:View){
        val intentPackage = Intent(Intent.ACTION_VIEW)
        val wazeUri = "waze://?q=BME&navigate=yes"
        intentPackage.data= Uri.parse(wazeUri)
        startActivity(intentPackage)
    }

    fun intentStreetMaps(v: View){
        val gmapUri = Uri.parse(
            "google.streetview:cbll=29.9774614,31.1329645&cbp=0,30,0,0,-15"
        )
        val intentPackage = Intent(Intent.ACTION_VIEW, gmapUri)
        intentPackage.setPackage("com.google.android.apps.maps")
        startActivity(intentPackage)
    }



}