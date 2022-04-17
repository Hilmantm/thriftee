package id.kodesumsi.thriftee.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val ONBOARDING_ITEMS = 3

class OnboardingAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = ONBOARDING_ITEMS

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment(position)
    }

}