package com.kmalif.iris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kmalif.iris.adapters.HistoryAdapter
import com.kmalif.iris.databinding.FragmentHistoryBinding
import com.kmalif.iris.models.History
import io.realm.Realm


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter
    val lm = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL )
    lateinit var realm: Realm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        showToRecycler()
        return binding.root
    }

    private fun getAllHistory(){
        realm.where(History::class.java).findAll().let {
            historyAdapter.setHistory(it)
        }
    }

    private fun showToRecycler(){
        historyAdapter = HistoryAdapter(mutableListOf())
        binding.RVHistory.apply {
            adapter = historyAdapter
            layoutManager =lm
        }
        Realm.init(activity)
        realm = Realm.getDefaultInstance()
        getAllHistory()
    }


}