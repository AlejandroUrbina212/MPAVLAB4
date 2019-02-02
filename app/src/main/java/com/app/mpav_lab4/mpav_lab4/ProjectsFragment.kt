package com.app.mpav_lab4.mpav_lab4

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class ProjectsFragment: Fragment() {
    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_projects, container, false)
        val menu = arrayOf("Laboratorio 2", "Laboratorio 3")
        var strUrl = ""
        var strRepoTitle = ""
        val projectsAdapter = ArrayAdapter<String>(activity, R.layout.listview_item, menu)

        val projectsListView = view.findViewById<ListView>(R.id.projectsListView)

        projectsListView.adapter = projectsAdapter

        projectsListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val itemValue = projectsListView.getItemAtPosition(position) as String
            Toast.makeText(activity, "Abriendo: $itemValue en vista web", Toast.LENGTH_SHORT).show()
            if (position == 0){
                strUrl = "https://github.com/AlejandroUrbina212/MPAV_LAB2.git"
                strRepoTitle = "Repositorio Lab 2"
            } else {
                strUrl = "https://github.com/AlejandroUrbina212/MPAV_LAB3.git"
                strRepoTitle = "Repositorio Lab 3"
            }
            val bundle = Bundle()
            bundle.putString("repoUrl", strUrl)
            bundle.putString("repoTitle", strRepoTitle)
            val newWebViewFragment = WebViewFragment()
            newWebViewFragment.arguments = bundle
            val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, newWebViewFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return view

    }


}