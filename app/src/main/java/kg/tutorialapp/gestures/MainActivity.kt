package kg.tutorialapp.gestures


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat

class MainActivity() : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private var text1: TextView? = null
    private var text2: TextView? = null
    private var mDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)
        mDetector = GestureDetectorCompat(this, this)
        mDetector!!.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mDetector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        text2?.text = "Обычное одиночное нажатие на экран"          //+
        text1!!.text = ("onSingleTapConfirmed :" + e.toString())
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {          //
        text2?.text = "Двойное нажатие на экран"
        text1!!.text = ("onDoubleTap :" + e.toString())
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {                 //+
        text2?.text = "Двойное нажатие и перемещение(подъем пальца и т.д.)"
        text1!!.text = ("onDoubleTapEvent :" + e.toString())
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        text2?.text = "Палец прижат к экрану"
        text1!!.text = ("onDown :" + e.toString())
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        text2?.text = "Касание экрана пальцем без дополнительных действий"       //+
        text1!!.text = ("onShowPress :" + e.toString())
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        text2?.text = "Отжатие пальца от экрана"
        text1!!.text = ("onSingleTapUp :" + e.toString())
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {     //+
        text2?.text = "Прокрутка пальцем по экрану(пролистывание)"
        text1!!.text = ("onScroll :" + e1.toString() + e2.toString())
        return true
    }

    override fun onLongPress(e: MotionEvent?) {       //+
        text2?.text = "Долгое нажатие пальцем на экран"
        text1!!.text = ("onLongPress :" + e.toString())
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {      //+
        text2?.text = "Жест смахивания"
        text1!!.text = ("onFling :" + e1.toString() + e2.toString())
        return true
    }


}