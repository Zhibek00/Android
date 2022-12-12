package com.example.project

//noinspection SuspiciousImport
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project.databinding.MainPageBinding


class ToursFragment : Fragment(), SearchView.OnQueryTextListener {
    lateinit var binding: MainPageBinding
    private lateinit var viewModel: ToursViewModel
    lateinit var adapter : ArrayListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding = MainPageBinding.inflate(layoutInflater)
         viewModel = ViewModelProvider(this).get(ToursViewModel::class.java)

        //   setContentView(R.layout.main_page)
        val myDataset = DataSource().loadAffirmations()
        val recyclerView = binding.rec
        viewModel.topData.observe(viewLifecycleOwner, Observer { tourlist ->
            val adapter = RecycleAdapter(this , tourlist)
            recyclerView.adapter = adapter
         /*   adapter.onItemClick = {
                val intent = Intent(requireContext(), InfoFragment::class.java)
                intent.putExtra("affir", it)
                requireContext().startActivity(intent)
            }*/
        })

        recyclerView.setHasFixedSize(true)



        val listview = binding.list

        viewModel.readAllData.observe(viewLifecycleOwner, Observer { tourlist ->
             adapter = ArrayListAdapter(requireContext() as Activity,tourlist)
            adapter.setData(tourlist)
            listview.adapter = adapter

            //   listview.setScrollContainer(false);
        })



        binding.editV?.isSubmitButtonEnabled = true
            binding.editV?.setOnQueryTextListener(this)





            return binding.root

    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        // it will triggered when
        // we submit the written test
        return false
    }
    // this function will triggered when we
    // write even a single char in search view
    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return false
    }
    // We have just created this function for searching our database
    private fun searchDatabase(query: String) {
        // %" "% because our custom sql query will require that
        val searchQuery = "%$query%"
        val listview = binding.list
        viewModel.searchDatabase(searchQuery).observe(this, { list ->
            list.let {
                adapter = ArrayListAdapter(requireContext() as Activity,list)

                adapter.setData(it)

                listview.adapter = adapter
            }
        })
    }



fun getPackageName(): String? {
        return context?.packageName;

    }


}



