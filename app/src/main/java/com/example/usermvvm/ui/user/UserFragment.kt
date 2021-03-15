package com.example.usermvvm.ui.user

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usermvvm.R
import com.example.usermvvm.util.Coroutines
import kotlinx.android.synthetic.main.recyclerview_user.*
import kotlinx.android.synthetic.main.user_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class UserFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: UsersViewModelFactory by instance()

    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this,factory).get(UserViewModel::class.java)
        // TODO: Use the ViewModel

        Coroutines.main {
            var users = viewModel.users.await()
            users.observe(viewLifecycleOwner , Observer {users1 ->
                recycler_view_users.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = UserAdapter(users1)
                }
            })
        }

    }

}






