package com.example.copyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class PlaceHolderFragment : Fragment() {

    companion object {

        fun newInstance(): PlaceHolderFragment = PlaceHolderFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place_holder, container, false)
    }
}
