package id.kodesumsi.thriftee.ui.home.akun

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseFragment
import id.kodesumsi.thriftee.databinding.FragmentAkunBinding
import id.kodesumsi.thriftee.ui.auth.AuthActivity

class AkunFragment : BaseFragment<FragmentAkunBinding>() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        val account = GoogleSignIn.getLastSignedInAccount(requireContext())

        Log.d("AkunFragment", "account:\n email => ${account?.email}\nname => ${account?.displayName}\nphotoUrl => ${account?.photoUrl}\netc => ${account?.account?.name}")
    }

    override fun setupViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentAkunBinding {
        return FragmentAkunBinding::inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoutBtn.setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                signOut()
            }
        }
    }

    private fun signOut() {
        val toLoginActivity = Intent(requireContext(), AuthActivity::class.java)
        startActivity(toLoginActivity)
        requireActivity().finish()
    }

}