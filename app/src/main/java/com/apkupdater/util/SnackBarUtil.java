package com.apkupdater.util;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.apkupdater.R;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class SnackBarUtil {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	static public void make(
		Activity activity,
		String text
	) {
		try {
			if (text == null || text.isEmpty() || activity == null) {
				return;
			}

			final Snackbar bar = Snackbar.make(activity.findViewById(R.id.main_content), text, Snackbar.LENGTH_LONG);
			bar.setAction("CLOSE", new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					bar.dismiss();
				}
			}).show();
			View view = bar.getView();
			view.setBackgroundColor(ColorUtitl.getColorFromTheme(activity.getTheme(), R.attr.colorPrimary));
			TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
			tv.setTextColor(ColorUtitl.getColorFromContext(activity, android.R.attr.textColorPrimary));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
