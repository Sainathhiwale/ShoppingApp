package com.examen.shoppingapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.examen.shoppingapp.R
import com.examen.shoppingapp.databinding.ActivitySignUpBinding
import com.examen.shoppingapp.utils.CommonUtils.validateLoginRequest
import com.examen.shoppingapp.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activitySignUpBinding: ActivitySignUpBinding
    @Inject
    lateinit var registerViewModel: RegisterViewModel
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

                registerUser()
              /*  val toast = Toast.makeText(this, "clicked", Toast.LENGTH_SHORT)
                toast.show()*/
            }
        }
    }

    private fun registerUser() {
        val username = activitySignUpBinding.registerUsername.editableText.toString()
        val password = activitySignUpBinding.registerPassword.editableText.toString()

        val result = validateLoginRequest(username, password)

        if (result.successful){
            activitySignUpBinding.registerProgress.visibility = View.VISIBLE
            activitySignUpBinding.registerButton.isEnabled = false

            registerViewModel.registerUser(username, password)

            registerViewModel.successful.observe(this){successful->
                if (successful == true){
                    activitySignUpBinding.registerProgress.visibility = View.INVISIBLE
                    activitySignUpBinding.registerButton.isEnabled = true
                    navigateLoginScreen()
                }else if (successful == false){
                    activitySignUpBinding.registerProgress.visibility = View.INVISIBLE
                    activitySignUpBinding.registerButton.isEnabled = true
                    Snackbar.make(activitySignUpBinding.registerButton,"${registerViewModel.error.value}", Snackbar.LENGTH_SHORT).show()
                }
            }

        }else{
            Snackbar.make(activitySignUpBinding.registerButton,"${result.error}", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun navigateLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}