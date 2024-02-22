package com.examen.shoppingapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.examen.shoppingapp.R
import com.examen.shoppingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activitySignUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(activitySignUpBinding.root)
        initView()
    }

    private fun initView() {
        activitySignUpBinding.registerButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.register_button ->{
                val toast = Toast.makeText(this, "clicked", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}