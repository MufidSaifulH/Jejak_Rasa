package com.example.kopikenangan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kopikenangan.Adapter.OutletAdapter
import com.example.kopikenangan.Adapter.VoucherAdapter
import com.example.kopikenangan.databinding.FragmentOrderBinding
import com.example.kopikenangan.dataclass.Outlet


class OrderFragment : Fragment() {

    lateinit var binding: FragmentOrderBinding
    lateinit var rvOutlet: RecyclerView
    private val list = ArrayList<Outlet>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

        rvOutlet = binding.rvOutlet
        rvOutlet.setHasFixedSize(true)
        list.addAll(getListOutlet())
        showRecyclerList()

        return view
    }

    private fun showRecyclerList() {
        rvOutlet.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val OutletAdapter = OutletAdapter(list)
        rvOutlet.adapter = OutletAdapter
    }

    private fun getListOutlet(): ArrayList<Outlet> {

        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Lippo Mall Puri",
                alamat = "Jl. Puri Indah Raya Blok U 1, RT.3/RW.2, Kembangan Sel., Jakarta Barat",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Kyai Maja",
                alamat = "Jl. Kyai Maja No.29 Blok M, RT.10/RW.7, Kramat Pela, Jakarta Selatan",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Menara Standard Chartered",
                alamat = "Standard Chartered, GF, Jl. Prof. DR. Satrio No.164, Jakarta Selatan",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Setiabudi One",
                alamat = "Setiabudi One, Unit B 211, Jl. H. R. Rasuna Said No.Kav. 62 18, RT.18/RW.2, Kuningan, Karet Kuningan, Kecamatan Setiabudi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12920",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Kota Kasablanka",
                alamat = "Kota Kasablanka, Kota Kasablanka (The Common Unit GF-FSG 07, Jl. Raya Casablanca No.88, RT.2/RW.14, Menteng Dalam, Kec. Tebet, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12870",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Tempo Scan Towewr",
                alamat = ">No.Kav3, Tempo Scan Tower Basement Level, Jl. H. R. Rasuna Said No.4, RT.5/RW.4, Kuningan Tim., Kecamatan Setiabudi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12950",
                ket = "Jam Oprasional"
            )
        )
        list.add(Outlet(
            logo1 = R.drawable.brand2,
            logo2 = R.drawable.brand3,
            logo3 = R.drawable.brand5,
            nama = "Menara Karya",
            alamat = "Jl. H. R. Rasuna Said, RT.1/RW.2, Kuningan, Kuningan Tim., Kecamatan Setiabudi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12950",
            ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Mangkuluhur City",
                alamat = "Hana Lounge, Mangkuluhur City D, Jl. Gatot Subroto No.Kav. 1–3, RT.1/RW.4, Karet Semanggi, Kecamatan Setiabudi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 129",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Central Grand Indonesia 2nd Floor",
                alamat = "Central Grand Indonesia, Jl. Tlk. Betung I 2nd Floor, Kb. Melati, Kecamatan Tanah Abang, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10230",
                ket = "Jam Oprasional"
            )
        )
        list.add(
            Outlet(
                logo1 = R.drawable.brand2,
                logo2 = R.drawable.brand3,
                logo3 = R.drawable.brand5,
                nama = "Skyline Building",
                alamat = "Skyline Building, Jl. M.H. Thamrin No.9 2, RT.2/RW.1, Kb. Sirih, Kec. Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10230",
                ket = "Jam Oprasional"
            )
        )
        return list
    }
}