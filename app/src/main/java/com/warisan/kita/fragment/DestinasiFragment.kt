package com.warisan.kita.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.warisan.kita.adapter.DestinasiAdapter
import com.warisan.kita.databinding.FragmentDestinasiBinding
import com.warisan.kita.model.Destinasi
import com.warisan.kita.model.Provinsi


class DestinasiFragment : Fragment() {
    private lateinit var binding: FragmentDestinasiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDestinasiBinding.inflate(inflater,container,false)
        val provinsi = arguments?.getSerializable("provinsi") as Provinsi
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = provinsi.nama
        with(binding){
            val layoutManager = GridLayoutManager(requireContext(), 2)
            layoutManager.orientation = RecyclerView.VERTICAL
            rvDestinasi.layoutManager = layoutManager
            rvDestinasi.adapter = DestinasiAdapter(provinsi.destinasi,object : DestinasiAdapter.DestinasiAdapterListener{
                override fun onClick(destinasi: Destinasi) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(destinasi.url))
                    startActivity(intent)
                }
            })
        }
        return binding.root
    }
}