package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private var coffeeId: Int = -1
    private var titleTextView: TextView? = null
    private var descTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        titleTextView = view.findViewById(R.id.coffee_title)
        descTextView = view.findViewById(R.id.coffee_desc)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

    fun setCoffeeData(id: Int) {
        coffeeId = id
        when (coffeeId) {
            1 -> {
                titleTextView?.text = getString(R.string.affogato_title)
                descTextView?.text = getString(R.string.affogato_desc)
            }
            2 -> {
                titleTextView?.text = getString(R.string.americano_title)
                descTextView?.text = getString(R.string.americano_desc)
            }
            3 -> {
                titleTextView?.text = getString(R.string.latte_title)
                descTextView?.text = getString(R.string.latte_desc)
            }
            else -> {
                titleTextView?.text = ""
                descTextView?.text = ""
            }
        }
    }

    companion object {
        private const val COFFEE_ID = "COFFEE_ID"

        fun newInstance(coffeeId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(COFFEE_ID, coffeeId)
                }
            }
    }
}
