package com.example.alert



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.alert.Classes.ViewPagerAdapter
import com.example.alert.Fragments.FirstFragment
import com.example.alert.Fragments.SecondFragment
import com.example.alert.Fragments.ThirdFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tab_layout)

        viewPagerAdapter = ViewPagerAdapter(this)


        viewPagerAdapter.addFragment(FirstFragment(), "Chats")
        viewPagerAdapter.addFragment(SecondFragment(), "Status")
        viewPagerAdapter.addFragment(ThirdFragment(), "Calls")

        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()
    }
}
