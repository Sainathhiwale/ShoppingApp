package com.examen.shoppingapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.shoppingapp.R
import com.examen.shoppingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var activitySignUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(activitySignUpBinding.root)
        //setContentView(R.layout.activity_sign_up)
    }
}