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
        text2?.text = "Обычное одиночное нажатие на экран"
        text1!!.text = "onLongPress$e"
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        text2?.text = "Двойное нажатие на экран"
        text1!!.text = "onLongPress$e"
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        text2?.text = "Двойное нажатие и перемещение(подъем пальца и т.д.)"
        text1!!.text = "onLongPress$e"
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        text2?.text = "Палец прижат к экрану"
        text1!!.text = "onLongPress$e"
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        text2?.text = "Палец прижат к экрану"
        text1!!.text = "onLongPress$e"
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        text2?.text = "Свайп вверх"
        text1!!.text = "onLongPress$e"
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        text2?.text = "Прокрутка пальцем по экрану"
        text1!!.text = "onLongPress$e1+$e2"
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        text2?.text = "Долгое нажатие на экран"
        text1!!.text = "onLongPress$e"
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        text2?.text = "onFling"
        text1!!.text = "onLongPress$e1+$e2"
        return true
    }


}