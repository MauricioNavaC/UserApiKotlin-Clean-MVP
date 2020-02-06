package dev.maui.userapi.userapi

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zeus.zcommon.util.genericshimmer.ZCommonGenericShimmer
import com.zeus.zcommon.util.genericshimmer.enums.ZCommonEViewType
import dev.maui.domain.results.model.Result
import dev.maui.mvp.BaseActivity
import dev.maui.userapi.App
import dev.maui.userapi.R
import dev.maui.userapi.userapi.di.component.DaggerResultsComponent
import kotlinx.android.synthetic.main.activity_userapi.*

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
            .into(clContainer)
    }

    override fun showUserData(result: Result) {
        mShimmer.stopGenericShimmer()
        Glide.with(this@UserAPIActivity)
            .load(result.picture?.large)
            .apply(RequestOptions.circleCropTransform())
            .into(ivUserPicture)
        tvUserName.text = result.name?.first.plus(" ").plus(result.name?.last)
    }

}