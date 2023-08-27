package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String delims = delimiters.toString();
        StringTokenizer st = new StringTokenizer(source, delims);
        List <String> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }
}
