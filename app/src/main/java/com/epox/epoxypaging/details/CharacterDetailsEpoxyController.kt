//package com.epox.epoxypaging.details
//
//
//import com.airbnb.epoxy.EpoxyController
//import com.epox.epoxypaging.R
//import com.epox.epoxypaging.databinding.CharacterImageBinding
//import com.epox.epoxypaging.databinding.CharacterNameBinding
//import com.epox.epoxypaging.databinding.CharacterSpeciesBinding
//import com.epox.epoxypaging.epoxy.ViewBindingKotlinModel
//import com.epox.epoxypaging.response.GetCharacterByIdResponse
//import com.squareup.picasso.Picasso
//
//class CharacterDetailsEpoxyController() : EpoxyController() {
//
//    var isLoading: Boolean = true
//        set(value) {
//            field = value
//            if (field) {
//                requestModelBuild()
//            }
//        }
//
//    var characterResponse: GetCharacterByIdResponse? = null
//        set(value) {
//            field = value
//            if (field != null) {
//                isLoading = false
//                requestModelBuild()
//            }
//        }
//
//    override fun buildModels() {
//
//        if (isLoading) {
//            return
//        }
//
//        if (characterResponse == null){
//            return
//        }
//
//        // Header Model
//        NameEpoxyModel(
//            name = characterResponse!!.name
//        ).id("name").addTo(this)
//
//        // Image Model
//        ImageEpoxyModel(
//            imageUrl = characterResponse!!.image
//        ).id("image").addTo(this)
//
//        // species models
//        SpeciesEpoxyModel(
//            species = characterResponse!!.species
//        ).id("data_point_1").addTo(this)
//
//    }
//
//
//    data class NameEpoxyModel(
//        val name: String
//
//    ) : ViewBindingKotlinModel<CharacterNameBinding>(R.layout.character_name) {
//
//        override fun CharacterNameBinding.bind() {
//            charname.text = name
//
//        }
//    }
//
//    data class ImageEpoxyModel(
//        val imageUrl: String
//    ) : ViewBindingKotlinModel<CharacterImageBinding>(R.layout.character_image) {
//
//        override fun CharacterImageBinding.bind() {
//            Picasso.get().load(imageUrl).into(charimage)
//        }
//    }
//
//    data class SpeciesEpoxyModel(
//        val species: String
//    ) : ViewBindingKotlinModel<CharacterSpeciesBinding>(R.layout.character_species) {
//
//        override fun CharacterSpeciesBinding.bind() {
//            charspecies.text = species
//        }
//    }
//
//
//}