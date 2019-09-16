package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.findFriend.FindFFollowFragment
import com.kliff.gullycricket.ui.fragments.findFriend.FindFInviteFragment

class FindFriendVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FindFFollowFragment()
            1 -> FindFInviteFragment()
            else -> FindFFollowFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "FOLLOW"
            1 -> "INVITE"
            else -> "FOLLOW"
        }
    }
}