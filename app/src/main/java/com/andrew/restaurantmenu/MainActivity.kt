package com.andrew.restaurantmenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var listOfFoods = ArrayList<Foods>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Load foods
        listOfFoods.add(Foods("Chicken","Chicken is prepared with salt onions deep fried", R.drawable.chicken))
        listOfFoods.add(Foods("Pizza", "This is a hawaiian pork pizza", R.drawable.pizzar))
        listOfFoods.add(Foods("Muchomo", "This is road side roasted meat from Kikoni", R.drawable.muchomo))
        listOfFoods.add(Foods("Rolex", "Some fried eggs rolled in a Chapatti ", R.drawable.rollex))
        listOfFoods.add(Foods("French fries", "Dry salted fries with vinegar ", R.drawable.french_fries))
        listOfFoods.add(Foods("Honey", "Sweet honey harvested from our local bee hives ", R.drawable.honey))
        listOfFoods.add(Foods("Strawberry Icecream", "Vanilla icecream base and a religious topping of strawberry flavour ", R.drawable.strawberry_ice_cream))

        adapter = FoodAdapter(this, listOfFoods)
        //Assign list to the gridview
        findViewById<GridView>(R.id.gvfoodlist). adapter = adapter
    }
    class FoodAdapter:BaseAdapter {
        var listOfFoods= ArrayList<Foods>()
        var context:Context?=null
        constructor(context:Context,listOfFoods:ArrayList<Foods>):super(){
            this.context=context
            this.listOfFoods=listOfFoods
        }
        override fun getCount(): Int {

            return listOfFoods.size
        }
        override fun getItem(p0: Int): Any {
            return listOfFoods[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFoods[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView= inflator.inflate(R.layout.foodticket,null)
            foodView.findViewById<ImageView>(R.id.ivticketimage).setImageResource(food.image!!)
            foodView.setOnClickListener {

                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.findViewById<TextView>(R.id.foodticket).text =  food.name!!
            return  foodView

        }
    }
}