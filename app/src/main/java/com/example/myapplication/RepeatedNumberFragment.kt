package com.example.myapplication

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView

class RepeatedNumberFragment : Fragment() {

    private val args : RepeatedNumberFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repeated_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number = view.findViewById<TextView>(R.id.repeated_number)
        val argument = args.number
        number.text = getString(R.string.o_valor_repetido_foi_d, argument)
        val imagem = view.findViewById<ImageView>(R.id.imagem)
        val animationView = view.findViewById<LottieAnimationView>(R.id.animationView)
        imagem.isVisible = false
        when (argument) {
            1 -> imagem.setImageResource(R.drawable.dice1)
            2 -> imagem.setImageResource(R.drawable.dice2)
            3 -> imagem.setImageResource(R.drawable.dice3)
            4 -> imagem.setImageResource(R.drawable.dice4)
            5 -> imagem.setImageResource(R.drawable.dice5)
            6 -> imagem.setImageResource(R.drawable.dice6)
        }

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                animationView.isVisible = false
                imagem.isVisible = true
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}

        })
    }

}