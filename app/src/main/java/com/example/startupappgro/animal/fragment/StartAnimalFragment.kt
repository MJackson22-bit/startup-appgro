package com.example.startupappgro.animal.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.startupappgro.animal.AddMascotaActivity
import com.example.startupappgro.animal.AlimentacionActivity
import com.example.startupappgro.animal.AnimalGamesActivity
import com.example.startupappgro.databinding.FragmentStartAnimalBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartAnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartAnimalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentStartAnimalBinding? = null
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
        // Inflate the layout for this fragment
        _binding = FragmentStartAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivAdd.setOnClickListener {
            val intent = Intent(activity, AddMascotaActivity::class.java)
            startActivity(intent)
        }
        binding.cardDog.setOnClickListener {
            startActivity(Intent(activity, AlimentacionActivity::class.java))
        }
        binding.cardBird.setOnClickListener {
            startActivity(Intent(activity, AlimentacionActivity::class.java))
        }
        binding.cardCat.setOnClickListener {
            startActivity(Intent(activity, AlimentacionActivity::class.java))
        }
        binding.cardOther.setOnClickListener {
            startActivity(Intent(activity, AlimentacionActivity::class.java))
        }
        binding.cardCuidados.setOnClickListener {
            Snackbar.make(binding.ivAdd, "Esta opción aún no está disponible", Toast.LENGTH_SHORT)
                .show()
        }
        binding.constraintGame.setOnClickListener {
            startActivity(Intent(context, AnimalGamesActivity::class.java))
        }
        binding.cardSalud.setOnClickListener {
            Snackbar.make(binding.ivAdd, "Esta opción aún no está disponible", Toast.LENGTH_SHORT)
                .show()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StartAnimalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartAnimalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}