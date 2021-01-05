package com.example.navigationdrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.navigationdrawer.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        homeViewModel.goGallery.observe(viewLifecycleOwner, {
            if(!it) return@observe
            val action = HomeFragmentDirections.actionNavHomeToNavGallery()
            val view = requireView()
            view.findNavController().navigate(action)
            homeViewModel.endGoGallery()
        })

        val button = root.findViewById<Button>(R.id.go_gallery_button)
        button.setOnClickListener {
            homeViewModel.onGoGalleryButtonClick()
        }

        return root
    }


}