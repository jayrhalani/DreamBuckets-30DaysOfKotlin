package com.harish.dreambuckets.ui.DashFragments

import android.app.ActivityOptions
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harish.dreambuckets.R
import com.harish.dreambuckets.adapters.HomeDisplayAdapter
import com.harish.dreambuckets.database.BucketList
import com.harish.dreambuckets.databinding.FragmentListCategoryBinding
import com.harish.dreambuckets.ui.activities.DetailedBucketActivity
import com.harish.dreambuckets.utilities.InjectorUtils
import com.harish.dreambuckets.viewmodels.BucketListViewModel

class ListCategoryFragment : Fragment(),HomeDisplayAdapter.OnItemSelectedListener {

    private lateinit var binding: FragmentListCategoryBinding
    private lateinit var viewModel: BucketListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_category,
                                            container, false)

        val factory = InjectorUtils.provideBucketListViewModel(requireActivity().applicationContext)
        val viewModel = ViewModelProvider(requireActivity(), factory).get(BucketListViewModel::class.java)

        val args = ListCategoryFragmentArgs.fromBundle(requireArguments())

        val adapter = HomeDisplayAdapter(requireContext(),viewModel,this)

        viewModel.getBucketsByCategory(args.category).observe(requireActivity(), Observer {
                buckets ->
            buckets?.let {
                if(buckets.isEmpty())
                    binding.emptyAnimation.visibility = View.VISIBLE
                else
                    binding.emptyAnimation.visibility = View.GONE
                adapter.setWords(it as MutableList<BucketList>)
            }
        })

        binding.apply {

            listcategoryRecyclerView.adapter = adapter
            listcategoryRecyclerView.setHasFixedSize(true)
            listcategoryRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        }

        return binding.root
    }

    override fun onItemSelected(position: Int,bucketID:Int,view:View) {
        val intent = Intent(activity, DetailedBucketActivity::class.java)
        intent.putExtra("bucketID",bucketID)
        intent.putExtra("AccompolishID",1)
        val options = ActivityOptions.makeSceneTransitionAnimation(
            activity,
            view,
            "shared_trans"
        )
        startActivity(intent, options.toBundle())
    }
}