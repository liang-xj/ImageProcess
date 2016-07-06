package processing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by Administrator on 2016/4/20.
 */
public class CheckProcess {
    private Bitmap mbitmap;
    public CheckProcess(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }


    public Bitmap flipHorizontalImage(Bitmap bmp, int flag)
    {
        if(flag == 0) { //水平翻转
            //定义9个值 否则数组越界 ArrayIndexOutOfBoundsException
            float[] floats = new float[] {
                    -1f, 0f, 0f,
                    0f, 1f, 0f,
                    0f, 0f, 1f
            };
            if(floats != null) {
                Matrix matrix = new Matrix();
                matrix.setValues(floats);
                return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
            }
        }
        else if(flag == 1) {
            return bmp;
        }
        return bmp;
    }

    /*
     * 3.图片垂直翻转
     * flag=0表示第一次翻转 flag=1表示翻转会原图 来回切换
     */
    public Bitmap flipVerticalImage(Bitmap bmp, int flag)
    {
        if(flag == 0) { //垂直翻转
            //定义9个值
            float[] floats = new float[] {
                    1f,  0f, 0f,
                    0f, -1f, 0f,
                    0f,  0f, 1f
            };
            if(floats != null) {
                Matrix matrix = new Matrix();
                matrix.setValues(floats);
                return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
            }
        }
        else if(flag ==1 ) {
            return bmp;
        }
        return bmp;
    }

    /*
     * 1.图片旋转 45度一次旋转
     * flag=1表示旋转45度 flag=2表示旋转90度 flag*45为度数
     */
    //旋转图片
    public Bitmap turnImage(Bitmap bmp, int flag)
    {
        Matrix matrix = new Matrix();
        int turnRotate = flag * 45;
        //选择角度 饶(0,0)点选择 正数顺时针 负数逆时针 中心旋转
        matrix.setRotate(turnRotate, bmp.getWidth()/2, bmp.getHeight()/2);
        Bitmap createBmp = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
        Canvas canvas = new Canvas(createBmp);
        Paint paint = new Paint();
        canvas.drawBitmap(bmp, matrix, paint);
        return createBmp;
    }

}


