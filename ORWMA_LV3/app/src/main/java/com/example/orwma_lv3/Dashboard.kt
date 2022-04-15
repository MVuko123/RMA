package com.example.orwma_lv3

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orwma_lv3.DTO.ToDo
import kotlinx.android.synthetic.main.activity_dashboard.*


class Dashboard : AppCompatActivity() {

    lateinit var dbHandler: DBHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(dashboard_toolbar)
        setTitle("Dashboard")
        dbHandler = DBHandler(this)
        rv_dashboard.layoutManager = LinearLayoutManager(this)

        fab_dashboard.setOnClickListener() {
            val dialog = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.dialog_dashboard, null)
            val toDoName = view.findViewById<EditText>(R.id.ev_todo)
            dialog.setView(view)
            dialog.setPositiveButton("Add") { _: DialogInterface, _: Int ->
                if (toDoName.text.isNotEmpty()) {
                    val toDo = ToDo()
                    toDo.name = toDoName.text.toString()
                    dbHandler.addToDo(toDo)
                    refreshList()
                }
            }
            dialog.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->

            }
            dialog.show()
        }
    }

        override fun onResume() {
            refreshList()
            super.onResume()
        }

        private fun refreshList(){
            rv_dashboard.adapter = DashboardAdapter(this,dbHandler.getToDos() )
        }


        class DashboardAdapter(val context: Context, val list: MutableList<ToDo>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>(){
            inner class ViewHolder(v:View) : RecyclerView.ViewHolder(v){
                val toDoName : TextView = v.findViewById(R.id.tv_todo_name)
            }

            override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
                return ViewHolder((LayoutInflater.from(context).inflate(R.layout.rv_child_dashboard, p0, false)))
            }

             override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
                    holder.toDoName.text = list[p1].name

                    holder.toDoName.setOnClickListener(){
                        val intent = Intent(context, ItemActivity::class.java)
                        intent.putExtra(INTENT_TODO_ID, list[p1].id)
                        intent.putExtra(INTENT_TODO_NAME, list[p1].name)
                        context.startActivity(intent)
                    }
             }

            override fun getItemCount(): Int {
                return list.size
            }




        }


    }



