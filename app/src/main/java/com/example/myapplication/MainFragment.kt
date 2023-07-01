package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    private var ultimoValor = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botao = view.findViewById<Button>(R.id.botao)
        val textview = view.findViewById<TextView>(R.id.textview)
        val imagem = view.findViewById<ImageView>(R.id.imagem)
        botao.setOnClickListener {
            val valor = (1..6).random()
            textview.text = getString(R.string.valor_do_dado, valor)
            when (valor) {
                1 -> imagem.setImageResource(R.drawable.dice1)
                2 -> imagem.setImageResource(R.drawable.dice2)
                3 -> imagem.setImageResource(R.drawable.dice3)
                4 -> imagem.setImageResource(R.drawable.dice4)
                5 -> imagem.setImageResource(R.drawable.dice5)
                6 -> imagem.setImageResource(R.drawable.dice6)
            }
            if (valor == ultimoValor) {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToRepeatedNumberFragment(valor))
            }
            ultimoValor = valor
        }
    }
}