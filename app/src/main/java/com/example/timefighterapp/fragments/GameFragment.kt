package com.example.timefighterapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.timefighterapp.databinding.FragmentGameBinding
import com.example.timefighterapp.getScore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameFragment : Fragment() {
    private var _binding : FragmentGameBinding? = null
    val binding get() =  _binding!!
    private val fragArgs : GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bestScore = getScore(requireContext(), fragArgs.gameMode)

        binding.textTimer.text = fragArgs.gameMode.toString()
        binding.textBestScore.text = bestScore.toString()

        binding.button.setOnClickListener {
            binding.textNumber.text = (binding.textNumber.text.toString().toInt() + 1).toString()
        }

        lifecycleScope.launch {
            while(binding.textTimer.text.toString().toInt() > 0){
                delay(1000)
                binding.textTimer.text = (binding.textTimer.text.toString().toInt() - 1).toString()
            }

            findNavController().navigate(GameFragmentDirections.actionGameFragmentToResultFragment(
                finalScore = binding.textNumber.text.toString().toInt(),
                gameMode = fragArgs.gameMode
            ))
        }
    }
}