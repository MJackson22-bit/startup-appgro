package com.example.startupappgro.plant.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.startupappgro.R
import com.example.startupappgro.adapter.AdapterPostCommunity
import com.example.startupappgro.databinding.FragmentCommunityBinding
import com.example.startupappgro.model.ModelPostCommunity
import com.example.startupappgro.provider.ProviderPostCommunity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nestedScroll.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY + 12 && binding.btnPost.isExtended) {
                binding.btnPost.shrink();
            }
            if (scrollY < oldScrollY - 12 && !binding.btnPost.isExtended) {
                binding.btnPost.extend();
            }
            if (scrollY == 0) {
                binding.btnPost.extend();
            }
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recycler = binding.rvPostCommunity
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AdapterPostCommunity(ProviderPostCommunity.postCommunityList){ post ->
            onItemSelected(post)
        }
    }

    private fun onItemSelected(post: ModelPostCommunity) {
        Snackbar.make(binding.btnPost, "Funcionalidad en desarrollo", Snackbar.LENGTH_SHORT).show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommunityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommunityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}