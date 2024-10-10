package com.example.trafficlaws

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var informationET: EditText
    private lateinit var checkBoxCB: CheckBox
    private lateinit var textTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        informationET = findViewById(R.id.infoET)
        checkBoxCB = findViewById(R.id.checkboxCB)
        textTV = findViewById(R.id.infoET)
        checkBoxCB.setOnCheckedChangeListener {buttonView, isChecked ->
            if (checkBoxCB.isChecked) {
                informationET.text.clear()
                informationET.setText(R.string.pdd)
                textTV.setText(getString(R.string.Traffic_Laws))
            }
            else {
                informationET.setText(R.string.info)
                textTV.setText("")
            }
        }
    }
}