package com.dharmendra.intentexample


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast


class ImplicitIntentActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.implicit_intent_activity)

        //Find View By Id for both Button

        val camera = findViewById<Button>(R.id.camera)
        val map = findViewById<Button>(R.id.map)

        //Set on Click for both handle in onClick method

        camera.setOnClickListener(this)
        map.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        //Get selected Button Id
        val selectedButtonId = v!!.id

        //Initialize Intent
        val intent: Intent

        when (selectedButtonId) {
            R.id.map -> {

                //If Google Map in Not install Or any other Error occurs So we use try-catch block

                try {
                    intent = Intent(Intent.ACTION_VIEW)

                    //We need to pass Latitude And Longitude to open Location On Map
                    intent.data = Uri.parse("geo:20.379146,72.913831")
                    startActivity(intent)
                } catch (error: Exception) {

                    Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()

                }

            }
            R.id.camera -> {

                //If Camera in Not install Or any other Error occurs So we use try-catch block
                try {
                    intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                } catch (error: Exception) {

                    Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()

                }


            }
        }
    }
}