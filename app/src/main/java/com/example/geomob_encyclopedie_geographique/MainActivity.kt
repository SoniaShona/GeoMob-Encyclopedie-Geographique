package com.example.geomob_encyclopedie_geographique

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var paysViewModel: PaysViewModel
    private lateinit var countryAdapter: CountryAdapter
    private var countryList:MutableList<Pays> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)

        //Liste des pays non visités
        /*var i : Int = 0

        paysViewModel.allPays.observe(this, Observer { countries ->

            countryList = countries as MutableList<Pays>
            for (item in countryList){
                if (!(item.visited)) {
                    Log.d(ContentValues.TAG, "ICI !dans la boucle" + item.info.name )
                    countryListnotvisited.add(i,item)
                    i = i+1
                }
            }

            //val rnds = (0..i).random()
            //Log.d(ContentValues.TAG,"Random = "+ rnds + "       i = " + i)
            if (i>0)
                ThecountryListnotvisited.add(0,countryListnotvisited[0])
            else
                aucunPaysNonVisite.setText("Vous avez découvert tous les pays ! en attendant un nouveau pays")


            countryAdapter = CountryAdapter(ThecountryListnotvisited)
            paysnonvisites.apply {
                adapter = countryAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            countryAdapter.onItemClick = {paysId ->
                val intent = Intent(this, CountryInfoActivity::class.java)
                ThecountryListnotvisited.removeAt(0)
                intent.putExtra("id_Pays",paysId)
                startActivity(intent)
            }
        })*/






        //tous les pays
        paysViewModel.allPays.observe(this, Observer { countries ->
            countryList = countries as MutableList<Pays>
            countryAdapter = CountryAdapter(countryList)
            countrylist.apply {
                adapter = countryAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            countryAdapter.onItemClick = {paysId ->
                val intent = Intent(this, CountryInfoActivity::class.java)
                /*if (i>0) {
                    if (ThecountryListnotvisited[0].paysId == paysId) {
                        ThecountryListnotvisited.removeAt(0)
                    }
                }*/
                intent.putExtra("id_Pays",paysId)
                startActivity(intent)
            }
        })

    }
}



