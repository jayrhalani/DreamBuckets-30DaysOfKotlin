package com.harish.dreambuckets.ui.DashFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.tabs.TabLayout
import com.harish.dreambuckets.R
import com.harish.dreambuckets.adapters.TabFragmentPagerAdapter
import com.harish.dreambuckets.databinding.FragmentHomeBinding
import com.harish.dreambuckets.ui.activities.BucketAddActivity
import com.harish.dreambuckets.ui.tabs.DreamsTab
import com.harish.dreambuckets.ui.tabs.MemoriesTab

class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_home, container, false)


        binding.floatingAdd.setOnClickListener {
            val intent = Intent(activity, BucketAddActivity::class.java)
            startActivity(intent)
        }

        val pagerAdapter = TabFragmentPagerAdapter(
            requireActivity().supportFragmentManager,
            binding.tabLayout.tabCount
        )

        binding.homeviewPager.adapter = pagerAdapter

        binding.tabLayout.setupWithViewPager(binding.homeviewPager)

       /* binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> findNavController().navigate(R.id.dreamsTab)
                    1 -> findNavController().navigate(R.id.memoriesTab)
                }
            }


        })*/


        return binding.root
    }




}