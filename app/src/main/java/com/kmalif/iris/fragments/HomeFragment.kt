package com.kmalif.iris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmalif.iris.adapters.SpeciesAdapter
import com.kmalif.iris.databinding.FragmentHomeBinding
import com.kmalif.iris.models.Species
import com.kmalif.iris.models.SpeciesData


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var speciesAdapter: SpeciesAdapter
    private var listSpecies: ArrayList<Species> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        showSpeciestoRecycler()
        return binding.root
    }

    private fun showSpeciestoRecycler(){
        listSpecies.addAll(SpeciesData.listSpecies)
        speciesAdapter = SpeciesAdapter(listSpecies)
        val lm =LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        binding.RVIris.apply {
            adapter = speciesAdapter
            layoutManager = lm

        }
    }


}