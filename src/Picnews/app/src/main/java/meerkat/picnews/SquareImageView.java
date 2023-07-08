//package meerkat.picnews;
//
//import android.content.Context;
//import android.util.AttributeSet;
//
//import androidx.appcompat.widget.AppCompatImageView;
//
///**
// * Created by karan on 23/2/18.
// */
//
//public class SquareImageView extends AppCompatImageView {
//
//    // Inherited constructors
//
//    public SquareImageView(Context context) {
//        super(context);
//    }
//
//
//    public SquareImageView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//
//    public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }
//
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        // If one of the measures is match_parent, use that one to determine the size.
//        // If not, use the default implementation of onMeasure.
//        if(widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY) {
//            setMeasuredDimension(widthSize, widthSize);
//        } else if(heightMode == MeasureSpec.EXACTLY && widthMode != MeasureSpec.EXACTLY) {
//            setMeasuredDimension(heightSize, heightSize);
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }
//    }
//
//}
