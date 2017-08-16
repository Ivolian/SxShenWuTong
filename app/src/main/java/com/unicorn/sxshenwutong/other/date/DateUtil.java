package com.unicorn.sxshenwutong.other.date;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Pair;

import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;

import org.joda.time.DateTime;

import java.util.Locale;

public class DateUtil {

    public static void show(DateTime dateTime,FragmentManager fragmentManager, SublimePickerFragment.Callback callback){
        SublimePickerFragment pickerFrag = new SublimePickerFragment();
        pickerFrag.setCallback(callback);

        // Options
        Pair<Boolean, SublimeOptions> optionsPair = getOptions(dateTime);

//            if (!optionsPair.first) { // If options are not valid
//                Toast.makeText(Sampler.this, "No pickers activated",
//                        Toast.LENGTH_SHORT).show();
//                return;
//            }

        // Valid options
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUBLIME_OPTIONS", optionsPair.second);
        pickerFrag.setArguments(bundle);

//            pickerFrag.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        pickerFrag.show(fragmentManager, "SUBLIME_PICKER");

    }
    // Validates & returns SublimePicker options
   static Pair<Boolean, SublimeOptions> getOptions(DateTime dateTime) {
        SublimeOptions options = new SublimeOptions();
        int displayOptions = 0;
        options.setDateParams(dateTime.toCalendar(Locale.getDefault()));
        displayOptions |= SublimeOptions.ACTIVATE_DATE_PICKER;
//        if (cbTimePicker.isChecked()) {
//            displayOptions |= SublimeOptions.ACTIVATE_TIME_PICKER;
//        }

//        if (cbRecurrencePicker.isChecked()) {
//            displayOptions |= SublimeOptions.ACTIVATE_RECURRENCE_PICKER;
//        }
//        if (rbDatePicker.getVisibility() == View.VISIBLE && rbDatePicker.isChecked()) {
        options.setPickerToShow(SublimeOptions.Picker.DATE_PICKER);
//        } else if (rbTimePicker.getVisibility() == View.VISIBLE && rbTimePicker.isChecked()) {
//            options.setPickerToShow(SublimeOptions.Picker.TIME_PICKER);
//        } else if (rbRecurrencePicker.getVisibility() == View.VISIBLE && rbRecurrencePicker.isChecked()) {
//            options.setPickerToShow(SublimeOptions.Picker.REPEAT_OPTION_PICKER);
//        }
        options.setDisplayOptions(displayOptions);
        // Enable/disable the date range selection feature
        options.setCanPickDateRange(false);

        // Example for setting date range:
        // Note that you can pass a date range as the initial date params
        // even if you have date-range selection disabled. In this case,
        // the user WILL be able to change date-range using the header
        // TextViews, but not using long-press.

        /*Calendar startCal = Calendar.getInstance();
        startCal.set(2016, 2, 4);
        Calendar endCal = Calendar.getInstance();
        endCal.set(2016, 2, 17);

        options.setDateParams(startCal, endCal);*/

        // If 'displayOptions' is zero, the chosen options are not valid
        return new Pair<>(displayOptions != 0 ? Boolean.TRUE : Boolean.FALSE, options);
    }

}
