package com.minrd.gajang.view.fragment

import android.content.ContentValues.TAG
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.minrd.gajang.MainActivity
import com.minrd.gajang.R
import com.minrd.gajang.base.BaseFragment
import com.minrd.gajang.databinding.FragmentMyInfoBinding


class MyInfoFragment : BaseFragment<FragmentMyInfoBinding>(R.layout.fragment_my_info){
    override fun FragmentMyInfoBinding.onCreateView(){

    }

    override fun FragmentMyInfoBinding.onViewCreated(){
        val user = Firebase.auth.currentUser!!

        // 로그아웃 버튼 눌렀을 때 소셜 로그인을 로그아웃하고 파이어베이스에 기록된 계정 정보를 삭제
        binding.logOutButton.setOnClickListener {
            // 소셜 로그인 로그아웃
            Firebase.auth.signOut()
            // 파이어베이스에 있는 정보 삭제
            user.delete()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "User account deleted.")
                    }
                }
            // 로그인 창으로 이동
            findNavController().navigate(R.id.action_myInfoFragment_to_loginFragment)
        }
        // 거주지 변경 버튼 눌렀을 때 거주지 변경창으로 이동
        binding.changeLocationButton.setOnClickListener{
            findNavController().navigate(R.id.action_myInfoFragment_to_changeLivingFragment)
        }
        // 개인정보처리방침 버튼 눌렀을 때 개인정보처리 화면으로 이동
        binding.personalPrivacyButton.setOnClickListener{
            (activity as MainActivity).showPersonalPrivacy()
        }
        // 오픈소스라이선스 버튼 눌렀을 때 오픈소스라이브러리 화면 띄우기
        binding.openSourceLicense.setOnClickListener{
            (activity as MainActivity).showOssLicense()
        }
    }
}