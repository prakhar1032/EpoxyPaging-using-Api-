package com.epox.epoxypaging

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.epox.epoxypaging.databinding.ModelCharacterListItemSquareBinding
import com.epox.epoxypaging.epoxy.ViewBindingKotlinModel
import com.epox.epoxypaging.response.GetCharacterByIdResponse
import com.squareup.picasso.Picasso

class CharacterListPagingEpoxyController: PagedListEpoxyController<GetCharacterByIdResponse>() {

    override fun buildItemModel(
        currentPosition: Int,
        item: GetCharacterByIdResponse?
    ): EpoxyModel<*> {
        return CharacterGridItemEpoxyModel(
            characterId = item!!.id,
            imageUrl = item.image,
            name = item.name
        ).id(item.id)
    }



    // region Data Classes
    data class CharacterGridItemEpoxyModel(
        val characterId: Int,
        val imageUrl: String,
        val name: String
    ): ViewBindingKotlinModel<ModelCharacterListItemSquareBinding>(R.layout.model_character_list_item_square) {

        override fun ModelCharacterListItemSquareBinding.bind() {
            Picasso.get().load(imageUrl).into(characterImageView)
            characterNameTextView.text = name

        }
    }

}