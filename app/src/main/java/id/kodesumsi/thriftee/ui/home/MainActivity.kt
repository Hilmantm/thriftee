package id.kodesumsi.thriftee.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseActivity
import id.kodesumsi.thriftee.databinding.ActivityMainBinding
import id.kodesumsi.thriftee.ui.auth.AuthActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): (LayoutInflater) -> ActivityMainBinding {
        return ActivityMainBinding::inflate
    }

    override fun setupViewInstance(savedInstanceState: Bundle?) {

        val navController = this.findNavController(R.id.main_nav_host)
        binding.mainBnv.setupWithNavController(navController)
    }

}