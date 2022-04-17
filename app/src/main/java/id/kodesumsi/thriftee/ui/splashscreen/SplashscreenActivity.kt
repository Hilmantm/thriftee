package id.kodesumsi.thriftee.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import id.kodesumsi.thriftee.base.BaseActivity
import id.kodesumsi.thriftee.databinding.ActivitySplashscreenBinding
import id.kodesumsi.thriftee.ui.auth.AuthActivity
import id.kodesumsi.thriftee.ui.onboarding.OnboardingActivity
import id.kodesumsi.thriftee.utils.Constant.Companion.SPLASHSCREEN_DELAY

class SplashscreenActivity : BaseActivity<ActivitySplashscreenBinding>() {

    override fun setupViewBinding(): (LayoutInflater) -> ActivitySplashscreenBinding {
        return ActivitySplashscreenBinding::inflate
    }

    override fun setupViewInstance(savedInstanceState: Bundle?) {
        Handler(mainLooper).postDelayed({
            val intentToOnboarding = Intent(this, OnboardingActivity::class.java)
            startActivity(intentToOnboarding)
            finish()
        }, SPLASHSCREEN_DELAY)
    }
}