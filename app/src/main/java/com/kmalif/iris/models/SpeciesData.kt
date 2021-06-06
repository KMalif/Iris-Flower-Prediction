package com.kmalif.iris.models

import com.kmalif.iris.R

object SpeciesData {
    private val speciesName = arrayOf(
        "Germanica",
        "Sibirica",
        "Ayame",
        "Versicolor",
        "Tectorum",
        "Sweet Iris",
        "Pumila",
        "Laevigata",
        "Setosa",
        "Virginica")

    private val speciesImage = arrayOf(
        R.drawable.germanica,
        R.drawable.sibirica,
        R.drawable.ayame,
        R.drawable.versicolor,
        R.drawable.tectorum,
        R.drawable.sweet,
        R.drawable.pumila,
        R.drawable.laevigata,
        R.drawable.setosa,
        R.drawable.virginica
    )

    val listSpecies : ArrayList<Species>
        get() {
            val list = arrayListOf<Species>()
            for (position in speciesName.indices){
                val species = Species()
                species.name = speciesName[position]
                species.image = speciesImage[position]
                list.add(species)
            }
            return list
        }

}