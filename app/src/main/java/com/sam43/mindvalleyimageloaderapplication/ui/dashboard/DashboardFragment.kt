package com.sam43.mindvalleyimageloaderapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sam43.imageloader.MediaLoader
import com.sam43.mindvalleyimageloaderapplication.R
import com.sam43.mindvalleyimageloaderapplication.utils.getImageLoader
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            root.cancelImageOne -> {
                if (this::imageOneMediaLoader.isInitialized) {
                    imageOneMediaLoader.cancel()
                }
            }
            root.cancelImageTwo -> {
                if (this::imageTwoMediaLoader.isInitialized) {
                    imageTwoMediaLoader.cancel()
                }
            }
            root.cancelImageThree -> {
                if (this::imageThreeMediaLoader.isInitialized) {
                    imageThreeMediaLoader.cancel()
                }
            }
        }
    }

    private val sample = "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg"
    private lateinit var root: View
    private lateinit var dashboardViewModel: DashboardViewModel

    private lateinit var imageOneMediaLoader: MediaLoader<ImageView>
    private lateinit var imageTwoMediaLoader: MediaLoader<ImageView>
    private lateinit var imageThreeMediaLoader: MediaLoader<ImageView>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        onClickEvents()
        return root
    }

    private fun onClickEvents() {
        root.cancelImageOne.setOnClickListener(this)
        root.cancelImageTwo.setOnClickListener(this)
        root.cancelImageThree.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        imageOneMediaLoader = activity?.getImageLoader(sample, root.imageOne)!!
        imageTwoMediaLoader = activity?.getImageLoader(sample, root.imageTwo)!!
        imageThreeMediaLoader = activity?.getImageLoader(sample, root.imageThree)!!

        imageOneMediaLoader.download()
        imageTwoMediaLoader.download()
        imageThreeMediaLoader.download()
    }
}