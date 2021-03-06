package dev.maui.userapi.userapi

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.zeus.zcommon.util.genericshimmer.ZCommonGenericShimmer
import com.zeus.zcommon.util.genericshimmer.enums.ZCommonEViewType
import dev.maui.domain.results.model.Result
import dev.maui.mvp.BaseActivity
import dev.maui.userapi.App
import dev.maui.userapi.R
import dev.maui.userapi.userapi.di.component.DaggerResultsComponent
import kotlinx.android.synthetic.main.activity_userapi.constraint_layout_container
import kotlinx.android.synthetic.main.activity_userapi.image_view_user_picture
import kotlinx.android.synthetic.main.activity_userapi.text_view_username
import kotlinx.android.synthetic.main.activity_userapi.text_view_cellphone
import kotlinx.android.synthetic.main.activity_userapi.text_view_email
import kotlinx.android.synthetic.main.activity_userapi.fragment_map
import kotlinx.android.synthetic.main.activity_userapi.swipe_refresh_layout

class UserAPIActivity: BaseActivity<UserAPIPresenter>(), UserAPIView {
    private lateinit var mShimmer: ZCommonGenericShimmer

    override fun getLayout(): Int = R.layout.activity_userapi

    override fun initInjector() {
        DaggerResultsComponent.builder()
                .appComponent((application as App).applicationComponent)
                .build()
                .inject(this)
    }

    override fun initElements() {
        mShimmer = ZCommonGenericShimmer.initGenericShimmer(this@UserAPIActivity)
            .appendItem(ZCommonEViewType.CARD_VIEW, 0, R.dimen.zc_150sdp, false)
            .appendItem(ZCommonEViewType.CARD_VIEW, 0, R.dimen.zc_400sdp, false)
            .into(constraint_layout_container)

        swipe_refresh_layout.setOnRefreshListener {
            presenter.refreshUser()
        }
    }

    override fun showUserData(result: Result) {
        if (swipe_refresh_layout.isRefreshing)
            swipe_refresh_layout.isRefreshing = false

        mShimmer.stopGenericShimmer()

        Glide.with(this@UserAPIActivity)
            .load(result.picture?.large)
            .apply(RequestOptions.circleCropTransform())
            .into(image_view_user_picture)
        text_view_username.text = result.name?.title.plus(". ").plus(result.name?.first).plus(" ").plus(result.name?.last)
        text_view_cellphone.text = result.cell
        text_view_email.text = result.email

        image_view_user_picture.setOnClickListener { presenter.disposeSubscriptions() }

        val mapFragment = fragment_map as SupportMapFragment
        val userPosition = result.location?.coordinates?.latitude?.toDouble()?.let { result.location?.coordinates?.longitude?.toDouble()?.let { it1 -> LatLng(it, it1) } }

        mapFragment.getMapAsync { googleMap ->
            googleMap.clear()
            googleMap.addMarker(userPosition?.let { MarkerOptions().position(it).title(result.name?.title.plus(". ").plus(result.name?.last).plus(" is here!")) })
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(userPosition))
        }
    }

}