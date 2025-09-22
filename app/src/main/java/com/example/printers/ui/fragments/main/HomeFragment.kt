package com.example.printers.ui.fragments.main

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.printers.R
import com.example.printers.data.MyConstants
import com.example.printers.data.amjad.AssessmentCardData
import com.example.printers.data.amjad.BannerData
import com.example.printers.data.amjad.MostUsedOffer
import com.example.printers.data.amjad.NewsData
import com.example.printers.data.amjad.OffersData
import com.example.printers.data.amjad.SurveysTabsData
import com.example.printers.data.shared_prefrances.SharedPrefs
import com.example.printers.databinding.ActivityHomeBinding
import com.example.printers.databinding.FragmentHomeBinding
import com.example.printers.ui.activities.amjad.GuideActivity
import com.example.printers.ui.adapter.amjad.home.AssessmentAdapter
import com.example.printers.ui.adapter.amjad.home.BannerRecyclerAdapter
import com.example.printers.ui.adapter.amjad.home.HrViewPagerAdapter
import com.example.printers.ui.adapter.amjad.home.MostUsedOffersAdapter
import com.example.printers.ui.adapter.amjad.home.NewsAdapter
import com.example.printers.ui.adapter.amjad.home.OffersAdapter
import com.example.printers.ui.adapter.amjad.home.ServeyTabRecyclerAdapter
import com.example.printers.ui.fragments.main.hrRequestsFragments.HrFragmentOne
import com.example.printers.ui.fragments.main.hrRequestsFragments.HrFragmentTwo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.jvm.java
import androidx.navigation.findNavController
import com.example.printers.ui.fragments.Notification
import com.example.printers.ui.NotificationReadEvent
import com.example.printers.ui.activities.amjad.NotificationActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
           binding.ivNotificationDot.visibility=View.GONE
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBannerRecycler()
        initHrViewPager()
        initAssessmentsRecycler()
        initSurveyRecycler()
        initNewsRecycler()
        initOffersRecycler()
        initMostUsedOffersRecycler()
        callBacks()
    }


    override fun onStart() {
        super.onStart()
        Log.d("HomeFragment", "onStart -> register event bus")
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    private fun callBacks() {
        binding.btLogOut.setOnClickListener {
            val sharedPrefs = SharedPrefs.getInstance(binding.root.context)
            sharedPrefs.write(MyConstants.IS_LOGIN,false)
            requireActivity().startActivity(Intent(requireContext(), GuideActivity::class.java))
            requireActivity().finish()
        }

        binding.ivNotificationBill.setOnClickListener {
            val intent = Intent(requireContext(), NotificationActivity::class.java)
            launcher.launch(intent)
        }


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNotificationRead(event: NotificationReadEvent) {
        Log.d("HomeFragment", "Sticky Event received -> hiding dot")
        binding.ivNotificationDot.visibility = View.GONE
    }

    private fun initMostUsedOffersRecycler() {
        val list = listOf(
            MostUsedOffer(
                R.drawable.offer_image, R.drawable.jarir, "خصم 25% على اجمالي ...", "مكتبة جرير"
            ), MostUsedOffer(
                R.drawable.offer_image1,
                R.drawable.othaim_logo,
                "عروض أسواق عبد الله ال...",
                "أسواق عبد الله العثيم"
            ), MostUsedOffer(R.drawable.offer_image2, R.drawable.helen, "خصومات حتى 50%", "نون")
        )

        binding.rvMostUsedOffer.adapter = MostUsedOffersAdapter(list)
        binding.rvMostUsedOffer.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvMostUsedOffer.setHasFixedSize(true)
        binding.rvMostUsedOffer.isNestedScrollingEnabled = false
    }


    private fun initOffersRecycler() {
        val list = listOf(
            OffersData(R.drawable.ic_restaurants, "مطاعم"),
            OffersData(R.drawable.ic_gifts, "هديه"),
            OffersData(R.drawable.ic_grocery, "مشتريات"),
            OffersData(R.drawable.ic_delivery, "توصيل"),
            OffersData(R.drawable.ic_education_training, "تعليم"),
            OffersData(R.drawable.ic_electronics, "الكترونيات"),
            OffersData(R.drawable.ic_hobbies, "هوايات"),
            OffersData(R.drawable.ic_jewelry, "مجوهرات"),
            OffersData(R.drawable.ic_cars, "سيارة"),

            )
        binding.rvOffers.adapter = OffersAdapter(list)
        binding.rvOffers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvOffers.setHasFixedSize(true)
        binding.rvOffers.isNestedScrollingEnabled = false
    }

    private fun initNewsRecycler() {
        val list = listOf(
            NewsData(
                img = R.drawable.banner1,
                text = "كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),
            NewsData(
                img = R.drawable.banner1,
                text = "كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),
            NewsData(
                img = R.drawable.banner1,
                text = "...كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),
            NewsData(
                img = R.drawable.banner1,
                text = "كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),
            NewsData(
                img = R.drawable.banner1,
                text = "كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),
            NewsData(
                img = R.drawable.banner1,
                text = "كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),
            NewsData(
                img = R.drawable.banner1,
                text = "كيف استفيد من برنامج أمجاد...",
                numberOfViews = "122"
            ),

            )
        binding.rvNews.adapter = NewsAdapter(list)
        binding.rvNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.isNestedScrollingEnabled = false
    }

    private fun initSurveyRecycler() {
        val list = listOf(
            SurveysTabsData(
                text = "أخبار الدار", number = "12"
            ),
            SurveysTabsData(
                text = "أخبار الدار", number = "12"
            ),
            SurveysTabsData(
                text = "أخبار الدار", number = "12"
            ),
            SurveysTabsData(
                text = "أخبار الدار", number = "12"
            ),
            SurveysTabsData(
                text = "أخبار الدار", number = "12"
            ),
            SurveysTabsData(
                text = "أخبار الدار", number = "12"
            ),
        )
        val adapter = ServeyTabRecyclerAdapter(list)
        binding.rvSurvey.adapter = adapter
        binding.rvSurvey.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSurvey.setHasFixedSize(true)
        binding.rvSurvey.isNestedScrollingEnabled = false
    }

    private fun initAssessmentsRecycler() {
        val list = listOf(
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "الذكاء العاطفي"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "القلق"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence,
                headText = "الصحة النفسيه العامة "
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence,
                headText = "الرضا عن الحياه"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "الاكتئاب "
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "جاهزيه المدير"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence,
                headText = "الرفاهيه النفسيه"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "الوسواس القهري"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "تقديرات الذات"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence,
                headText = "الدروس المهانيه"
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence, headText = "معنى الحياة "
            ),
            AssessmentCardData(
                img = R.drawable.illu_assessment_emotional_intelligence,
                headText = "التفكير الابداعي و الابتكار"
            ),
        )
        binding.rvAssessment.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvAssessment.adapter = AssessmentAdapter(list)
        binding.rvAssessment.setHasFixedSize(true)
        binding.rvAssessment.isNestedScrollingEnabled = false
    }


    private fun initHrViewPager() {
        binding.vpHrRequest.adapter = HrViewPagerAdapter(childFragmentManager, lifecycle)


        TabLayoutMediator(binding.tlHrViewPager, binding.vpHrRequest) { tab, position ->
            tab.setIcon(if (position == 0) R.drawable.dot_selected else R.drawable.dot_unselected)

        }.attach()

        // Optional: Add selection listener for additional customization
        binding.tlHrViewPager.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Handle tab selection
                tab?.setIcon(R.drawable.dot_selected)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselection
                tab?.setIcon(R.drawable.dot_unselected)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselection
            }
        })
    }


    private fun initBannerRecycler() {

        binding.rvBanner.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        val banners = listOf(
            BannerData(R.drawable.banner1),
            BannerData(R.drawable.banner2),
            BannerData(R.drawable.banner3)
        )

        binding.rvBanner.adapter = BannerRecyclerAdapter(banners)

        binding.rvBanner.setHasFixedSize(true)
        binding.rvBanner.isNestedScrollingEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
