package com.example.usermvvm.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.usermvvm.R
import com.example.usermvvm.data.db.entities.ParcelableUser
import com.example.usermvvm.data.db.entities.User
import com.example.usermvvm.databinding.RecyclerviewUserBinding


class UserAdapter  (
        private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UsersViewHolder>(){

    override fun getItemCount() = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            UsersViewHolder(
                    DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.recyclerview_user,
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.recyclerviewUserBinding.user = users[position]
        holder.recyclerviewUserBinding.root.setOnClickListener {

            var CurrentUser = ParcelableUser(users[position].id,users[position].avatar,users[position].birthDate,users[position].city,users[position].company,users[position].country,users[position].email,users[position].firstName,users[position].jobPosition,users[position].lastName,users[position].mobile,users[position].role,users[position].username)
            var action = UserFragmentDirections.actionUsersFragmentToUserDetailFragment(CurrentUser)

            Navigation.findNavController(it).navigate(action)
        }

    }


    inner class UsersViewHolder(
            val recyclerviewUserBinding: RecyclerviewUserBinding
    ) : RecyclerView.ViewHolder(recyclerviewUserBinding.root)

}


