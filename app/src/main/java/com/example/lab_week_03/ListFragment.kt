package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private var listener: CoffeeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.findViewById<TextView>(R.id.affogato).setOnClickListener { listener?.onSelected(1) }
        view.findViewById<TextView>(R.id.americano).setOnClickListener { listener?.onSelected(2) }
        view.findViewById<TextView>(R.id.latte).setOnClickListener { listener?.onSelected(3) }

        return view
    }
}
