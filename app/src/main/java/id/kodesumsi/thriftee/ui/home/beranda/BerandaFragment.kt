package id.kodesumsi.thriftee.ui.home.beranda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseFragment
import id.kodesumsi.thriftee.databinding.FragmentBerandaBinding

class BerandaFragment : BaseFragment<FragmentBerandaBinding>() {
    override fun setupViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentBerandaBinding {
        return FragmentBerandaBinding::inflate
    }

}