package com.example.kopikenangan.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.kopikenangan.Adapter.BannerAdapter
import com.example.kopikenangan.Adapter.ListPromoAdapter
import com.example.kopikenangan.Adapter.VoucherAdapter
import com.example.kopikenangan.R
import com.example.kopikenangan.Adapter.SliderAdapter
import com.example.kopikenangan.DetailActivity
import com.example.kopikenangan.OrderFragment
import com.example.kopikenangan.databinding.FragmentHomeBinding
import com.example.kopikenangan.dataclass.Food
import com.example.kopikenangan.dataclass.Produk
import com.example.kopikenangan.dataclass.Promo
import com.example.kopikenangan.dataclass.Voucher
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import java.lang.Runnable

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2
    private lateinit var bannerSlider: ViewPager2
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    lateinit var rvPromo : RecyclerView
    lateinit var rvVoucher : RecyclerView
    lateinit var rvProduk : RecyclerView
    lateinit var rvMakanan : RecyclerView
    private val listProduk = ArrayList<Produk>()
    private val list = ArrayList<Promo>()
    private val listVoucher = ArrayList<Voucher>()
    private val listMakanan = ArrayList<Food>()
    private val delay = 3000L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        viewPager = binding.viewPager
        bannerSlider = binding.banner

//        dotsIndicator = binding.dotsIndicator

        //slider
        val imageList = listOf(
            R.drawable.kenangan1,
            R.drawable.kenangan2,
            R.drawable.kenangan3,
            R.drawable.kenangan4,
            R.drawable.kenangan5
        )
        val imageBanner = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        )
        //slider 1
        viewPager.adapter = SliderAdapter(imageList)
//        dotsIndicator.attachTo(viewPager)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.setPageTransformer { page, position ->
            page.alpha = 0.5f + (1 - Math.abs(position)) * 0.5f
            page.scaleX = 0.85f + (1 - Math.abs(position)) * 0.15f
            page.scaleY = 0.85f + (1 - Math.abs(position)) * 0.15f
        }

        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                if (viewPager.adapter != null) {
                    val nextPage = (viewPager.currentItem + 1) % imageList.size
                    viewPager.setCurrentItem(nextPage, true)
                }
                handler.postDelayed(this, 3000L)
            }
        }
        //slider 2
        bannerSlider.adapter = BannerAdapter(imageBanner)
        bannerSlider.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        bannerSlider.setPageTransformer { page, position ->
            page.alpha = 0.5f + (1 - Math.abs(position)) * 0.5f
            page.scaleX = 0.85f + (1 - Math.abs(position)) * 0.15f
            page.scaleY = 0.85f + (1 - Math.abs(position)) * 0.15f
        }

        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                if (bannerSlider.adapter != null) {
                    val nextPage = (bannerSlider.currentItem + 1) % imageBanner.size
                    bannerSlider.setCurrentItem(nextPage, true)
                }
                handler.postDelayed(this, 3000L)
            }
        }
        rvPromo = binding.rvPromo
        rvPromo.setHasFixedSize(true)
        list.clear()
        list.addAll(getListPromo())
        showRecyclerList()

        rvVoucher = binding.voucher
        rvVoucher.setHasFixedSize(true)
        listVoucher.clear()
        listVoucher.addAll(getListVoucher())
        showRecyclerVoucher()

        rvProduk = binding.rvProduk
        rvProduk.setHasFixedSize(true)
        listProduk.addAll(getListProduk())
        showRecyclerProduk()

        rvMakanan = binding.rvMakanan
        rvMakanan.setHasFixedSize(true)
        listMakanan.addAll(getListMakanan())
        showRecyclerMakanan()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.moreSpecial.setOnClickListener {
            val orderFragment = OrderFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, orderFragment) // Ganti dengan ID container Fragment
            transaction.addToBackStack(null) // Agar bisa kembali ke Fragment sebelumnya
            transaction.commit()
        }
        binding.btnCurhat.setOnClickListener{
            val wa = "689527146455"
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$wa")
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getListPromo(): ArrayList<Promo> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataHargaCoret = resources.getStringArray(R.array.data_harga_coret)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listPromo = ArrayList<Promo>()
        for (i in dataName.indices) {
            val promo = Promo(
                dataName[i],
                dataHargaCoret[i].toString(),
                dataHarga[i].toString(),
                dataPhoto.getResourceId(i, -1)
            )
            listPromo.add(promo)
        }
        return listPromo
    }
    private fun showRecyclerList() {
        rvPromo.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listPromoAdapter = ListPromoAdapter(list)
        rvPromo.adapter = listPromoAdapter
    }
    private fun showRecyclerVoucher() {
        rvVoucher.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listVoucherAdapter = VoucherAdapter(listVoucher)
        rvVoucher.adapter = listVoucherAdapter
    }
    private fun getListVoucher(): ArrayList<Voucher> {
        val dataKlaim = resources.getStringArray(R.array.klaim)
        val dataNominal = resources.getStringArray(R.array.nominal)
        val dataDeskripsi = resources.getStringArray(R.array.deskrip_voucher)

        val listVoucher = ArrayList<Voucher>()
        for (i in dataNominal.indices) {
            val voucher = Voucher(
                dataKlaim[i],
                dataNominal [i],
                dataDeskripsi [i]
            )
            listVoucher.add(voucher)
        }
        return listVoucher
    }
    private fun showRecyclerProduk(){
        rvProduk.layoutManager = GridLayoutManager(requireContext(),2)
        val listProdukAdapter = com.example.kopikenangan.Adapter.ProdukAdapter(listProduk)
        rvProduk.adapter = listProdukAdapter

    }
    private fun getListProduk(): ArrayList<Produk> {
        val dataName = resources.getStringArray(R.array.nama_produk)
        val dataHarga = resources.getStringArray(R.array.harga_produk)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_produk)

        val listProduk = ArrayList<Produk>()
        for (i in dataName.indices) {
            val produk = Produk(
                dataPhoto.getResourceId(i, -1),
                dataName[i],
                dataHarga[i]
            )
            listProduk.add(produk)
        }
        return listProduk
    }
    private fun showRecyclerMakanan() {
        rvMakanan.layoutManager = GridLayoutManager(requireContext(), 2)
        val listMakananAdapter = com.example.kopikenangan.Adapter.AdapterFood(listMakanan)
        rvMakanan.adapter = listMakananAdapter

    }
    private fun getListMakanan(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.nama_makanan)
        val dataHarga = resources.getStringArray(R.array.harga_makanan)
        val dataPhoto = resources.obtainTypedArray(R.array.foto_makanan)

        val listMakanan = ArrayList<Food>()
        for (i in dataName.indices) {
            val makanan = Food(
                dataPhoto.getResourceId(i, -1),
                dataName[i],
                dataHarga[i]
            )
            listMakanan.add(makanan)
        }
        return listMakanan
    }



    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, delay)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
        _binding = null
    }
}


