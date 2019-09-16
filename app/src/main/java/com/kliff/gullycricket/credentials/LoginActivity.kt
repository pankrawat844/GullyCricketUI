package com.kliff.gullycricket.credentials

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "NavigationActivity"
        const val SHAREDPREFS = "sharedPrefs"
        const val IFSTORED = "isStored"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(loginToolbar)

        val preferences = getSharedPreferences(SHAREDPREFS, Context.MODE_PRIVATE)
        val isStored = preferences.getBoolean(IFSTORED, false)
        val editor = preferences.edit()

        if (!isStored) {
            Log.e(TAG, "onCreate: User Not Registered. $isStored")
            editor.putBoolean(IFSTORED, false)
            editor.apply()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, Constants.countryCode)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_code.adapter = arrayAdapter

        var number: String?

        next.setOnClickListener {
            val code = Constants.countryAreaCode[country_code.selectedItemPosition]

            if (validNumber()) {
                number = phoneNumber.editText?.text.toString()
                val numberCode = code + number

                startActivity(Intent(this, PhoneVerificationActivity::class.java).apply {
                    putExtra("phoneNumber", numberCode)
                    finish()
                })
            }
        }

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun validNumber(): Boolean {
        val number = phoneNumber.editText?.text.toString()

        return when {
            "" == number -> {
                phoneNumber.error = "Please enter a valid number."
                false
            }
            number.length < 10 -> {
                phoneNumber.error = "Phone number should contain 10 digits."
                false
            }
            else -> {
                phoneNumber.error = ""
                true
            }
        }
    }
}
