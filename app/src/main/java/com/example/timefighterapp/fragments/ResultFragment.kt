package com.example.timefighterapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.timefighterapp.R
import com.example.timefighterapp.databinding.FragmentResultBinding
import com.example.timefighterapp.getScore
import com.example.timefighterapp.saveScore

class ResultFragment : Fragment() {
    private var _binding : FragmentResultBinding? = null
    private val binding get() =  _binding!!
    private val fragArgs : ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val finalScore = fragArgs.finalScore
        val maxScoreSoFar = getScore(requireContext(), fragArgs.gameMode)

        binding.textFinalScore.text = finalScore.toString()

        if (finalScore > maxScoreSoFar){
            binding.textCongrats.visibility = View.VISIBLE
            binding.textPrevBestScore.text = "Previous Record: $maxScoreSoFar"

            saveScore(requireContext(), fragArgs.gameMode, finalScore)
        } else {
            binding.textPrevBestScore.text = "Best Score: $maxScoreSoFar"
        }

        binding.buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_menuFragment)
        }
    }
}