package id.kodesumsi.thriftee.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import id.kodesumsi.thriftee.base.BaseActivity
import id.kodesumsi.thriftee.databinding.ActivityOnboardingBinding
import id.kodesumsi.thriftee.ui.auth.AuthActivity

class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>() {

    override fun setupViewBinding(): (LayoutInflater) -> ActivityOnboardingBinding {
        return ActivityOnboardingBinding::inflate
    }

    override fun setupViewInstance(savedInstanceState: Bundle?) {
        val pagerAdapter = OnboardingAdapter(this)
        binding.onboardingVp.adapter = pagerAdapter
        binding.onboardingDotsIndicator.setViewPager2(binding.onboardingVp)
        binding.onboardingNextBtn.setOnClickListener {
            if (binding.onboardingVp.currentItem < 2) {
                binding.onboardingVp.currentItem += 1
            } else {
                binding.onboardingSkipBtn.visibility = View.GONE
                val toAuthActivity = Intent(this, AuthActivity::class.java)
                startActivity(toAuthActivity)
                finish()
            }
        }
        binding.onboardingSkipBtn.setOnClickListener {
            if (binding.onboardingVp.currentItem < 2) {
                binding.onboardingVp.currentItem = 2
                binding.onboardingSkipBtn.visibility = View.GONE
            }
        }
    }

    override fun onBackPressed() {
        if(binding.onboardingVp.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.onboardingVp.currentItem -= 1
            binding.onboardingSkipBtn.visibility = View.VISIBLE
        }
    }
}