package com.example.recyclerview3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview3.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {

    private var _ui: ActivityContentBinding? = null
    private val ui: ActivityContentBinding
        get() = _ui!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _ui = ActivityContentBinding.inflate(layoutInflater)
        setContentView(ui.root)
        val item = intent.getSerializableExtra("item") as PizzaModel
        ui.apply {
            imMain.setImageResource(item.imageId)
            tvContentTitle.text = item.title
            tvContentDesc.text = item.description
        }
    }
}