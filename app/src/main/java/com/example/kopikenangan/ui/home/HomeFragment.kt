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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.kopikenangan.Adapter.AdapterFood
import com.example.kopikenangan.Adapter.BannerAdapter
import com.example.kopikenangan.Adapter.ListPromoAdapter
import com.example.kopikenangan.Adapter.ProdukAdapter
import com.example.kopikenangan.R
import com.example.kopikenangan.Adapter.SliderAdapter
import com.example.kopikenangan.Adapter.VoucherAdapter
import com.example.kopikenangan.order.OrderFragment
import com.example.kopikenangan.databinding.FragmentHomeBinding
import com.example.kopikenangan.dataclass.Food
import com.example.kopikenangan.dataclass.Produk
import com.example.kopikenangan.dataclass.Promo
import com.example.kopikenangan.dataclass.Voucher
import com.example.kopikenangan.response.Data
import com.example.kopikenangan.response.DataItem
import com.example.kopikenangan.response.DataItemFood
import com.example.kopikenangan.response.Item
import java.lang.Runnable

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2
    private lateinit var bannerSlider: ViewPager2
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var rvPromo : RecyclerView
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
//        rvPromo.setHasFixedSize(true)
//        list.clear()
//        list.addAll(getListPromo())
//        showRecyclerList()

        rvVoucher = binding.voucher
//        rvVoucher.setHasFixedSize(true)
//        listVoucher.clear()
//        listVoucher.addAll(getListVoucher())
//        showRecyclerVoucher()

        rvProduk = binding.rvProduk
//        rvProduk.setHasFixedSize(true)
//        listProduk.addAll(getListProduk())
//        showRecyclerProduk()

        rvMakanan = binding.rvMakanan
//        rvMakanan.setHasFixedSize(true)
//        listMakanan.addAll(getListMakanan())
//        showRecyclerMakanan()

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvPromo.layoutManager = layoutManager
        val itemDecoration = androidx.recyclerview.widget.DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.rvPromo.addItemDecoration(itemDecoration)


        val mainViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)

        mainViewModel.listPromo.observe(requireActivity()){promo ->
            setPromoData(promo)
        }
        mainViewModel.listVoucher.observe(requireActivity()){voucher ->
            setVoucherData(voucher)
        }
        mainViewModel.listDrink.observe(requireActivity()) { drink ->
            setDrinkData(drink)
        }
        mainViewModel.listFood.observe(requireActivity()) { food ->
            setFoodData(food)
        }

//        getPromo()
//        getVoucher()
//        getDrink()
//        getFood()

        return view
    }

//    private fun getFood(){
//        val client = ApiConfig2.getApi().getAllMakanan()
//        client.enqueue(object : Callback<FoodResponse>{
//            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
//                if (response.isSuccessful){
//                    val responseBody = response.body()
//                    if (responseBody != null)
//                        setFoodData(responseBody.data)
//                }else{
//                    Toast.makeText(requireContext(), "onFailure: ${response.message()}", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
//                Toast.makeText(requireContext(), "onFailure: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
    private fun setFoodData(data: List<DataItemFood>) {
        val adapter = AdapterFood()
        adapter.submitList(data)
        rvMakanan.layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvMakanan.adapter = adapter
    }

//    private fun getDrink() {
//        val client = ApiConfig2.getApi().getAllMinuman()
//        client.enqueue(object : Callback<DrinkResponse>{
//            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>) {
//                if (response.isSuccessful){
//                    val responseBody = response.body()
//                    if (responseBody != null)
//                        setDrinkData(responseBody.data)
//                }else{
//                    Toast.makeText(requireContext(), "onFailure: ${response.message()}", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//
//            override fun onFailure(call: Call<DrinkResponse>, t: Throwable) {
//                Toast.makeText(requireContext(), "onFailure: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
    private fun setDrinkData(data: List<Item>) {
        val adapter = ProdukAdapter()
        adapter.submitList(data)
        rvProduk.layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvProduk.adapter = adapter
    }

//    private fun getVoucher() {
//        val client = ApiConfig.getApiService().getAllVoucher()
//        client.enqueue(object : Callback<VoucherResponse>{
//            override fun onResponse(call: Call<VoucherResponse>, response: Response<VoucherResponse>) {
//                if (response.isSuccessful){
//                    val responseBody = response.body()
//                    if (responseBody != null)
//                        setVoucherData(responseBody.data)
//                }else{
//                    Log.e(TAG, "onFailure: ${response.message()}")
//                }
//            }
//            override fun onFailure(call: Call<VoucherResponse>, t: Throwable) {
//                Toast.makeText(requireContext(), "onFailure: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
    private fun setVoucherData(response: List<Data>) {
        val adapter = VoucherAdapter()
        adapter.submitList(response)
        rvVoucher.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.voucher.adapter = adapter
    }

