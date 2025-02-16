package com.example.kopikenangan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.Adapter.AdapterMenu
import com.example.kopikenangan.databinding.FragmentProfileBinding
import com.example.kopikenangan.dataclass.Menu


class ProfileFragment : Fragment() {

    lateinit var rvMenu: RecyclerView
    lateinit var binding: FragmentProfileBinding
    private val listMenu = ArrayList<Menu>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        rvMenu = binding.rvMenu
        rvMenu.setHasFixedSize(true)
        listMenu.addAll(getListMenu())
        showRecyclerList()

        binding.btnChekIn.setOnClickListener {
            Toast.makeText(requireContext(), "Berhasil ${binding.txtKoin.text}", Toast.LENGTH_SHORT).show()
        }


        return view
    }
    private fun showRecyclerList() {
        rvMenu.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val AdapterMenu = AdapterMenu(listMenu)
        rvMenu.adapter = AdapterMenu
    }
    private fun getListMenu(): ArrayList<Menu> {
        val dataName = resources.getStringArray(R.array.menu_profil)
        val dataPhoto = resources.obtainTypedArray(R.array.icon_profil)

        val listMenu = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menu = Menu(dataPhoto.getResourceId(i, -1),
                dataName[i])
            listMenu.add(menu)
        }
        return listMenu
    }

}