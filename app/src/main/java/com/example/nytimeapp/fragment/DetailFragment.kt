package com.example.nytimeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nytimeapp.R
import com.example.nytimeapp.dao.response.ArticleResultModel
import com.example.nytimeapp.databinding.FragmentDetailBinding
import com.example.nytimeapp.databinding.FragmentHomeBinding
import com.example.nytimeapp.util.Const
import com.example.nytimeapp.viewModel.SharedViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : BaseFragment() {

    private var binding: FragmentDetailBinding? = null
    private lateinit var mViewModel: SharedViewModel
    private var articleResultModel: ArticleResultModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        binding?.lifecycleOwner = this.viewLifecycleOwner
        binding?.viewModel = mViewModel
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inIT()

    }

    private fun inIT() {
        arguments?.let {
            articleResultModel = it.getParcelable(Const.ARTICLE_ITEM)
            articleResultModel?.let { itArticle ->
                mViewModel.title.value = itArticle.title
                mViewModel.byLine.value = itArticle.byline
                mViewModel.publishDate.value = itArticle.published_date
                mViewModel.abstract.value = itArticle.abstract
                mViewModel.source.value = itArticle.source
            }
        }
    }

}