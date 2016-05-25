package com.gm;

import java.io.*;
import java.net.URL;


/**
 * Created by gm on 16-5-23.
 */
public class SolidReader {

    public void ReadHtml() throws java.io.IOException {

        ReadWebPage("http://10.10.10.30/emzbbs");
    }

    private void ReadWebPage(String pageUrl) throws IOException {
        URL oracle = new URL(pageUrl);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
