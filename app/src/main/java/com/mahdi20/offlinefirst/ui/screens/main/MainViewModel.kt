package com.mahdi20.offlinefirst.ui.screens.main

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahdi20.offlinefirst.data.GitRepoRepository
import com.mahdi20.offlinefirst.ui.uimodels.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import plusAssign
import javax.inject.Inject

/**
 * View Model
 */
class MainViewModel @Inject constructor(var gitRepoRepository: GitRepoRepository) : ViewModel() {


    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepoRepository
            .getRepositories()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ArrayList<Repository>>() {

                override fun onError(e: Throwable) {
                    //if some error happens in our data layer our app will not crash, we will
                    // get error here
                }

                override fun onNext(data: ArrayList<Repository>) {
                    repositories.value = data
                }

                override fun onComplete() {
                    isLoading.set(false)
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}