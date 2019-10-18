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
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sam43.mindvalleyimageloaderapplication.R
import com.sam43.mindvalleyimageloaderapplication.model.GenericReS
import com.sam43.mindvalleyimageloaderapplication.utils.RecyclerAdapterUtil
import com.sam43.mindvalleyimageloaderapplication.utils.loadImage
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
                .bindView { itemView, item, _, innerViews ->
                    val tvUserName = innerViews[R.id.tvCaption] as TextView
                    val ivUserProfile = innerViews[R.id.ivUserImage] as ImageView
                    val ivItemImage = innerViews[R.id.ivImage] as ImageView
                    val tvName = innerViews[R.id.tvUserName] as TextView
                    val tvCountHeart = innerViews[R.id.tvCountHeart] as TextView
                    val fab = innerViews[R.id.fab] as FloatingActionButton
                    var updatedCount = item?.resLikes
                    var flag = true

                    loadImage(
                        item?.resUser?.resProfileImage?.resMedium.toString(),
                        itemView,
                        ivUserProfile
                    )
                    loadImage(item?.resUrls?.resFull.toString(), itemView, ivItemImage)
                    tvUserName.text = item?.resUser?.resUsername
                    tvName.text = item?.resUser?.resName
                    tvCountHeart.text = updatedCount.toString()


                    updatedCount = if (item?.resLikedByUser!!) {
                        fab.setImageResource(R.drawable.ic_favorite_black)
                        updatedCount?.minus(1)
                    } else {
                        fab.setImageResource(R.drawable.ic_favorite_border)
                        updatedCount?.plus(1)
                    }

                    fab.setOnClickListener {
                        /**
                         * set the liking condition and save it to session
                         * */
                        when (flag) {
                            true -> {
                                fab.setImageResource(R.drawable.ic_favorite_black)
                                updatedCount = updatedCount?.plus(1)
                                flag = false
                            }
                            else -> {
                                fab.setImageResource(R.drawable.ic_favorite_border)
                                updatedCount = updatedCount?.minus(1)
                                flag = true
                            }
                        }
                        tvCountHeart.text = updatedCount.toString()
                    }
                }
                .into(root.rvImageList)
        }
        root.rvImageList.setHasFixedSize(true)
        root.rvImageList.layoutManager = LinearLayoutManager(context)
    }
}