package com.sam43.mindvalleyimageloaderapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sam43.mindvalleyimageloaderapplication.R
import com.sam43.mindvalleyimageloaderapplication.model.GenericReS
import com.sam43.mindvalleyimageloaderapplication.utils.RecyclerAdapterUtil
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var root: View
    private val observeImageList = Observer<MutableList<GenericReS?>?> {
        showImageList(it)
        //TODO - Your Update UI Logic
        homeViewModel.cancelAllRequests()

    }
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initVM()
    }

    private fun initVM() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.fetchImagesFromServer()
        homeViewModel.unSplashedImagesLiveData.observe(viewLifecycleOwner, observeImageList)
    }

    private fun test(list: List<Int>) {
        RecyclerAdapterUtil.Builder(context!!, list, R.layout.pinterest_item)
            .viewsList(
                listOf(
                    R.id.tvUserName
                )
            )
            .bindView { _, item, _, innerViews ->
                val tvName = innerViews[R.id.tvUserName] as TextView
                tvName.text = item.toString()
            }
            .into(root.rvImageList)
        root.rvImageList.setHasFixedSize(true)
        root.rvImageList.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun showImageList(list: MutableList<GenericReS?>?) {
        list?.let {
            RecyclerAdapterUtil.Builder(context!!, it, R.layout.pinterest_item)
                .viewsList(
                    listOf(
                        R.id.ivImage,
                        R.id.fab,
                        R.id.tvCountHeart,
                        R.id.tvUserName,
                        R.id.tvCaption,
                        R.id.ivUserImage
                    )
                )
                .bindView { _, item, _, innerViews ->
                    val tvUserName = innerViews[R.id.tvCaption] as TextView
                    val ivUserProfile = innerViews[R.id.ivUserImage] as ImageView
                    val ivItemImage = innerViews[R.id.ivImage] as ImageView
                    val tvName = innerViews[R.id.tvUserName] as TextView
                    val tvCountHeart = innerViews[R.id.tvCountHeart] as TextView
                    val fab = innerViews[R.id.fab] as FloatingActionButton

                    fab.setOnClickListener {
                        /**
                         * set the liking condition and save it to session
                         * */
                    }
                    tvUserName.text = item?.resUser?.resUsername
                    tvName.text = item?.resUser?.resName
                    tvCountHeart.text = item?.resLikes.toString()
                }
                .into(root.rvImageList)
        }
        root.rvImageList.setHasFixedSize(true)
        root.rvImageList.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}