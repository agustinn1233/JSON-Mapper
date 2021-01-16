package com.agustinf1233.json_mapper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = "{ \"personas\" : [ " +
                "{" +
                " \"nombre\" : \"Marcos\" ," +
                " \"pais\" : \"México\" ," +
                " \"estado\" : \"soltero\" ," +
                " \"experiencia\" : 5}," +

                "{" +
                " \"nombre\" : \"Agustín\" ," +
                " \"pais\" : \"Uruguay\" ," +
                " \"estado\" : \"casado\" ," +
                " \"experiencia\" : 16}" +
                " ]" +
                " }"

        var listPersona: ArrayList<Persona>? = null

        // Json Native.

        val json = JSONObject(response)
        val person = json.getJSONArray("personas")
        listPersona = ArrayList()

        for (i in 0 until person.length()) {
            val name = person.getJSONObject(i).getString("nombre")
            val country = person.getJSONObject(i).getString("pais")
            val status = person.getJSONObject(i).getString("estado")
            val exp = person.getJSONObject(i).getInt("experiencia")

            //val persona = Persona(name,country,status,exp)
            listPersona.add(Persona(name,country,status,exp))

            //Log.d("JSON/NOMBRE", persona.nombre)


          // Json con GSON

            val gson = Gson()
            val res = gson.fromJson(response, PersonasGSON::class.java)
        }

    }
}