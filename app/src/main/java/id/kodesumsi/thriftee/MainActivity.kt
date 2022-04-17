package id.kodesumsi.thriftee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import id.kodesumsi.thriftee.base.BaseActivity
import id.kodesumsi.thriftee.databinding.ActivityMainBinding
import id.kodesumsi.thriftee.ui.auth.AuthActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun setupViewBinding(): (LayoutInflater) -> ActivityMainBinding {
        return ActivityMainBinding::inflate
    }

    override fun setupViewInstance(savedInstanceState: Bundle?) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        Log.d("MainActivity", "account:\n email => ${account?.email}\nname => ${account?.displayName}\nphotoUrl => ${account?.photoUrl}\netc => ${account?.account?.name}")

        binding.logoutBtn.setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                signOut()
            }
        }
    }

    fun signOut() {
        val toLoginActivity = Intent(this, AuthActivity::class.java)
        startActivity(toLoginActivity)
        finish()
    }
}