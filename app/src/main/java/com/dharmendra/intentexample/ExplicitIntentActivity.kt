package com.dharmendra.intentexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class ExplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explicit_intent_activity)

        //Find View By Id for Our textView

        val name = findViewById<TextView>(R.id.name)
        val number = findViewById<TextView>(R.id.number)

        //Create Object to get Intent Data
        val i = intent.extras

        //get name Pass from MainActivity
        val myname = i.getString("name")


        //get Contact Number Pass from MainActivity
        val myContact = i.getInt("contact")

        /* You can set Text in TextView in both way as Shown Below*/
        name.setText(myname)

        number.text = myContact.toString()


    }

}
