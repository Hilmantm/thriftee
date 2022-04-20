package id.kodesumsi.thriftee.ui.home.akun

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseAdapter
import id.kodesumsi.thriftee.base.BaseFragment
import id.kodesumsi.thriftee.databinding.FragmentAkunBinding
import id.kodesumsi.thriftee.databinding.ItemProfileBinding
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

        // Log.d("AkunFragment", "account:\n email => ${account?.email}\nname => ${account?.displayName}\nphotoUrl => ${account?.photoUrl}\netc => ${account?.account?.name}")
    }

    override fun setupViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentAkunBinding {
        return FragmentAkunBinding::inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        Glide.with(requireContext()).load(account?.photoUrl).into(binding.profilePicture)
        binding.profileName.text = account?.account?.name ?: account?.email.toString()

        val profileSettingArray = arrayListOf<String>()
        profileSettingArray.apply {
            addAll(arrayOf(PROFIL, ALAMAT, HISTORY, VOUCHER_SAYA))
        }
        val profileSettingAdapter = BaseAdapter<ItemProfileBinding, String>(ItemProfileBinding::inflate) { setting, itemBinding ->
            itemBinding.itemProfileTitle.text = setting
            when(setting) {
                PROFIL -> {
                    // to setting profile page
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                ALAMAT -> {
                    // to setting alamat page
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                HISTORY -> {
                    // to history page
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                VOUCHER_SAYA -> {
                    // to voucher page
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.settingRv.layoutManager = LinearLayoutManager(requireContext())
        binding.settingRv.adapter = profileSettingAdapter

        val profileAboutArray = arrayListOf<String>()
        profileAboutArray.apply {
            addAll(arrayOf(TENTANG_THRIFTEE, PUSAT_BANTUAN, PRIVACY_POLICY, TERMS_AND_CONDITION, KELUAR))
        }
        val aboutAdapter = BaseAdapter<ItemProfileBinding, String>(ItemProfileBinding::inflate) { setting, itemBinding ->
            itemBinding.itemProfileTitle.text = setting
            when(setting) {
                TENTANG_THRIFTEE -> {
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                PUSAT_BANTUAN -> {
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                PRIVACY_POLICY -> {
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                TERMS_AND_CONDITION -> {
                    Toast.makeText(requireContext(),"Belum tersedia", Toast.LENGTH_SHORT).show()
                }
                KELUAR -> {
                    itemBinding.itemProfileTitle.setTextColor(requireContext().getColor(R.color.exit_color))
                    itemBinding.moreBtn.setColorFilter(requireContext().getColor(R.color.exit_color))
                    mGoogleSignInClient.signOut().addOnCompleteListener {
                        signOut()
                    }
                }
            }
        }
        binding.aboutRv.layoutManager = LinearLayoutManager(requireContext())
        binding.aboutRv.adapter = aboutAdapter

//        binding.logoutBtn.setOnClickListener {
//            mGoogleSignInClient.signOut().addOnCompleteListener {
//                signOut()
//            }
//        }
    }

    private fun signOut() {
        val toLoginActivity = Intent(requireContext(), AuthActivity::class.java)
        startActivity(toLoginActivity)
        requireActivity().finish()
    }

    companion object {
        const val PROFIL = "Profil"
        const val ALAMAT = "Alamat"
        const val HISTORY = "History"
        const val VOUCHER_SAYA = "Voucher Saya"

        const val TENTANG_THRIFTEE = "Tentang Thriftee"
        const val PUSAT_BANTUAN = "Pusat Bantuan"
        const val PRIVACY_POLICY = "Privacy Policy"
        const val TERMS_AND_CONDITION = "Terms and Condition"
        const val KELUAR = "Keluar"
    }

}