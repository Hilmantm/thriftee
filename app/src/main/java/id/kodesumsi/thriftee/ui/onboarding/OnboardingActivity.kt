package id.kodesumsi.thriftee.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.kodesumsi.thriftee.base.BaseActivity
import id.kodesumsi.thriftee.databinding.ActivityOnboardingBinding
import id.kodesumsi.thriftee.ui.auth.AuthActivity

@AndroidEntryPoint
class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>() {

    private val viewModel: OnboardingViewModel by viewModels()

    override fun setupViewBinding(): (LayoutInflater) -> ActivityOnboardingBinding {
        return ActivityOnboardingBinding::inflate
    }

    override fun setupViewInstance(savedInstanceState: Bundle?) {
        val pagerAdapter = OnboardingAdapter(this)
        binding.onboardingVp.adapter = pagerAdapter
        binding.onboardingDotsIndicator.setViewPager2(binding.onboardingVp)

        viewModel.changePosition(binding.onboardingVp.currentItem)
        viewModel.getCurrentPosition().observe(this) { position ->
            if (position == 2) {
                binding.onboardingSkipBtn.visibility = View.GONE
            }
            binding.onboardingNextBtn.setOnClickListener {
                if (position < 2) {
                    binding.onboardingVp.currentItem += 1
                    viewModel.changePosition(binding.onboardingVp.currentItem)
                } else {
                    val toAuthActivity = Intent(this, AuthActivity::class.java)
                    startActivity(toAuthActivity)
                    finish()
                }
            }

            binding.onboardingSkipBtn.setOnClickListener {
                if (position < 2) {
                    binding.onboardingVp.currentItem = 2
                    viewModel.changePosition(binding.onboardingVp.currentItem)
                    binding.onboardingSkipBtn.visibility = View.GONE
                }
            }
        }
    }

    override fun onBackPressed() {
        if(binding.onboardingVp.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.onboardingVp.currentItem -= 1
            viewModel.changePosition(binding.onboardingVp.currentItem)
            binding.onboardingSkipBtn.visibility = View.VISIBLE
        }
    }
}