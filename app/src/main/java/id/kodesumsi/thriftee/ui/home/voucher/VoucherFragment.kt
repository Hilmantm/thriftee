package id.kodesumsi.thriftee.ui.home.voucher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseFragment
import id.kodesumsi.thriftee.databinding.FragmentVoucherBinding

class VoucherFragment : BaseFragment<FragmentVoucherBinding>() {
    override fun setupViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentVoucherBinding {
        return FragmentVoucherBinding::inflate
    }

}