package com.example.rjjavaexample

import android.annotation.SuppressLint
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        Observable.fromArray("ted", "ryan", "bill")
            .subscribeOn(Schedulers.newThread())
            .filter{item ->
             item == "ted"}.map {
                 "$it is super"
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { onNext ->
             textView.text = onNext
            }

        getTextFromNetwork(textView2)

    }

        fun  getTextFromNetwork(textView: TextView) {
            val ob = Observable.create { subscriber ->
                val net = "pass"
                subscriber.onNext(net)
                subscriber.onComplete()
            }
            ob.subscribeOn(Schedulers.newThread())
            ob.observeOn(AndroidSchedulers.mainThread())
                .subscribe { onNext ->
                    textView.text = onNext
                }

        }
}