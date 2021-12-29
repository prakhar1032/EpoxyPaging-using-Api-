package com.epox.epoxypaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView

class CharacterListActivity : AppCompatActivity() {

    private val epoxyController = CharacterListPagingEpoxyController()
    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)


        viewModel.charactersPagedListLiveData.observe(this){
            pagedList->epoxyController.submitList(pagedList)
        }

        findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView).setController(epoxyController)

    }
}