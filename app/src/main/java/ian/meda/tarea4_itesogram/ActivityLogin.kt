package ian.meda.tarea4_itesogram

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.parse.Parse
import org.jetbrains.anko.startActivity

import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin : AppCompatActivity() {
    private lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        mButton = findViewById(R.id.activity_login_iniciarsesion_button)

        mButton.setOnClickListener{
            startActivity<ActivitySaveInParse>()
        }
    }

}
