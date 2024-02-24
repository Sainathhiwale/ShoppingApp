package com.examen.shoppingapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.examen.shoppingapp.R
import com.examen.shoppingapp.databinding.ActivityLoginBinding
import com.examen.shoppingapp.utils.CommonUtils.validateLoginRequest
import com.examen.shoppingapp.utils.NetworkUtils
import com.examen.shoppingapp.viewmodel.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityLoginBinding: ActivityLoginBinding
    @Inject
     lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding.root)

       /* activityLoginBinding.loginUsername.setText("johnd")
        activityLoginBinding.loginPassword.setText("m38rmF$")*/
        initView()
        initViewModel()
    }

    private fun initView() {
        activityLoginBinding.loginButton.setOnClickListener(this)
        activityLoginBinding.loginSignup.setOnClickListener(this)
    }
    private fun initViewModel(){

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_button ->{
                if (NetworkUtils.isNetworkAvailable(this)){
                    loginUser()
                }else{
                    Snackbar.make(activityLoginBinding.constraintLogin,"No Internet Connection",Snackbar.LENGTH_SHORT).show()
                }

            }
            R.id.login_signup ->{
             navigateSignUpScreen()
            }
        }
    }

    private fun navigateSignUpScreen() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun loginUser() {
        val username = activityLoginBinding.loginUsername.editableText.toString()
        val password = activityLoginBinding.loginPassword.editableText.toString()

        val result = validateLoginRequest(username, password)
        if (result.successful){
            activityLoginBinding.loginProgress.visibility = View.VISIBLE
            activityLoginBinding.loginButton.isEnabled = false
            loginViewModel.loginUser(username,password)

            loginViewModel.successful.observe(this){ successful ->
                if (successful == true){
                    activityLoginBinding.loginProgress.visibility = View.INVISIBLE
                    activityLoginBinding.loginButton.isEnabled = true
                    Snackbar.make(activityLoginBinding.loginButton,"Login is successfully", Snackbar.LENGTH_SHORT).show()

                  //  findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                   // viewModel.navigated()
                }else if(successful == false){
                    activityLoginBinding.loginProgress.visibility = View.INVISIBLE
                    activityLoginBinding.loginButton.isEnabled = true
                    Snackbar.make(activityLoginBinding.loginButton,"${loginViewModel.error.value}", Snackbar.LENGTH_SHORT).show()
                   // viewModel.navigated()
                }
            }
        }else{
            activityLoginBinding.textViewError.text = result.error
            Snackbar.make(activityLoginBinding.loginButton,"${result.error}",Snackbar.LENGTH_SHORT).show()
        }
    }
}