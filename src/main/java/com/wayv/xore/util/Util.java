package com.wayv.xore.util;

import java.time.Duration;

public class Util {

    // Stolen from botrino.
    // https://github.com/Alex1304/botrino/blob/main/api/src/main/java/botrino/api/util/DurationUtils.java#L45
    public static String formatTime(Duration time) {
        final String result = (time.toDaysPart() > 0 ? time.toDaysPart() + "d " : "")
                + (time.toHoursPart() > 0 ? time.toHoursPart() + "h " : "")
                + (time.toMinutesPart() > 0 ? time.toMinutesPart() + "min " : "")
                + (time.toSecondsPart() > 0 ? time.toSecondsPart() + "s " : "")
                + (time.toMillisPart() > 0 ? time.toMillisPart() + "ms " : "");
        return result.isEmpty() ? "0ms" : result.substring(0, result.length() - 1);
    }
}