//    private fun getPromo() {
//        val client = ApiConfig.getApiService().getALlPromo()
//        client.enqueue(object : Callback<PromoResponse>{
//            override fun onResponse(call: Call<PromoResponse>, response: Response<PromoResponse>) {
//                if (response.isSuccessful){
//                    val responseBody = response.body()
//                    if (responseBody != null)
//                        setPromoData(responseBody.data)
//                }else{
//                    Toast.makeText(requireContext(), "onFailure: ${response.message()}", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//            override fun onFailure(call: Call<PromoResponse>, t: Throwable) {
//                Toast.makeText(requireContext(), "onFailure: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
    private fun setPromoData(data: List<DataItem>) {
        val adapter = ListPromoAdapter()
        adapter.submitList(data)
        rvPromo.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPromo.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.moreSpecial.setOnClickListener {
            val orderFragment = OrderFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, orderFragment)
            transaction.addToBackStack(null)
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
        binding.btnBaru.setOnClickListener {
            val orderFragment = OrderFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, orderFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnMakanan.setOnClickListener {
            val orderFragment = OrderFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, orderFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

//    private fun getListPromo(): ArrayList<Promo> {
//        val dataName = resources.getStringArray(R.array.data_name)
//        val dataHargaCoret = resources.getStringArray(R.array.data_harga_coret)
//        val dataHarga = resources.getStringArray(R.array.data_harga)
//        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
//
//        val listPromo = ArrayList<Promo>()
//        for (i in dataName.indices) {
//            val promo = Promo(
//                dataName[i],
//                dataHargaCoret[i].toString(),
//                dataHarga[i].toString(),
//                dataPhoto.getResourceId(i, -1)
//            )
//            listPromo.add(promo)
//        }
//        return listPromo
//    }
//    private fun showRecyclerList() {
//        rvPromo.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//        val listPromoAdapter = ListPromoAdapter(list)
//        rvPromo.adapter = listPromoAdapter
//    }
//    private fun showRecyclerVoucher() {
//        rvVoucher.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
////        val listVoucherAdapter = VoucherAdapter(listVoucher)
////        rvVoucher.adapter = listVoucherAdapter
//    }
//    private fun getListVoucher(): ArrayList<Voucher> {
//        val dataKlaim = resources.getStringArray(R.array.klaim)
//        val dataNominal = resources.getStringArray(R.array.nominal)
//        val dataDeskripsi = resources.getStringArray(R.array.deskrip_voucher)
//
//        val listVoucher = ArrayList<Voucher>()
//        for (i in dataNominal.indices) {
//            val voucher = Voucher(
//                dataKlaim[i],
//                dataNominal [i],
//                dataDeskripsi [i]
//            )
//            listVoucher.add(voucher)
//        }
//        return listVoucher
//    }
//    private fun showRecyclerProduk(){
//        rvProduk.layoutManager = GridLayoutManager(requireContext(),2)
//        val listProdukAdapter = com.example.kopikenangan.Adapter.ProdukAdapter(listProduk)
//        rvProduk.adapter = listProdukAdapter
//
//    }
//    private fun getListProduk(): ArrayList<Produk> {
//        val dataName = resources.getStringArray(R.array.nama_produk)
//        val dataHarga = resources.getStringArray(R.array.harga_produk)
//        val dataPhoto = resources.obtainTypedArray(R.array.photo_produk)
//
//        val listProduk = ArrayList<Produk>()
//        for (i in dataName.indices) {
//            val produk = Produk(
//                dataPhoto.getResourceId(i, -1),
//                dataName[i],
//                dataHarga[i]
//            )
//            listProduk.add(produk)
//        }
//        return listProduk
//    }
//    private fun showRecyclerMakanan() {
//        rvMakanan.layoutManager = GridLayoutManager(requireContext(), 2)
//        val listMakananAdapter = com.example.kopikenangan.Adapter.AdapterFood(listMakanan)
//        rvMakanan.adapter = listMakananAdapter
//
//    }
//    private fun getListMakanan(): ArrayList<Food> {
//        val dataName = resources.getStringArray(R.array.nama_makanan)
//        val dataHarga = resources.getStringArray(R.array.harga_makanan)
//        val dataPhoto = resources.obtainTypedArray(R.array.foto_makanan)
//
//        val listMakanan = ArrayList<Food>()
//        for (i in dataName.indices) {
//            val makanan = Food(
//                dataPhoto.getResourceId(i, -1),
//                dataName[i],
//                dataHarga[i]
//            )
//            listMakanan.add(makanan)
//        }
//        return listMakanan
//    }



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


