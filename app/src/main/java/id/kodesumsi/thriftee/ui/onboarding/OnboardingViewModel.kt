package id.kodesumsi.thriftee.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel: ViewModel() {

    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()

    fun changePosition(position: Int) {
        _currentPosition.postValue(position)
    }

    fun getCurrentPosition(): LiveData<Int> = _currentPosition

}