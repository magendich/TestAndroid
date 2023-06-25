package com.example.recyclerview3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview3.databinding.PizzaItemLayoutBinding

class PizzaAdapter(val listener: Listener): RecyclerView.Adapter<PizzaAdapter.PizzaHolder>() {

    private var pizzaList = emptyList<PizzaModel>()

    class PizzaHolder(val ui: PizzaItemLayoutBinding): RecyclerView.ViewHolder(ui.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaHolder {
        return PizzaHolder(PizzaItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PizzaHolder, position: Int) {
        holder.ui.imPizza.setImageResource(pizzaList[position].imageId)
        holder.ui.tvTitle.text = pizzaList[position].title
        holder.ui.tvDesc.text = pizzaList[position].description
        holder.ui.buyButton.text = "от " + pizzaList[position].pizzaPrice.toString() + "₽"
        holder.itemView.setOnClickListener {
            listener.onClick(pizza = pizzaList[position])
        }
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    fun setList(list: List<PizzaModel>) {
        pizzaList = list
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(pizza: PizzaModel)
    }
}