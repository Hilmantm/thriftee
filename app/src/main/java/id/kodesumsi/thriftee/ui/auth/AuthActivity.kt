package id.kodesumsi.thriftee.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import id.kodesumsi.thriftee.base.BaseActivity
import id.kodesumsi.thriftee.databinding.ActivityAuthBinding

class AuthActivity : BaseActivity<ActivityAuthBinding>() {

    override fun setupViewBinding(): (LayoutInflater) -> ActivityAuthBinding {
        return ActivityAuthBinding::inflate
    }

    override fun setupViewInstance(savedInstanceState: Bundle?) {

    }

}