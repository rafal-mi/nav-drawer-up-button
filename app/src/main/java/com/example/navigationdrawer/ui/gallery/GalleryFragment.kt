package com.example.navigationdrawer.ui.gallery

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
import com.example.navigationdrawer.ui.EventObserver

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        galleryViewModel.goSlideshowEvent.observe(viewLifecycleOwner, EventObserver {
            if(!it) return@EventObserver
            val action = GalleryFragmentDirections.actionNavGalleryToNavSlideshow()
            requireView().findNavController().navigate(action)

        })

        root.findViewById<Button>(R.id.go_slideshow_button).setOnClickListener {
            galleryViewModel.onGoSlideshowButtonClick()
        }

        return root
    }
}