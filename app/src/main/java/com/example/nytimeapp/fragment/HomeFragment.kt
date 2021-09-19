package com.example.nytimeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimeapp.R
import com.example.nytimeapp.adapter.ArticlesAdapter
import com.example.nytimeapp.dao.response.ArticleResponse
import com.example.nytimeapp.dao.response.ArticleResultModel
import com.example.nytimeapp.databinding.FragmentHomeBinding
import com.example.nytimeapp.listener.OnArticleItemClick
import com.example.nytimeapp.network.ApiHelper
import com.example.nytimeapp.network.NStatus
import com.example.nytimeapp.network.Resource
import com.example.nytimeapp.network.RetrofitBuilder
import com.example.nytimeapp.util.Const
import com.example.nytimeapp.util.CustomProgressBar
import com.example.nytimeapp.util.showToast
import com.example.nytimeapp.viewModel.SharedViewModel
import com.example.nytimeapp.viewModel.MainApiViewModel
import com.example.nytimeapp.viewModel.ViewModelFactoryUM
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment(), OnArticleItemClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var articlesAdapter: ArticlesAdapter
    private var binding: FragmentHomeBinding? = null
    private lateinit var mViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        articlesAdapter = ArticlesAdapter(mViewModel.getArticles(), this@HomeFragment)
        binding?.rvTimes?.apply {
            layoutManager = LinearLayoutManager(
                binding?.rvTimes?.context
            )
            adapter = articlesAdapter
        }
        getArticlesList()
    }

    private fun getArticlesList() {
        (getViewModel() as MainApiViewModel).getArticleList().observe(
            viewLifecycleOwner, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        NStatus.LOADING -> {
                            showLoading(true)
                        }
                        NStatus.SUCCESS -> {
                            showLoading(false)
                            postSuccessResponse(resource)
                        }
                        NStatus.ERROR -> {
                            showLoading(false)
                            showToast("error in getting data")
                        }
                    }
                }
            }
        )
    }


    private fun postSuccessResponse(resource: Resource<Response<ArticleResponse>>) {

        when {
            resource.data?.isSuccessful == true -> {
                resource.data.body()?.results?.let {
                    mViewModel.setArticles(it)
                    articlesAdapter.notifyDataSetChanged()
                }
            }

            resource.data?.isSuccessful == false -> {
                activity?.let {
                    showToast(resource.data.errorBody().toString())
                }
            }
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(resultModel: ArticleResultModel) {
        val bundle = bundleOf(
            Const.ARTICLE_ITEM to resultModel
        )
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }


}