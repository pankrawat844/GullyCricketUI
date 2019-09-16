package com.kliff.gullycricket.credentials

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.kliff.gullycricket.R
import com.kliff.gullycricket.credentials.LoginActivity.Companion.IFSTORED
import com.kliff.gullycricket.credentials.LoginActivity.Companion.SHAREDPREFS
import com.kliff.gullycricket.credentials.LoginActivity.Companion.TAG
import com.kliff.gullycricket.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_phone_verification.*
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

class PhoneVerificationActivity : AppCompatActivity() {

    var userEnterVerificationCode: String? = null

    private val mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                userEnterVerificationCode = p0
            }

            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                val code = p0?.smsCode
                if (code != null) {
                    codeEntered.editText?.setText(code)
                    verifyCode(code)
                } else {
                    signInWithCredential(p0)
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(
                    this@PhoneVerificationActivity,
                    "Error in Verification.",
                    Toast.LENGTH_LONG
                ).show()
                Logger.getLogger(PhoneVerificationActivity::class.java.name).warning(p0?.message)
            }
        }

    private fun verifyCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(userEnterVerificationCode.toString(), code)
        signInWithCredential(credential)
    }

    private fun signInWithCredential(credential: PhoneAuthCredential?) {
        if (credential != null) {
            mAuth.signInWithCredential(credential)
                .addOnCompleteListener {
                    val preferences = getSharedPreferences(SHAREDPREFS, Context.MODE_PRIVATE)
                    val editor = preferences.edit()
                    editor.putBoolean(IFSTORED, true)
                    editor.apply()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Log.e(TAG, "singIn" + it.message)
                }
        }
    }

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)

        val set = intent.getStringExtra("phoneNumber")

        sendVerificationCode(set)

        verify.setOnClickListener {
            Log.e(TAG, "verify: clicked.")
            val newCode = codeEntered.editText?.text.toString()

            if (verifyEnteredCde(newCode)) {
                verifyCode(newCode)
            }
        }

        backFromVerification.setOnClickListener {
            onBackPressed()
        }
    }

    private fun verifyEnteredCde(newCode: String): Boolean {
        Log.e(TAG, "verificationEnterCode working.")
        return when {
            newCode == "" -> {
                codeEntered.error = "Field should not be empty."
                false
            }
            newCode.length < 6 -> {
                codeEntered.error = "Please Enter a valid code."
                false
            }
            else -> {
                codeEntered.error = ""
                true
            }
        }
    }

    private fun sendVerificationCode(set: String?) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            set!!,
            60,
            TimeUnit.SECONDS,
            this,
            mCallbacks
        )
    }
}
