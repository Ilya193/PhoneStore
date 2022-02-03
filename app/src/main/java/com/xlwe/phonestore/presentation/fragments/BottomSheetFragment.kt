package com.xlwe.phonestore.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xlwe.phonestore.databinding.BottomSheetBinding
import java.lang.RuntimeException

class BottomSheetFragment: BottomSheetDialogFragment() {
    private var _binding: BottomSheetBinding? = null
    private val binding: BottomSheetBinding
        get() = _binding ?: throw RuntimeException("BottomSheetBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        competitionSpinner()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.close.setOnClickListener {
            dismiss()
        }

        binding.done.setOnClickListener {
            dismiss()
        }
    }

    private fun competitionSpinner() {
        val textForSpinner1 = mutableListOf("Samsumg")
        var adapter = ArrayAdapter(binding.spinnerBrand.context, android.R.layout.simple_spinner_item, textForSpinner1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBrand.adapter = adapter

        val textForSpinner2 = mutableListOf("$300 - $500")
        adapter = ArrayAdapter(binding.spinnerPrice.context, android.R.layout.simple_spinner_item, textForSpinner2)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrice.adapter = adapter

        val textForSpinner3 = mutableListOf("4.5 to 5.5 inches")
        adapter = ArrayAdapter(binding.spinnerSize.context, android.R.layout.simple_spinner_item, textForSpinner3)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSize.adapter = adapter
    }
}