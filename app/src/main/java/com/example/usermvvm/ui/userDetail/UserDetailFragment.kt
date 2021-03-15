package com.example.usermvvm.ui.userDetail

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.usermvvm.R
import com.example.usermvvm.ui.user.UsersViewModelFactory
import com.example.usermvvm.util.loadImage
import kotlinx.android.synthetic.main.user_detail_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class UserDetailFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: UsersDetailViewModelFactory by instance()

    private  val args by navArgs<UserDetailFragmentArgs>()
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this,factory).get(UserDetailViewModel::class.java)
        FullName_item.text = args.currentUser.firstName+ " "+args.currentUser.lastName
        Email_item.text = args.currentUser.email
        Mobile_item.text = args.currentUser.mobile
        Country_item.text = args.currentUser.country
        City_item.text = args.currentUser.city
        BirthDate_item.text =args.currentUser.birthDate
        loadImage(UserDetailImage_item,args.currentUser.avatar)

    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("second Fragment")
        //toto.text = args.currentUser.email
        println(args.testValue)
    }*/

}