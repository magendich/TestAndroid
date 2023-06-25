package com.example.recyclerview3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PizzaAdapter.Listener {

    private var _ui: ActivityMainBinding? = null
    private val ui: ActivityMainBinding
        get() = _ui!!

    private var adapter: PizzaAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        initial()
    }

    private fun initial() {
        ui.rvPizza.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView = ui.rvPizza
        adapter = PizzaAdapter(this)
        recyclerView!!.adapter = adapter
        adapter!!.setList(receivePizza())
    }

    fun receivePizza(): ArrayList<PizzaModel> {
        var pizzaList = ArrayList<PizzaModel>()

        val pizza1 = PizzaModel(R.drawable.cheeze_chicken, "Сырная курица", "Сочная сырная пицца", 350)
        val pizza2 = PizzaModel(R.drawable.chicken_curry, "Курица Карри", "Пицца для любителей острых ощущений", 500)
        val pizza3 = PizzaModel(R.drawable.chirrozo, "Чиррозо", "Пицца для любителей острых ощущений", 430)
        val pizza4 = PizzaModel(R.drawable.peperoni, "Пеперони", "Вкусная пицца с колбасками", 380)
        val pizza5 = PizzaModel(R.drawable.vetchina, "Ветчина и сыр","Сборная пицца из 4 самых вкусных пицц", 600)

        pizzaList.add(pizza1)
        pizzaList.add(pizza2)
        pizzaList.add(pizza3)
        pizzaList.add(pizza4)
        pizzaList.add(pizza5)

        return pizzaList
    }

    override fun onClick(pizza: PizzaModel) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", pizza)
        })
      }



}

