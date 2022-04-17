package id.kodesumsi.thriftee.ui.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseFragment
import id.kodesumsi.thriftee.databinding.FragmentOnboardingBinding
import java.text.FieldPosition


class OnboardingFragment(private val position: Int) : BaseFragment<FragmentOnboardingBinding>() {

    override fun setupViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentOnboardingBinding {
        return FragmentOnboardingBinding::inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // position start from 0
        Log.d("OnboardingFragment", "positino: $position")
    }

}