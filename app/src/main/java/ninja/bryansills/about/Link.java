package ninja.bryansills.about;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

class Link {
    @DrawableRes public int imageRes;
    @StringRes public int mainText;
    @StringRes public int subText;

    public Link(int imageRes, int mainText, int subText) {
        this.imageRes = imageRes;
        this.mainText = mainText;
        this.subText = subText;
    }
}
