package id.kodesumsi.thriftee.ui.home.dropbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kodesumsi.thriftee.R
import id.kodesumsi.thriftee.base.BaseFragment
import id.kodesumsi.thriftee.databinding.FragmentDropboxBinding

class DropboxFragment : BaseFragment<FragmentDropboxBinding>() {
    override fun setupViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentDropboxBinding {
        return FragmentDropboxBinding::inflate
    }

}