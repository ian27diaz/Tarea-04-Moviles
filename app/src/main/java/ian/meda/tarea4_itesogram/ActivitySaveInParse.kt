package ian.meda.tarea4_itesogram

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.parse.Parse
import com.parse.ParseObject
import com.parse.ParseQuery

import kotlinx.android.synthetic.main.activity_save_in_parse.*
import org.jetbrains.anko.doAsync

class ActivitySaveInParse : AppCompatActivity() {
    data class Tarea(var expediente : String, var value : String)

    private lateinit var mButton: Button
    private lateinit var mButton2: Button
    private lateinit var mValue: TextView;
    private lateinit var mValue2: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_in_parse)

        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("v1kx8QckHwFoOhVF6JqOIkY77Y3ancPhksQnt4k6")
                .clientKey("fVER38fcRHHMHtrS10xq8BnTAsQdrDKvoXSR3maP")
                .server("https://parseapi.back4app.com/")
                .build())

        mButton = findViewById(R.id.activity_saveInParse_guardarEnParse_button)
        mValue = findViewById(R.id.activity_saveInParse_valorInParse)
        mButton2 = findViewById(R.id.activity_saveInParse_obtenerValor_button)
        mValue2 = findViewById(R.id.activity_saveInParse_textview_noSeHaPodido)
        mButton.setOnClickListener{
            var value = mValue.text.toString()

            val studentObject = ParseObject("Tarea")
            studentObject.put("expediente", "is710007");
            studentObject.put("valor", value)
            studentObject.saveInBackground()
            mValue.text = ""
            mValue2.text = value
        }

        mButton2.setOnClickListener {
            val query = ParseQuery<ParseObject>("Tarea")

            query.whereEqualTo("expediente", "is710007")
            query.addDescendingOrder("createdAt")
            query.getFirstInBackground{ obj, e ->
                if(e == null)
                    mValue.text = obj["valor"] as String
                else
                    error {e}
            }
        }
    }

}
