package com.mahdi20.offlinefirst.ui.uimodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.mahdi20.offlinefirst.BR


class Repository(
    repositoryName: String, var repositoryOwner: String?, var numberOfStars: Int?
    , var hasIssues: Boolean = false
) : BaseObservable() {

    @get:Bindable
    var repositoryName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.repositoryName)
        }

}