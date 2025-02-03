package com.example.timefighterapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.timefighterapp.databinding.FragmentMenuBinding
import com.example.timefighterapp.getScore

class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding? = null
    val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button15 = binding.button15
        val button30 = binding.button30
        val button60 = binding.button60

        var time : Int?

        button15.setOnClickListener {
            time = 15
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToGameFragment(
                time!!
            ))
        }

        button30.setOnClickListener {
            time = 30
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToGameFragment(
                time!!
            ))
        }

        button60.setOnClickListener {
            time = 60
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToGameFragment(
                time!!
            ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}