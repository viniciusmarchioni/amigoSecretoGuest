package com.example.amigosecretoguest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.amigosecretoguest.R
import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.example.amigosecretoguest.ModularLayoutActivity
import com.example.amigosecretoguest.model.Sessao

class AdapterGame(private val context: Context, private val games: MutableList<Sessao>) :
    RecyclerView.Adapter<AdapterGame.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val item =
            LayoutInflater.from(context).inflate(R.layout.holder_recycle_layout, parent, false)
        return GameViewHolder(item)
    }

    override fun getItemCount(): Int = games.size


    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.buttonGameID.text = games[position].sessionID
        holder.participantes.text = "Participantes:\n${games[position].size}"
        holder.buttonGameID.setOnClickListener {
            val novaTela = Intent(context, ModularLayoutActivity::class.java)
            novaTela.putExtra("titulo", holder.buttonGameID.text)
            context.startActivity(novaTela)
        }
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonGameID: Button = itemView.findViewById(R.id.gameidbutton)
        val participantes: TextView = itemView.findViewById(R.id.qntparticipantes)
    }

}