package com.example.project

import android.R
import android.annotation.SuppressLint
import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import android.net.wifi.WifiConfiguration.GroupCipher.strings
import android.net.wifi.WifiConfiguration.KeyMgmt.strings
import android.net.wifi.WifiConfiguration.PairwiseCipher.strings
import android.net.wifi.WifiConfiguration.Status.strings
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.findNavController
import com.example.project.databinding.TourInformationBinding


class InfoFragment : Fragment() {
   private lateinit var binding :TourInformationBinding
   private lateinit var viewModel: ToursViewModel
    var pos:Int? = null


    @SuppressLint("SuspiciousIndentation")
     override  fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ToursViewModel::class.java)

        binding = TourInformationBinding.inflate(layoutInflater)

          pos = arguments?.getInt("amount")




         viewModel.readData.observe(viewLifecycleOwner, Observer { tourlist ->
             var datalist : List<Tours>? = null
             datalist = tourlist
             val formattedTip = String.format(binding.textView12.text.toString() ,datalist[pos!!].price_adult.toString(),datalist[pos!!].price_child.toString())

             binding.textView12.text = formattedTip
             binding.textView9.text = datalist[pos!!].name
             binding.textView14.text = datalist[pos!!].description
             val identifier=requireContext().resources.getIdentifier(datalist[pos!!].image1,"drawable",requireContext().getPackageName())
             binding.imageView2.setImageResource(identifier)
             val identifier1=requireContext().resources.getIdentifier(datalist[pos!!].image2,"drawable",requireContext().getPackageName())
             binding.imageView4.setImageResource(identifier1)
             val identifier2=requireContext().resources.getIdentifier(datalist[pos!!].image3,"drawable",requireContext().getPackageName())
             binding.imageView6.setImageResource(identifier2)
             val identifier3=requireContext().resources.getIdentifier(datalist[pos!!].image1,"drawable",requireContext().getPackageName())
             binding.imageView4.setOnClickListener(){
                 binding.imageView2.setImageResource(identifier1)
             }
             binding.imageView6.setOnClickListener(){
                 binding.imageView2.setImageResource(identifier2)
             }
             binding.imageView5.setOnClickListener(){
                 binding.imageView2.setImageResource(identifier3)
             }

             val r : String? = datalist[pos!!].rating
             if(r==null){
                 binding.rating.rating = 0f
             }
             else{
                 binding.rating.rating = r.toFloat()
             }
             binding.imageView5.setImageResource(identifier3)
             binding.button.setOnClickListener(){
                 val bundle = bundleOf("amount" to pos)
                 view?.findNavController()?.navigate(com.example.project.R.id.action_infoFragment2_to_bookingFragment,bundle)
             }
         })
        Log.d("oppopo",pos.toString())
        binding.button2.setOnClickListener(){

            if (pos != null) {
                Log.d("oppopo",pos.toString())
                val p = pos!! +1
                viewModel.updateData(1, p)
            }

        }
        binding.rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            Toast.makeText(requireContext(),"Rating:$rating",Toast.LENGTH_SHORT).show()
            binding.rating.rating = rating
            Log.d("kkk",binding.rating.rating.toString())
            val p = pos!! +1
            viewModel.updateRating(binding.rating.rating.toString(),p)
            viewModel.sort()
        }


        return binding.root



    }

}